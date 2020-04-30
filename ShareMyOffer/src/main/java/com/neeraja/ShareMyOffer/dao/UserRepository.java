package com.neeraja.ShareMyOffer.dao;



import com.neeraja.ShareMyOffer.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByMobileNumber(String mobileNumber);
	
}

