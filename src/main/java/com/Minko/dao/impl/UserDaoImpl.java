package com.Minko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Minko.dao.UserDao;
import com.Minko.entities.User;
import com.Minko.tools.JDBConnector;

public class UserDaoImpl implements UserDao {
	private final static String CREATE_USER = "INSERT INTO users (user_name, user_surname, user_roleID"
			+ ", user_birthday, user_password, user_email, user_phone_number)" + " VALUES (?,?,?,?,?,?,?)";
	private final static String DELETE_USER = "DELETE FROM users WHERE userID = ?";
	private final static String SELECT_USER_BY_ID = "SELECT * FROM users WHERE userID = ?";
	private final static String SELECT_USER_BY_NAME_AND_SURNAME = "SELECT * FROM users WHERE user_name = ? AND user_surname = ?";

	private static UserDaoImpl instance;

	public static synchronized UserDaoImpl getInsatnce() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection connection = new JDBConnector().getConnection()) {
			ps = connection.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("userID"));I
				user.setName(rs.getString("user_name"));
				user.setSurname(rs.getString("user_surname"));
				user.setRole(rs.getInt("user_roleID"));
				user.setBirthday(rs.getString("user_birthday"));
				user.setPassword(rs.getString("user_password"));
				user.setEmail(rs.getString("user_email"));
				user.setPhonenumber(rs.getInt("user_phone_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public User getUserByNameAndSurname(String name, String surname) {
		User user = new User();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection connection = new JDBConnector().getConnection()) {
			ps = connection.prepareStatement(SELECT_USER_BY_NAME_AND_SURNAME);
			ps.setString(1, name);
			ps.setString(2, surname);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("userID"));
				user.setName(rs.getString("user_name"));
				user.setSurname(rs.getString("user_surname"));
				user.setRole(rs.getInt("user_roleID"));
				user.setBirthday(rs.getString("user_birthday"));
				user.setPassword(rs.getString("user_password"));
				user.setEmail(rs.getString("user_email"));
				user.setPhonenumber(rs.getInt("user_phone_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(String name, String surname, int role, String birthday, String password, String email, int phonenumber) {
		PreparedStatement ps = null;
		try (Connection connection = new JDBConnector().getConnection()) {
			ps = connection.prepareStatement(CREATE_USER);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setInt(3, role);
			ps.setString(4, birthday);
			ps.setString(5, password);
			ps.setString(6, email);
			ps.setInt(7, phonenumber);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		PreparedStatement ps = null;
		try (Connection connection = new JDBConnector().getConnection()) {
			ps = connection.prepareStatement(DELETE_USER);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
