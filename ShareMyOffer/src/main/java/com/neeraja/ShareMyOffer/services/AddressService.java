package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.entities.User;

public interface AddressService {
	
	List<Address> findAll();

	Address findById(int id);

	Address save(Address theAddress);

	boolean deleteById(int id);
	
	Address findByUser(User user);
	
	Address findByOffer(Offer offer);

}
