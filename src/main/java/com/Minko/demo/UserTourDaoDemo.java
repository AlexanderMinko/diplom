package com.Minko.demo;

import java.util.List;

import com.Minko.dao.UserTourDao;
import com.Minko.dao.impl.UserTourDaoImpl;
import com.Minko.entities.UserTour;

public class UserTourDaoDemo {
	public static int count = 2;
	public static void main(String[] args) {
	UserTourDao userTourDao = UserTourDaoImpl.getInstance();
	List<UserTour> userTour = userTourDao.getUserTourByUserid(count);
	for(int i = 0; i<count; i++) {
		System.out.println(userTour.get(i));
	}
	System.out.println("=============================================================");
	UserTourDao userTourDao2 = UserTourDaoImpl.getInstance();
	UserTour userTour2 = userTourDao2.getCountOfUserToursByUserid(1);
	System.out.println(userTour2.toString2());
	}
}
