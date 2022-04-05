package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Teacher;

public class TeacherDAO {
	public static void add(Teacher tc) throws SQLException {
		String sql = "INSERT INTO TEACHER(person_id, department) VALUE (?, ?)";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, tc.getId());
		ps.setString(2, tc.getDepartment());
		ps.executeUpdate();
	}

	public void update(Teacher tc) throws SQLException {
		String sql = "UPDATE TEACHER SET department = ? WHERE  person_id=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, tc.getDepartment());
		ps.setInt(2, tc.getId());

		ps.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM TEACHER WHERE PERSON_ID=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	public List<Teacher> selectAll() throws SQLException {
		String sql = "SELECT person_id, name, birthDate, department From teacher INNER JOIN person ON teacher.person_id = person.id";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Teacher> teachers = new ArrayList<Teacher>();
		while (rs.next()) {
			Teacher st = new Teacher();
			st.setId(rs.getInt("person_id"));
			st.setName(rs.getString("name"));
			st.setBirthDate(rs.getDate("birthDate"));
			st.setDepartment(rs.getString("department"));
			teachers.add(st);
		}
		return teachers;
	}

	public List<Teacher> searchName(String name) throws SQLException {
		String sql = "SELECT person_id, name, birthDate, department From teacher INNER JOIN person ON teacher.person_id = person.id WHERE name LIKE ? ORDER BY NAME ASC ";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();

		List<Teacher> teachers = new ArrayList<Teacher>();
		while (rs.next()) {
			Teacher st = new Teacher();
			st.setId(rs.getInt("person_id"));
			st.setName(rs.getString("name"));
			st.setBirthDate(rs.getDate("birthDate"));
			st.setDepartment(rs.getString("department"));
			teachers.add(st);
		}
		return teachers;

	}

	// student code là unipue
	public List<Teacher> get(String department) throws SQLException {
		String sql = "SELECT person_id, name, birthDate, department From teacher inner join person on teacher.person_id = person.id WHERE department = ?  ";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, department);
		ResultSet rs = ps.executeQuery();

		List<Teacher> teachers = new ArrayList<Teacher>();
		while (rs.next()) {
			Teacher st = new Teacher();
			st.setId(rs.getInt("person_id"));
			st.setName(rs.getString("name"));
			st.setBirthDate(rs.getDate("birthDate"));
			st.setDepartment(rs.getString("department"));
			teachers.add(st);
		}
		return teachers;
	}

}
