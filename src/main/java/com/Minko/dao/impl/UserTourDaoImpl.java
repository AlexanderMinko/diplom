package com.Minko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Minko.dao.UserTourDao;
import com.Minko.entities.UserTour;
import com.Minko.tools.JDBConnector;

public class UserTourDaoImpl implements UserTourDao {
	private final static String GET_USER_TOUR_BY_USER_ID = "SELECT users.user_name, users.user_surname, tours.country as tour\r\n"
			+ "FROM users\r\n" + "JOIN users_tours\r\n" + "ON users_tours.userID = users.UserID\r\n" + "JOIN tours\r\n"
			+ "ON users_tours.tourID = tours.tourID\r\n" + "WHERE users.UserID = ?;";
	private final static String GET_COUNT_OF_USER_TOURS_BY_USER_ID = "SELECT user_name, user_surname, COUNT(tourID) as tours\r\n"
			+ "FROM users u\r\n" + "JOIN users_tours ut ON\r\n" + "ut.userID = u.userID\r\n" + "GROUP BY u.userID\r\n"
			+ "HAVING u.userID = ?;";
	
	private static UserTourDaoImpl instance;

	public static synchronized UserTourDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserTourDaoImpl();
		}
		return instance;
	}

	@Override
	public List <UserTour> getUserTourByUserid(int id) {
		List <UserTour> userTour = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try(Connection connection = new JDBConnector().getConnection()){
			ps = connection.prepareStatement(GET_USER_TOUR_BY_USER_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				userTour.add(new UserTour(rs.getString("user_name"),
						rs.getString("user_surname"),
						rs.getString("tour")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userTour;
	}

	@Override
	public UserTour getCountOfUserToursByUserid(int id) {
		UserTour userTour = new UserTour();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try(Connection connection = new JDBConnector().getConnection()){
			ps = connection.prepareStatement(GET_COUNT_OF_USER_TOURS_BY_USER_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				userTour.setUsername(rs.getString("user_name"));
				userTour.setUsersurname(rs.getString("user_surname"));
				userTour.setTours(rs.getInt("tours"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userTour;
	}

}
