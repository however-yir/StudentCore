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

public class UserDao {

	private static final String DEFAULT_STUDENT_PASSWORD = "123";
	private final DB dataBase = new DB();

	// 管理员登录
	public boolean LoginCheck(String id, String pwd) throws SQLException {
		String sql = "SELECT Apwd FROM admin WHERE Aid = ?";
		try (Connection conn = dataBase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, parseRequiredInt(id, "Aid"));
			try (ResultSet rs = stmt.executeQuery()) {
				if (!rs.next()) {
					return false;
				}
				return PasswordUtil.verify(pwd, rs.getString("Apwd"));
			}
		} catch (NumberFormatException e) {
			throw new SQLException("Aid must be numeric", e);
		}
	}

	// 管理员注册
	public boolean Register(String id, String name, String pwd) throws SQLException {
		String checkSql = "SELECT 1 FROM admin WHERE Aid = ?";
		String insertSql = "INSERT INTO admin (Aid, Aname, Apwd) VALUES (?, ?, ?)";
		try (Connection conn = dataBase.getConnection()) {
			boolean oldAutoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			try (PreparedStatement checkStmt = conn.prepareStatement(checkSql);
					PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
				checkStmt.setInt(1, parseRequiredInt(id, "Aid"));
				try (ResultSet rs = checkStmt.executeQuery()) {
					if (rs.next()) {
						conn.rollback();
						return false;
					}
				}
				insertStmt.setInt(1, parseRequiredInt(id, "Aid"));
				insertStmt.setString(2, name);
				insertStmt.setString(3, PasswordUtil.hash(pwd));
				insertStmt.executeUpdate();
				conn.commit();
				return true;
			} catch (Exception e) {
				rollbackQuietly(conn);
				if (e instanceof SQLException) {
					throw (SQLException) e;
				}
				throw new SQLException("Admin registration failed", e);
			} finally {
				conn.setAutoCommit(oldAutoCommit);
			}
		} catch (NumberFormatException e) {
			throw new SQLException("Aid must be numeric", e);
		}
	}

	// 返回学生信息对象列表
	public List<Student> res() throws Exception {
		String sql = "SELECT Sno, Sname, Sgender, Sage, Sclass, Smajor, Sdept FROM student";
		List<Student> students = new ArrayList<>();
		try (Connection conn = dataBase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				students.add(mapStudent(rs));
			}
		}
		return students;
	}

	// 返回指定学生的信息
	public List<Student> Select(String sno, String name) throws Exception {
		List<Student> students = new ArrayList<>();
		String trimmedNo = safeTrim(sno);
		String trimmedName = safeTrim(name);
		if (isBlank(trimmedNo) && isBlank(trimmedName)) {
			return students;
		}

		StringBuilder sql = new StringBuilder("SELECT Sno, Sname, Sgender, Sage, Sclass, Smajor, Sdept FROM student WHERE ");
		List<Object> params = new ArrayList<>();
		if (!isBlank(trimmedNo)) {
			sql.append("Sno = ?");
			params.add(parseRequiredInt(trimmedNo, "Sno"));
		}
		if (!isBlank(trimmedName)) {
			if (!params.isEmpty()) {
				sql.append(" OR ");
			}
			sql.append("Sname = ?");
			params.add(trimmedName);
		}

		try (Connection conn = dataBase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
			for (int i = 0; i < params.size(); i++) {
				Object value = params.get(i);
				if (value instanceof Integer) {
					stmt.setInt(i + 1, (Integer) value);
				} else {
					stmt.setString(i + 1, (String) value);
				}
			}
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					students.add(mapStudent(rs));
				}
			}
		}
		return students;
	}

	// 录入学生信息
	public boolean insert(String sno, String name, String gender, String age, String clas, String major, String dept)
			throws SQLException {
		String sql = "INSERT INTO student (Sno, Sname, Sgender, Sage, Sclass, Smajor, Sdept, Spwd) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = dataBase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, parseRequiredInt(sno, "Sno"));
			stmt.setString(2, name);
			stmt.setString(3, gender);
			stmt.setInt(4, parseRequiredInt(age, "Sage"));
			stmt.setString(5, clas);
			stmt.setString(6, major);
			stmt.setString(7, dept);
			stmt.setString(8, PasswordUtil.hash(DEFAULT_STUDENT_PASSWORD));
			return stmt.executeUpdate() == 1;
		} catch (NumberFormatException e) {
			throw new SQLException("Sno/Sage must be numeric", e);
		}
	}

	// 删除学生信息
	public boolean delete(String sno) throws SQLException {
		String sql = "DELETE FROM student WHERE Sno = ?";
		try (Connection conn = dataBase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, parseRequiredInt(sno, "Sno"));
			return stmt.executeUpdate() == 1;
		} catch (NumberFormatException e) {
			throw new SQLException("Sno must be numeric", e);
		}
	}

	// 根据学号查询单个学生
	public Student select(String sno) throws SQLException {
		String sql = "SELECT Sno, Sname, Sgender, Sage, Sclass, Smajor, Sdept FROM student WHERE Sno = ?";
		try (Connection conn = dataBase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, parseRequiredInt(sno, "Sno"));
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return mapStudent(rs);
				}
			}
			return null;
		} catch (NumberFormatException e) {
			throw new SQLException("Sno must be numeric", e);
		}
	}

	// 更新学生信息
	public boolean update(String sno, String name, String gender, String age, String clas, String major, String dept)
			throws SQLException {
		String sql = "UPDATE student SET Sname = ?, Sgender = ?, Sage = ?, Sclass = ?, Smajor = ?, Sdept = ? WHERE Sno = ?";
		try (Connection conn = dataBase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setInt(3, parseRequiredInt(age, "Sage"));
			stmt.setString(4, clas);
			stmt.setString(5, major);
			stmt.setString(6, dept);
			stmt.setInt(7, parseRequiredInt(sno, "Sno"));
			return stmt.executeUpdate() == 1;
		} catch (NumberFormatException e) {
			throw new SQLException("Sno/Sage must be numeric", e);
		}
	}

	private Student mapStudent(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setSno(rs.getInt("Sno"));
		student.setName(rs.getString("Sname"));
		student.setGender(rs.getString("Sgender"));
		student.setAge(rs.getInt("Sage"));
		student.setClas(rs.getString("Sclass"));
		student.setMajor(rs.getString("Smajor"));
		student.setDept(rs.getString("Sdept"));
		return student;
	}

	private void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException ignore) {
		}
	}

	private int parseRequiredInt(String value, String fieldName) {
		String trimmed = safeTrim(value);
		if (isBlank(trimmed)) {
			throw new NumberFormatException(fieldName + " is blank");
		}
		return Integer.parseInt(trimmed);
	}

	private String safeTrim(String value) {
		return value == null ? "" : value.trim();
	}

	private boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}
}
