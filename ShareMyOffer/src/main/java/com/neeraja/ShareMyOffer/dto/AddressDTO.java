package com.neeraja.ShareMyOffer.dto;

import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
	
	private int id;
	
	private User user;
	
	private Offer offer;
	
	private String houseNumber;
	
	private String landMark;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int pinCode;
	
	private float latitude;
	
	private float longitude;

}
