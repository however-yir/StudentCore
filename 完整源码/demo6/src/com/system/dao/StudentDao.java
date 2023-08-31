package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.entity.Student;
import com.system.utils.DB;
import com.system.utils.PasswordUtil;

public class StudentDao {

	private final DB dataBase = new DB();

	// 学生登录
	public boolean LoginCheck(String sno, String spwd) throws SQLException {
		String sql = "SELECT Spwd FROM student WHERE Sno = ?";
		try (Connection conn = dataBase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, parseRequiredInt(sno, "Sno"));
			try (ResultSet rs = stmt.executeQuery()) {
				if (!rs.next()) {
					return false;
				}
				return PasswordUtil.verify(spwd, rs.getString("Spwd"));
			}
		} catch (NumberFormatException e) {
			throw new SQLException("Sno must be numeric", e);
		}
	}

	// 注册
	public boolean Register(String sno, String spwd) throws SQLException {
		String checkSql = "SELECT 1 FROM student WHERE Sno = ?";
		String insertSql = "INSERT INTO student (Sno, Sname, Sgender, Sage, Sclass, Smajor, Sdept, Spwd) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = dataBase.getConnection()) {
			boolean oldAutoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			try (PreparedStatement checkStmt = conn.prepareStatement(checkSql);
					PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
				int snoValue = parseRequiredInt(sno, "Sno");
				checkStmt.setInt(1, snoValue);
				try (ResultSet rs = checkStmt.executeQuery()) {
					if (rs.next()) {
						conn.rollback();
						return false;
					}
				}
				insertStmt.setInt(1, snoValue);
				insertStmt.setString(2, "student_" + snoValue);
				insertStmt.setString(3, "男");
				insertStmt.setInt(4, 18);
				insertStmt.setString(5, "default");
				insertStmt.setString(6, "undeclared");
				insertStmt.setString(7, "undeclared");
				insertStmt.setString(8, PasswordUtil.hash(spwd));
				insertStmt.executeUpdate();
				conn.commit();
				return true;
			} catch (Exception e) {
				rollbackQuietly(conn);
				if (e instanceof SQLException) {
					throw (SQLException) e;
				}
				throw new SQLException("Student registration failed", e);
			} finally {
				conn.setAutoCommit(oldAutoCommit);
			}
		} catch (NumberFormatException e) {
			throw new SQLException("Sno must be numeric", e);
		}
	}

	// 返回学生信息对象
	public List<Student> res() throws Exception {
		String sql = "SELECT Sno, Sname, Sgender, Sage, Sclass, Smajor, Sdept FROM student";
		List<Student> students = new ArrayList<>();
		try (Connection conn = dataBase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Student student = new Student();
				student.setSno(rs.getInt("Sno"));
				student.setName(rs.getString("Sname"));
				student.setGender(rs.getString("Sgender"));
				student.setAge(rs.getInt("Sage"));
				student.setClas(rs.getString("Sclass"));
				student.setMajor(rs.getString("Smajor"));
				student.setDept(rs.getString("Sdept"));
				students.add(student);
			}
		}
		return students;
	}

	private int parseRequiredInt(String value, String fieldName) {
		if (value == null || value.trim().isEmpty()) {
			throw new NumberFormatException(fieldName + " is blank");
		}
		return Integer.parseInt(value.trim());
	}

	private void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException ignore) {
		}
	}
}
