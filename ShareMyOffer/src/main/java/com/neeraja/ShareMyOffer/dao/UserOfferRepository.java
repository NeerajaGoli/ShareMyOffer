package com.neeraja.ShareMyOffer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraja.ShareMyOffer.entities.User;
import com.neeraja.ShareMyOffer.entities.UserOffer;

public interface UserOfferRepository extends JpaRepository<UserOffer, Integer> {
	
	public List<UserOffer> findByPurpose(String purpose);
	
	public List<UserOffer> findByUserAndPurpose(User user,String purpose);

}
