package com.neeraja.ShareMyOffer.dto;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RoleDTO {
	
	private int id;
	
	private String roleName;
	
	private List<Login> logins;

}
