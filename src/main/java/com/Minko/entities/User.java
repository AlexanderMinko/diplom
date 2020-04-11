package com.Minko.entities;

import java.util.List;

public class User {
	private int id;
	private String name;
	private String surname;
	private int role;
	private String birthday;
	private String password;
	private String email;
	private int phonenumber;
	
	
	public User(int id, String name, String surname, int role, String birthday, String password, String email,
			int phonenumber) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.birthday = birthday;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
	}
	
	public User() {
		
	}
	
	public int geId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name = " + name + ", surname = " + surname + ", role = " + role + ", birthday = " + birthday +
				", password = " + password + ", email = " + email + ", phonenumber = " + phonenumber + "]";
	}
	

}
