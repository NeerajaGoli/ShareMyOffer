package com.neeraja.ShareMyOffer.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Component
public class LoginDTO {
	
	private String phone;
	
	private String password;
	
	public LoginDTO() {
		
	}
	
	public LoginDTO(String phone,String password) {
		this.phone = phone;
		this.password = password;
	}
	
}
