package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAO {
	
	public static void add(Student st) throws SQLException {
		String sql = "INSERT INTO STUDENT(person_id, student_code) VALUE (?, ?)";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, st.getId());
		ps.setString(2, st.getStudentCode());
		ps.executeUpdate();
	}
	
	public void update(Student st) throws SQLException {
		String sql = "UPDATE STUDENT SET student_code = ? WHERE  person_id=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, st.getStudentCode());
		ps.setInt(2, st.getId());

		ps.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM student WHERE PERSON_ID=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	public List<Student> selectAll() throws SQLException {
		String sql = "SELECT person_id, name, birthDate, student_code From student inner join person on student.person_id = person.id";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student st = new Student();
			st.setId(rs.getInt("person_id"));
			st.setName(rs.getString("name"));
			st.setBirthDate(rs.getDate("birthDate"));
			st.setStudentCode(rs.getString("student_code"));
			students.add(st);
		}
		return students;
	}

	public List<Student> searchName(String name) throws SQLException {
		String sql = "SELECT person_id, name, birthDate, student_code From student inner join person on student.person_id = person.id WHERE name LIKE ? ORDER BY NAME ASC ";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();

		List<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student st = new Student();
			st.setId(rs.getInt("person_id"));
			st.setName(rs.getString("name"));
			st.setBirthDate(rs.getDate("birthDate"));
			st.setStudentCode(rs.getString("student_code"));
			students.add(st);
		}
		return students;

	}
	
	//student code là unipue
	public Student get(String studentCode) throws SQLException {
		String sql = "SELECT person_id, name, birthDate, student_code From student inner join person on student.person_id = person.id WHERE student_code = ?  ";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, studentCode);
		ResultSet rs = ps.executeQuery();

	
		while (rs.next()) {
			Student st = new Student();
			st.setId(rs.getInt("person_id"));
			st.setName(rs.getString("name"));
			st.setBirthDate(rs.getDate("birthDate"));
			st.setStudentCode(rs.getString("student_code"));
			return st;
		}
		return null;
	}

}
