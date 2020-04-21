package com.neeraja.ShareMyOffer.dto;

import java.util.List;

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
	
	private List<User> users;


}
