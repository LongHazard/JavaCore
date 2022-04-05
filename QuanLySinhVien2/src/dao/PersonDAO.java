package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonDAO {
	public void add(Person p) throws SQLException {
		String sql = "INSERT INTO person (ID, NAME, BIRTHDATE) VALUE (?, ?, ?)";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, p.getId());
		ps.setString(2, p.getName());
		ps.setDate(3, new java.sql.Date(p.getBirthDate().getTime()));
		ps.executeUpdate();
	}

	public void update(Person p) throws SQLException {
		String sql = "UPDATE PERSON SET NAME = ?, BIRTHDATE = ? WHERE ID = ?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, p.getName());
		ps.setDate(2, new java.sql.Date(p.getBirthDate().getTime()));
		ps.setInt(3, p.getId());
		ps.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM PERSON where ID=?";
		Connection connection = JDBCConnection.getConn();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}
