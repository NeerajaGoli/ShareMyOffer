package com.neeraja.ShareMyOffer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.AddressRepository;
import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.entities.User;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address findById(int id) {
		Optional<Address> result = addressRepository.findById(id);
		Address address = null;
		if(result.isPresent()) {
			address = result.get();
		}
		else {
			throw new RuntimeException("Did not find a address");
		}
		return address;
	}

	@Override
	public Address save(Address theAddress) {
		addressRepository.save(theAddress);
		return theAddress;
	}

	@Override
	public boolean deleteById(int id) {
		addressRepository.deleteById(id);
		return true;
	}

	@Override
	public Address findByUser(User user) {
		return addressRepository.findByUser(user);
	}

	@Override
	public Address findByOffer(Offer offer) {
		return addressRepository.findByOffer(offer);
	}

}
