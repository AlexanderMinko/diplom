package com.Minko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Minko.dao.TourDao;
import com.Minko.entities.Tour;
import com.Minko.tools.JDBConnector;

public class TourDaoImpl implements TourDao {
	private final static String CREATE_TOUR = "INSERT INTO tours(country, price, duration, hotelID, flightID) VALUES(?, ?, ?, ?, ?)";
	private final static String DELETE_TOUR = "DELETE FROM tours WHERE tourID = ?";
	private final static String SELECT_TOUR_BY_ID = "SELECT * FROM tours WHERE tourID = ?";
	
	private static TourDaoImpl instance;

	static synchronized TourDaoImpl getInsatnce() {
		if (instance == null) {
			instance = new TourDaoImpl();
		}
		return instance;
	}

	@Override
	public Tour getTourById(int id) {
		Tour tour = new Tour();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection connection = new JDBConnector().getConnection()) {
			ps = connection.prepareStatement(SELECT_TOUR_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				tour.setId(rs.getInt("tourID"));
				tour.setCountry(rs.getString("country"));
				tour.setPrice(rs.getInt("price"));
				tour.setDuration(rs.getInt("duration"));
				tour.setHotelid(rs.getInt("hotelID"));
				tour.setFlightid(rs.getInt("flightID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addTour(String country, int price, int duration, int hotelid, int flightid) {
		PreparedStatement ps = null;
		try (Connection connection = new JDBConnector().getConnection()) {
			ps = connection.prepareStatement(CREATE_TOUR);
			ps.setString(1, country);
			ps.setInt(2, price);
			ps.setInt(3, duration);
			ps.setInt(4, hotelid);
			ps.setInt(5, flightid);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteTour(int id) {
		PreparedStatement ps = null;
		try(Connection connection = new JDBConnector().getConnection()){
			ps = connection.prepareStatement(DELETE_TOUR);
			ps.setInt(1, id);
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
