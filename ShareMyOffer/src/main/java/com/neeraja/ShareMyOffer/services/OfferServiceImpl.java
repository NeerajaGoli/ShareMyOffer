package com.neeraja.ShareMyOffer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.OfferRepository;
import com.neeraja.ShareMyOffer.dto.OfferDTO;
import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.objectMappers.OfferMapper;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	@Autowired
	private OfferMapper offerMapper;
	
	@Override
	public List<OfferDTO> findAll() {
		List<Offer> offers = offerRepository.findAll();
		List<OfferDTO> offersDTO = new ArrayList<OfferDTO>();
		for(Offer offer : offers) {
			offersDTO.add(offerMapper.convertToDto(offer));
		}
		return offersDTO;
	}

	@Override
	public OfferDTO findById(int id) {
		Optional<Offer> offer = offerRepository.findById(id);
		OfferDTO offerDTO = null;
		if(offer.isPresent()) {
			offerDTO = offerMapper.convertToDto(offer.get());
		}
		else {
			throw new RuntimeException("Did not find a offer");
		}
		return offerDTO;
	}

	@Override
	public OfferDTO save(OfferDTO theOfferDTO) {
		Offer offer = offerMapper.convertToEntity(theOfferDTO);
		offerRepository.save(offer);
		return theOfferDTO;
	}

	@Override
	public boolean deleteById(int id) {
		offerRepository.deleteById(id);
		return true;
	}

}
