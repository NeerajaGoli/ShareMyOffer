package com.neeraja.ShareMyOffer.objectMappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neeraja.ShareMyOffer.dto.LoginDTO;
import com.neeraja.ShareMyOffer.entities.Login;

@Component
public class LoginMapper {
	
    @Autowired
    private ModelMapper mapper;

    public LoginDTO convertToDto(Login theLogin){

    	LoginDTO theLoginDto=mapper.map(theLogin,LoginDTO.class);
        return theLoginDto;

    }


    public Login convertToEntity(LoginDTO theLoginDto){

    	Login theLogin=mapper.map(theLoginDto,Login.class);
        return theLogin;

    }

}
