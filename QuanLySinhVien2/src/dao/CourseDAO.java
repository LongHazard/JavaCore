package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseDAO {
	public void add(Course c) throws SQLException{
		String sql = "INSERT INTO course(ID, NAME) VALUE (?, ?)";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		
		ps.executeUpdate();
	}
	
	public void update(Course c) throws SQLException{
		String sql = "UPDATE COURSE SET NAME = ? WHERE ID=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, c.getName());
		ps.setInt(2, c.getId());
		
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
