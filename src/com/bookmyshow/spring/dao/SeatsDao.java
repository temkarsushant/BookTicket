package com.bookmyshow.spring.dao;

import java.util.List;

import com.bookmyshow.spring.entity.Seats;

public interface SeatsDao {

	public void updateSeats(Seats theSeats);
	
	public List<Seats> getAllSeats();

	int getSeats();


}
