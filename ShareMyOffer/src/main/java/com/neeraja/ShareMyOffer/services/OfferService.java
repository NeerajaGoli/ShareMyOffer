package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Offer;

public interface OfferService {

	public List<Offer> findAll();

	public Offer findById(int id);

	public void save(Offer theOffer);

	public void deleteById(int id);
	
}
