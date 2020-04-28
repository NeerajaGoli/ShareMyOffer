package com.neeraja.ShareMyOffer.objectMappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neeraja.ShareMyOffer.dto.OfferDTO;
import com.neeraja.ShareMyOffer.entities.Offer;

@Component
public class OfferMapper {
	
	@Autowired
    private ModelMapper mapper;

    public OfferDTO convertToDto(Offer theOffer){

        OfferDTO theOfferDto=mapper.map(theOffer,OfferDTO.class);
        return theOfferDto;

    }


    public Offer convertToEntity(OfferDTO theOfferDto){

       Offer theOffer=mapper.map(theOfferDto,Offer.class);
        return theOffer;

    }

}
