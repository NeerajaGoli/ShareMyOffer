package com.neeraja.ShareMyOffer.dto;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Offer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String dateOfBirth;
	
	private String mobileNumber;
	
	private String email;
	
	private int rating;
	
	private List<Offer> offers;

}
