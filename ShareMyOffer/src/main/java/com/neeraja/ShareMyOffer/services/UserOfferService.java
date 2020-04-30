package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.dto.OfferDTO;
import com.neeraja.ShareMyOffer.dto.UserDTO;
import com.neeraja.ShareMyOffer.dto.UserOfferDTO;

public interface UserOfferService {

	List<UserOfferDTO> findAll();

	UserOfferDTO findById(int id);

	UserOfferDTO save(UserDTO theUserDTO,OfferDTO theOfferDTO);

	boolean deleteById(int id);
	
	List<UserOfferDTO> findByPurpose(String purpose);
	
	List<UserOfferDTO> findByUserAndPurpose(UserDTO userDTO,String purpose);

	List<UserOfferDTO> findMyOffers(UserDTO userDTO,String purpose);
	
}
