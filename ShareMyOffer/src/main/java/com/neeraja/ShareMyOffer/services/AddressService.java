package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.dto.AddressDTO;

public interface AddressService {
	
	List<AddressDTO> findAll();

	AddressDTO findById(int id);

	AddressDTO save(AddressDTO theAddressDTO);

	boolean deleteById(int id);

}
