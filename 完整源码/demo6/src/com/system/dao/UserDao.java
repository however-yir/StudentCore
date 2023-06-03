package com.system.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.entity.Student;
import com.system.utils.DB;



public class UserDao {
	Connection conn = null;
	DB dataBase = new DB();
	//管理员登录
	public boolean LoginCheck(String id, String pwd) throws SQLException {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			ResultSet rs = null;
			stat = conn.createStatement();
			String sql = "SELECT * FROM admin WHERE Aid ='" + id + "' and Apwd = '" + pwd + "'";
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
	
	//管理员注册
	public boolean Register(String id, String name ,String pwd) throws SQLException {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			ResultSet rs = null;
			stat = conn.createStatement();
			String sql = "SELECT * FROM admin WHERE Aid ='" + id + "' and Apwd = '" + pwd + "'";
			rs = stat.executeQuery(sql);
			if (rs.next()){
				return false;
			}else{
				sql = "INSERT INTO admin VALUES ('" + id + "','" + name + "','" + pwd + "')";
				stat.executeUpdate(sql);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return true;
	}
	
	//返回学生信息对象列表
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
	
	//返回指定学生的信息
	public List<Student> Select(String sno, String name) throws Exception {
		List<Student> students = new ArrayList<>();
		Student student;
		conn = dataBase.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		stat = conn.createStatement();
		String sql = "SELECT * FROM student WHERE Sno ='"+sno+"' OR Sname = '"+name+"'";
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
	
	//录入学生信息
	public boolean insert(String sno, String name, String gender, String age, String clas , String major, String dept) throws SQLException {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "INSERT INTO student (sno,sname,sgender,sage,sclass,smajor,sdept)"
					+ " VALUES ( '"+sno+"','"+name+"', '"+gender+"' ,'"+age+"' ,'"+clas+"' ,'"+major+"' ,'"+dept+"')";
			if (stat.executeUpdate(sql) == 1) {
				return true;
			}
		} catch (Exception e) {

		}
		conn.close();
		return false;
	}
	
	//删除学生信息
	public boolean delete(String sno) throws SQLException  {
		int key = Integer.parseInt(sno);
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "DELETE FROM student WHERE sno = " + key;
			System.out.println(sql);
			if ( stat.executeUpdate(sql)==1 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
	//根据学号查询单个学生
	public Student select(String sno) throws SQLException {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			stat = conn.createStatement();
			ResultSet rs = null;
			Student stu = null;
			String sql = "SELECT * FROM student WHERE sno = '"+sno+"' ";		
			rs = stat.executeQuery(sql);
			if ( rs.next() ){			
				stu = new Student();
				stu.setSno( rs.getInt("Sno") );
				stu.setName( rs.getString("Sname") );
				stu.setGender( rs.getString("Sgender") );
				stu.setAge( rs.getInt("Sage") );
				stu.setClas( rs.getString("Sclass") );
				stu.setMajor(rs.getString("Smajor"));
				stu.setDept( rs.getString("Sdept") );
				return stu;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return null;
	}
	
	//更新学生信息
	public boolean update(String sno, String name, String gender, String age, String clas , String major, String dept) throws SQLException  {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "UPDATE student SET sno = '"+sno+"', sname = '"+name+"', sgender = '"+gender+"', sage = '"+age+"',"
					+ "sclass = '"+clas+"', smajor = '"+major+"', sdept = '"+dept+"' WHERE sno = '"+sno+"' ";		
			if ( stat.executeUpdate(sql)==1 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
}
