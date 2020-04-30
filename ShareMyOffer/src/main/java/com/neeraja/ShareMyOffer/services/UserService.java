package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.dto.AddressDTO;
import com.neeraja.ShareMyOffer.dto.UserDTO;

public interface UserService {

	List<UserDTO> findAll();

	UserDTO findById(int id);

	UserDTO save(UserDTO theUserDTO,AddressDTO theAddressDTO);

	boolean deleteById(int id);
	
	boolean isExists(String mobileNumber);
	
	UserDTO findByMobileNumber(String mobileNumber);
	
}
