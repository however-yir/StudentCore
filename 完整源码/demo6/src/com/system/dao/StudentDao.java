package com.system.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.entity.Student;
import com.system.utils.DB;

public class StudentDao {
	Connection conn = null;
	DB dataBase = new DB();
	//学生登录
	public boolean LoginCheck(String Sno, String Spwd) throws SQLException {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			ResultSet rs = null;
			stat = conn.createStatement();
			String sql = "SELECT * FROM student WHERE Sno ='"+Sno+"' and Spwd = '"+Spwd+"'";
			rs = stat.executeQuery(sql);
			if (rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
	//注册
	public boolean Register(String Sno ,String Spwd) throws SQLException {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			ResultSet rs = null;
			stat = conn.createStatement();
			String sql = "SELECT * FROM student WHERE Sno ='" + Sno + "' ";
			rs = stat.executeQuery(sql);
			if (rs.next()){
				return false;
			}else{
				sql = "INSERT INTO student VALUES ('" + Sno + "', '" + Spwd + "')";
				stat.executeUpdate(sql);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return true;
	}
	
	//返回学生信息对象
	public List<Student> res() throws Exception {
		List<Student> students = new ArrayList<>();
		Student student;
		conn = dataBase.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		stat = conn.createStatement();
		String sql = "SELECT * FROM student";
		rs = stat.executeQuery(sql);
		while (true) {
            if ( rs.next() ) {
				student = new Student();
                student.setSno( rs.getInt("Sno") );
                student.setName( rs.getString("Sname") );
                student.setGender( rs.getString("Sgender") );
                student.setAge( rs.getInt("Sage") );
                student.setClas( rs.getString("Sclass") );
                student.setMajor(rs.getString("Smajor"));
                student.setDept( rs.getString("Sdept") );
                students.add(student);
            }else 
            	break;
        }
		conn.close();
		return students;
	}

	
}
