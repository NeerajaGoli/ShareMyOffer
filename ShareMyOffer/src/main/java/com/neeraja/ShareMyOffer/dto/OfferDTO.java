package com.neeraja.ShareMyOffer.dto;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferDTO {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private String date;
	
	private String status;
	
	private Address address;
	
	private List<User> users;


}
