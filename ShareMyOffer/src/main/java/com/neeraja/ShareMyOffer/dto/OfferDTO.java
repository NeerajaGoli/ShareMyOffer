package com.neeraja.ShareMyOffer.dto;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OfferDTO {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private String date;
	
	private String status;
	
	private Address address;
	
//	private List<User> users;


}
