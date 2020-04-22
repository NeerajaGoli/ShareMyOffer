package com.neeraja.ShareMyOffer.dto;

import org.springframework.stereotype.Component;

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
	
	public String getPhone() {
		return phone;
	}
	
	public String getPassword() {
		return password;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
