package com.neeraja.ShareMyOffer.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.neeraja.ShareMyOffer.entities.Login;

public interface AuthService extends UserDetailsService {

	public List<Login> findAll();

	public Login findById(String userName);

	public void save(Login theLogin);

	public void deleteById(String userName);
	
}
