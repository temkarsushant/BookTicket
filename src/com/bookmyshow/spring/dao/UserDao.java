package com.bookmyshow.spring.dao;

import java.util.List;

import com.bookmyshow.spring.entity.User;

public interface UserDao {
	public List<User> getAllCustomers();

	public void saveCustomer(User theUser);
	
	public User getEmail(String email);

	void updateSeats(String email, int seats);
}
