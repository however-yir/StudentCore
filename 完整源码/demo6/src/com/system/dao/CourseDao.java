package com.system.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.entity.Course;
import com.system.utils.DB;


public class CourseDao {
	Connection conn = null;
	DB dataBase = new DB();
	
	// 按照课程号进行查询
	public Course selectByCno(int cno) throws SQLException {
		conn = dataBase.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM course where Cno = " + cno;
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		Course course = new Course();
		while (true) {
			if (rs.next()) {
				course.setCnum(rs.getString("Cnum"));
				course.setCno(rs.getString("Cno"));
				course.setCname(rs.getString("Cname"));
				course.setCcredit(rs.getString("Ccredit"));
				course.setCtime(rs.getString("Ctime"));
			} else
				break;
		}
		conn.close();
		return course;

	}

	//课程信息
	public List<Course> courseRes() throws Exception {
		List<Course> courses = new ArrayList<>();
		Course course;
		conn = dataBase.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		stat = conn.createStatement();
		String sql = "SELECT * FROM course";
		rs = stat.executeQuery(sql);
		while (true) {
            if ( rs.next() ) {
				course = new Course();
            	course.setCnum( rs.getString("Cnum") );
            	course.setCno( rs.getString("Cno") );
            	course.setCname( rs.getString("Cname") );
            	course.setCcredit( rs.getString("Ccredit") );
            	course.setCtime( rs.getString("Ctime") );
            	courses.add(course);
            }else 
            	break;
        }
		conn.close();
		return courses;
	}
	
	//增加课程
	public boolean insert(String cno, String cname, String ccredit, String ctime) throws SQLException {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "SELECT * FROM course WHERE cno = '"+cno+"'";
			if ( stat.executeQuery(sql).next() ) {
				return false;
			}
			sql = "INSERT INTO course (cno,cname,ccredit,ctime)"
				 + " VALUES ( '"+cno+"','"+cname+"', '"+ccredit+"' ,'"+ctime+"')";
			if ( stat.executeUpdate(sql)==1 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
	//ɾ删除课程
	public boolean delete(String cno) throws SQLException  {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "DELETE FROM course WHERE cno = '"+cno+"' ";		
			if ( stat.executeUpdate(sql)==1 ){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return false;
	}
	
	//查询课程
	public Course select(String cno) throws SQLException  {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			stat = conn.createStatement();
			ResultSet rs = null;
			Course course = null;
			String sql = "SELECT * FROM course WHERE cno = '"+cno+"' ";		
			rs = stat.executeQuery(sql);
			if ( rs.next() ){			
				course = new Course();
				course.setCno( rs.getString("Cno") );
				course.setCname( rs.getString("Cname") );
				course.setCcredit( rs.getString("Ccredit") );
				course.setCtime( rs.getString("Ctime") );
				return course;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn.close();
		return null;
	}
	
	//更新课程
	public boolean update(String cno, String cname, String ccredit, String ctime) throws SQLException  {
		try {
			conn = dataBase.getConnection();
			Statement stat = null;
			stat = conn.createStatement();
			String sql = "UPDATE course SET Cno = '"+cno+"', Cname = '"+cname+"', Ccredit = '"+ccredit+"', Ctime = '"+ctime+"' "
					+ "WHERE Cno = '"+cno+"' ";		
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
