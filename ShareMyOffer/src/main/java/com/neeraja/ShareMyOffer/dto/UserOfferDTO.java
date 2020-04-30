package com.neeraja.ShareMyOffer.dto;

import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserOfferDTO {
	
	private int id;
	
	private User user;
	//private UserDTO user;

	private Offer offer;
	//private OfferDTO offer;

	private String purpose;

}
