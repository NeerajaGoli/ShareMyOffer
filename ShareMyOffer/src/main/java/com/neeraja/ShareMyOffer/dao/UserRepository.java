package com.neeraja.ShareMyOffer.dao;



import com.neeraja.ShareMyOffer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByMobileNumber(String mobileNumber);
	
}

