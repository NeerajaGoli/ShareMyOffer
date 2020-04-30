package com.neeraja.ShareMyOffer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.AddressRepository;
import com.neeraja.ShareMyOffer.dto.AddressDTO;
import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.objectMappers.AddressMapper;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public List<AddressDTO> findAll() {
		List<Address> addresses = addressRepository.findAll();
		List<AddressDTO> addressesDTO = new ArrayList<AddressDTO>();
		for(Address address : addresses) {
			addressesDTO.add(addressMapper.convertToDto(address));
		}
		return addressesDTO;
	}

	@Override
	public AddressDTO findById(int id) {
		Optional<Address> address = addressRepository.findById(id);
		AddressDTO addressDTO = null;
		if(address.isPresent()) {
			addressDTO = addressMapper.convertToDto(address.get());
		}
		else {
			throw new RuntimeException("Did not find a address");
		}
		return addressDTO;
	}

	@Override
	public AddressDTO save(AddressDTO theAddressDTO) {
		Address address = addressMapper.convertToEntity(theAddressDTO);
		addressRepository.save(address);
		return theAddressDTO;
	}

	@Override
	public boolean deleteById(int id) {
		addressRepository.deleteById(id);
		return true;
	}

}
