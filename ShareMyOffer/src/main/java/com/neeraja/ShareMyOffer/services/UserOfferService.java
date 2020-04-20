package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.UserOffer;

public interface UserOfferService {

	public List<UserOffer> findAll();

	public UserOffer findById(int id);

	public void save(UserOffer theUserOffer);

	public void deleteById(int id);
	
}
