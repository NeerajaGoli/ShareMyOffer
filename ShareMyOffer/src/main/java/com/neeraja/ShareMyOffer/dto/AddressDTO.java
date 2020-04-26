package com.neeraja.ShareMyOffer.dto;

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
public class AddressDTO {
	
	private int id;
	
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
