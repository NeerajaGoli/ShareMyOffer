package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Address;

public interface AddressService {
	
	public List<Address> findAll();

	public Address findById(int id);

	public void save(Address theAddress);

	public void deleteById(int id);

}
