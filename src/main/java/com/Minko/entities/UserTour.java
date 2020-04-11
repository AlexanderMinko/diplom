package com.Minko.entities;

public class UserTour {
	private int userid;
	private int tourid;
	private String username;
	private String usersurname;
	private String tour;
	private int tours;
	
	public UserTour(int userid, int tourid) {
		this.userid = userid;
		this.tourid = tourid;
	}
	
	public UserTour(String username, String usersurname, String tour) {	
		this.username = username;
		this.usersurname = usersurname;
		this.tour = tour;
	}
	
	public UserTour() {
		
	}
	
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getTourid() {
		return tourid;
	}
	
	public void setTourid(int tourid) {
		this.tourid = tourid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsersurname() {
		return usersurname;
	}
	
	public void setUsersurname(String usersurname) {
		this.usersurname = usersurname;
	}
	
	public String getTour() {
		return tour;
	}
	
	public void setTour(String tour) {
		this.tour = tour;
	}
	
	public int getTours() {
		return tours;
	}
	
	public void setTours(int tours) {
		this.tours = tours;
	}
	
	@Override
	public String toString() {
		return "UserTour [username = " + username + ", usersurname = " + usersurname + ", tour = " + tour + "]";
	}
	
	public String toString2() {
		return "UserTour [username = " + username + ", usersurname = " + usersurname + ", tours = " + tours + "]";		
	}

}
