package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.User;

public interface UserService {

	public List<User> findAll();

	public User findById(int id);

	public void save(User theUser);

	public void deleteById(int id);
	
}
