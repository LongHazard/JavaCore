package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClassStudent;
import model.Course;

public class ClassStudentDAO {
	public void add(ClassStudent c) throws SQLException {
		String sql = "INSERT INTO class_student(class_id, student_id) VALUE (?, ?)";

		Connection conn = JDBCConnection.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, c.getClassId());
		ps.setInt(2, c.getStudentId());

		ps.executeUpdate();

	}
	
	public void update(ClassStudent c) throws SQLException{
		String sql = "UPDATE class_student SET student_id = ? WHERE class_id=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(2, c.getClassId());
		ps.setInt(1, c.getStudentId());
		
		ps.executeUpdate();
	}
	
	public void delete(int id) throws SQLException{
		String sql = "DELETE FROM COURSE where ID=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);	
		ps.executeUpdate();
	}
	
	public List<Course> selectAll() throws SQLException{
		String sql = "SELECT id, name FROM course";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);

		 ResultSet rs =  ps.executeQuery();
		 
		 List<Course> courses = new ArrayList<Course>();
		 while(rs.next()) {
			 Course c = new Course();
			 c.setId(rs.getInt("id"));
			 c.setName(rs.getString("name"));
			 courses.add(c);
		 }
		 return courses;
		 
	}
}
