package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Role;

public interface RoleService {
	
	public List<Role> findAll();

	public Role findById(int id);

	public void save(Role theRole);

	public void deleteById(int id);

}
