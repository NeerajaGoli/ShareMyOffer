package com.neeraja.ShareMyOffer.dto;


import java.util.List;

import com.neeraja.ShareMyOffer.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginDTO {
	
	private String userName;
	
	private String password;
	
	private List<Role> roles;

	
}
