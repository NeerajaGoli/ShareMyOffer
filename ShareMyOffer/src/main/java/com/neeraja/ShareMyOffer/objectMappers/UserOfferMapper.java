package com.neeraja.ShareMyOffer.objectMappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neeraja.ShareMyOffer.dto.UserOfferDTO;
import com.neeraja.ShareMyOffer.entities.UserOffer;

@Component
public class UserOfferMapper {
	
	@Autowired
    private ModelMapper mapper;

    public UserOfferDTO convertToDto(UserOffer theUserOffer){

        UserOfferDTO theUserOfferDto=mapper.map(theUserOffer,UserOfferDTO.class);
        return theUserOfferDto;

    }


    public UserOffer convertToEntity(UserOfferDTO theUserOfferDto){

       UserOffer theUserOffer=mapper.map(theUserOfferDto,UserOffer.class);
        return theUserOffer;

    }

}
