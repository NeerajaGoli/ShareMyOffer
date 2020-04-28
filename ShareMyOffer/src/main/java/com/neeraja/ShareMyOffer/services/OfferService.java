package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.dto.OfferDTO;

public interface OfferService {

	List<OfferDTO> findAll();

	OfferDTO findById(int id);

	OfferDTO save(OfferDTO theOfferDTO);

	boolean deleteById(int id);
	
}
