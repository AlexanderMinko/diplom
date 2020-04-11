package com.Minko.dao;

import java.util.List;

import com.Minko.entities.UserTour;

public interface UserTourDao {
	List<UserTour> getUserTourByUserid(int id);
	UserTour getCountOfUserToursByUserid(int id);

}
