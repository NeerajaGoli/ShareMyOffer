package com.neeraja.ShareMyOffer.dto;

import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserOfferDTO {
	
	private int id;
	
	private User user;
	
	private Offer offer;
	
	private String purpose;

}
