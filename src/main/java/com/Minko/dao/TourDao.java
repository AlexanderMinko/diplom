package com.Minko.dao;

import com.Minko.entities.Tour;

public interface TourDao {
	Tour getTourById(int id);
	void addTour(String country, int price, int duration, int hotelid, int flightid);
	void deleteTour(int id);
}
