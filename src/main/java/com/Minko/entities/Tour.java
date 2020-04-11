package com.Minko.entities;

public class Tour {
	private int id;
	private String country;
	private int price;
	private int duration;
	private int hotelid;
	private int flightid;

	public Tour(int id, String country, int price, int duration, int hotelid, int flightid) {
		this.id = id;
		this.country = country;
		this.price = price;
		this.duration = duration;
		this.hotelid = hotelid;
		this.flightid = flightid;
	}
	
	public Tour() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public int getFlightid() {
		return flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	@Override
	public String toString() {
		return "Tour [id = " + id + ", country = " + country + ", price = " + price + ", duration = " + duration
				+ ", hotelid = " + hotelid + ", flightid = " + flightid + "]";
	}

}
