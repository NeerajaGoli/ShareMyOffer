package com.neeraja.ShareMyOffer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.UserRepository;
import com.neeraja.ShareMyOffer.dto.AddressDTO;
import com.neeraja.ShareMyOffer.dto.UserDTO;
import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.User;
import com.neeraja.ShareMyOffer.objectMappers.AddressMapper;
import com.neeraja.ShareMyOffer.objectMappers.UserMapper;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public List<UserDTO> findAll() {
		List<User> users = userRepository.findAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(User user : users) {
			usersDTO.add(userMapper.convertToDto(user));
		}
		return usersDTO;
	}

	@Override
	public UserDTO findById(int id) {
		Optional<User> user = userRepository.findById(id);
		UserDTO userDTO = null;
		if(user.isPresent()) {
			userDTO = userMapper.convertToDto(user.get());
		}
		else {
			throw new RuntimeException("Did not find a user");
		}
		return userDTO;
	}

	@Override
	public UserDTO save(UserDTO theUserDTO,AddressDTO theAddressDTO) {
		Address address = addressMapper.convertToEntity(theAddressDTO);
		theUserDTO.setAddress(address);
		User user = userMapper.convertToEntity(theUserDTO);
		userRepository.save(user);
		return theUserDTO;
	}

	@Override
	public boolean deleteById(int id) {
		userRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean isExists(String mobileNumber) {
		if(userRepository.findByMobileNumber(mobileNumber) != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public UserDTO findByMobileNumber(String mobileNumber) {
		User user = userRepository.findByMobileNumber(mobileNumber);
		if(user != null)
			return userMapper.convertToDto(user); 
		return null;
	}

}
