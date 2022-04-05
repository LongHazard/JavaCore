package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Clazz;
import model.Course;

public class ClazzDAO {
	public void add(Clazz c) throws SQLException {
		String sql = "INSERT INTO clazz(class_id, class_name, course_id) VALUE (?, ?, ?)";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		ps.setInt(3, c.getCourse().getId());

		ps.executeUpdate();
	}

	public void update(Clazz c) throws SQLException {
		String sql = "UPDATE CLAZZ SET class_name = ?, course_id = ? WHERE class_id=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, c.getName());
		ps.setInt(2, c.getCourse().getId());
		ps.setInt(3, c.getId());

		ps.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM CLAZZ where class_id=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	public List<Clazz> selectAll() throws SQLException {
		String sql = "SELECT class_id, class_name, course_id FROM clazz";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Clazz> clazzs = new ArrayList<Clazz>();
		while (rs.next()) {
			Clazz c = new Clazz();
			c.setId(rs.getInt("class_id"));
			c.setName(rs.getString("class_name"));
			Course course = new Course();
			course.setId(rs.getInt("course_id"));
			c.setCourse(course);
			clazzs.add(c);
		}
		return clazzs;
	}

	public List<Clazz> searchByCourseName(String courseName) throws SQLException {
		String sql = "SELECT cl.class_id, cl.class_name, cl.course_id, c.name FROM clazz cl INNER JOIN course c ON cl.course_id = c.id WHERE c.name = ?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, courseName);
		ResultSet rs = ps.executeQuery();
		List<Clazz> clazzs = new ArrayList<Clazz>();
		while (rs.next()) {
			Clazz c = new Clazz();
			c.setId(rs.getInt("class_id"));
			c.setName(rs.getString("class_name"));
			Course course = new Course();
			course.setId(rs.getInt("course_id"));
			course.setName(rs.getString("name"));
			c.setCourse(course);
			clazzs.add(c);
		}
		return clazzs;
	}

}
