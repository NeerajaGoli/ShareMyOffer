package com.neeraja.ShareMyOffer.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.neeraja.ShareMyOffer.dto.LoginDTO;

public interface LoginService extends UserDetailsService {
	
	List<LoginDTO> findAll();

	LoginDTO findById(String userName);

	LoginDTO save(LoginDTO theLoginDTO);

	boolean deleteById(String userName);

}
