package com.neeraja.ShareMyOffer.objectMappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neeraja.ShareMyOffer.dto.UserDTO;
import com.neeraja.ShareMyOffer.entities.User;

@Component
public class UserMapper {
	
    @Autowired
    private ModelMapper mapper;

    public UserDTO convertToDto(User theUser){

        UserDTO theUserDto=mapper.map(theUser,UserDTO.class);
        return theUserDto;

    }


    public User convertToEntity(UserDTO theUserDto){

       User theUser=mapper.map(theUserDto,User.class);
        return theUser;

    }

}
