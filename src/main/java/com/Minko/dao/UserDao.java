package com.Minko.dao;

import com.Minko.entities.User;

public interface UserDao {
	
	User getUserById(int id);
	User getUserByNameAndSurname(String name, String surname);
	void addUser(String name, String surname, int role, String birthday, String password, String email, int phonenumber);
	void deleteUser(int id);
	

}
