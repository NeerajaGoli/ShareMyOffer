package com.neeraja.ShareMyOffer.objectMappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neeraja.ShareMyOffer.dto.RoleDTO;
import com.neeraja.ShareMyOffer.entities.Role;

@Component
public class RoleMapper {
	
	@Autowired
    private ModelMapper mapper;

    public RoleDTO convertToDto(Role theRole){

        RoleDTO theRoleDto=mapper.map(theRole,RoleDTO.class);
        return theRoleDto;

    }


    public Role convertToEntity(RoleDTO theRoleDto){

       Role theRole=mapper.map(theRoleDto,Role.class);
        return theRole;

    }

}
