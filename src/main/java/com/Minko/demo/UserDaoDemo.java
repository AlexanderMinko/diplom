package com.Minko.demo;

import com.Minko.dao.UserDao;
import com.Minko.dao.impl.UserDaoImpl;
import com.Minko.entities.User;

public class UserDaoDemo {
	public static void main(String[] args) {
	UserDao userDao = UserDaoImpl.getInsatnce();	
	//userDao.addUser("Vasilii", "Zhigalo", 3, "1994", "123", "vasya@i.ua", 345);
	User user = userDao.getUserByNameAndSurname("Alex", "Lesli");
	System.out.println(user);
	}
}
