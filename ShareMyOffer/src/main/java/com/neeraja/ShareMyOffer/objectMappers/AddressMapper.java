package com.neeraja.ShareMyOffer.objectMappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neeraja.ShareMyOffer.dto.AddressDTO;
import com.neeraja.ShareMyOffer.entities.Address;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AddressMapper {
	
	@Autowired
    private ModelMapper mapper;

    public AddressDTO convertToDto(Address theAddress){

        AddressDTO theAddressDto=mapper.map(theAddress,AddressDTO.class);
        return theAddressDto;

    }


    public Address convertToEntity(AddressDTO theAddressDto){
       
    	log.info(theAddressDto.getCity());
    	Address theAddress=mapper.map(theAddressDto,Address.class);
    	return theAddress;

    }

}
