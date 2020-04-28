package com.neeraja.ShareMyOffer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.UserOfferRepository;
import com.neeraja.ShareMyOffer.dto.OfferDTO;
import com.neeraja.ShareMyOffer.dto.UserDTO;
import com.neeraja.ShareMyOffer.dto.UserOfferDTO;
import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.entities.User;
import com.neeraja.ShareMyOffer.entities.UserOffer;
import com.neeraja.ShareMyOffer.objectMappers.OfferMapper;
import com.neeraja.ShareMyOffer.objectMappers.UserMapper;
import com.neeraja.ShareMyOffer.objectMappers.UserOfferMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserOfferServiceImpl implements UserOfferService {

	@Autowired
	private UserOfferRepository userOfferRepository;
	
	@Autowired
	private UserOfferMapper userOfferMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private OfferMapper offerMapper;
	
	@Override
	public List<UserOfferDTO> findAll() {
		List<UserOffer> userOffers = userOfferRepository.findAll();
		List<UserOfferDTO> userOffersDTO = new ArrayList<UserOfferDTO>();
		for(UserOffer userOffer : userOffers) {
			userOffersDTO.add(userOfferMapper.convertToDto(userOffer));
		}
		return userOffersDTO;
	}

	@Override
	public UserOfferDTO findById(int id) {
		Optional<UserOffer> userOffer = userOfferRepository.findById(id);
		UserOfferDTO userOfferDTO = null;
		if(userOffer.isPresent()) {
			userOfferDTO = userOfferMapper.convertToDto(userOffer.get());
		}
		else {
			throw new RuntimeException("Did not find a user and offer");
		}
		return userOfferDTO;
	}

	@Override
	@Transactional
	public UserOfferDTO save(UserDTO theUserDTO,OfferDTO offerDTO) {
		User user = userMapper.convertToEntity(theUserDTO);
		Offer offer = offerMapper.convertToEntity(offerDTO);
		UserOfferDTO userOfferDTO = new UserOfferDTO();
		userOfferDTO.setUser(user);
		userOfferDTO.setOffer(offer);
		userOfferDTO.setPurpose("Accepted");
		UserOffer userOffer = userOfferMapper.convertToEntity(userOfferDTO);
		log.info(userOffer.toString());
		userOfferRepository.save(userOffer);
		return userOfferDTO;
	}

	@Override
	public boolean deleteById(int id) {
		userOfferRepository.deleteById(id);
		return true;
	}

	@Override
	public List<UserOfferDTO> findByPurpose(String purpose) {
		List<UserOffer> userOffers = userOfferRepository.findByPurpose(purpose);
		List<UserOfferDTO> userOffersDTO = new ArrayList<UserOfferDTO>();
		for(UserOffer userOffer : userOffers) {
			userOffersDTO.add(userOfferMapper.convertToDto(userOffer));
		}
		return userOffersDTO;
	}

	@Override
	public List<UserOfferDTO> findByUserAndPurpose(UserDTO userDTO, String purpose) {
		User user = userMapper.convertToEntity(userDTO);
		List<UserOffer> userOffers = userOfferRepository.findByUserAndPurpose(user,purpose);
		List<UserOfferDTO> userOffersDTO = new ArrayList<UserOfferDTO>();
		for(UserOffer userOffer : userOffers) {
			userOffersDTO.add(userOfferMapper.convertToDto(userOffer));
		}
		return userOffersDTO;
	}

}
