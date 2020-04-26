package com.neeraja.ShareMyOffer.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.LoginRepository;
import com.neeraja.ShareMyOffer.dto.LoginDTO;
import com.neeraja.ShareMyOffer.entities.Login;
import com.neeraja.ShareMyOffer.entities.Role;
import com.neeraja.ShareMyOffer.objectMappers.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {

	private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Login> result = loginRepository.findById(userName);
		logger.info(result.toString());
		Login login = null;
		if (result.isPresent() == false) {
			throw new UsernameNotFoundException("Invalid username / password.");
		}
		login = result.get();
		return new org.springframework.security.core.userdetails.User(login.getUserName(), login.getPassword(),
				mapRolesToAuthorities(login.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

	@Override
	public List<LoginDTO> findAll() {
		List<Login> logins = loginRepository.findAll();
		List<LoginDTO> loginDTO = new ArrayList<LoginDTO>();
		for(Login login : logins) {
			loginDTO.add(loginMapper.convertToDto(login));
		}
		return loginDTO;
	}

	@Override
	public LoginDTO findById(String userName) {
		Optional<Login> login = loginRepository.findById(userName);
		LoginDTO loginDTO = null;
		if(login.isPresent()) {
			loginDTO = loginMapper.convertToDto(login.get());
		}
		else {
			throw new RuntimeException("Did not find a user");
		}
		return loginDTO;
	}

	@Override
	public LoginDTO save(LoginDTO theLoginDTO) {
		Login login = loginMapper.convertToEntity(theLoginDTO);
		loginRepository.save(login);
		return theLoginDTO;
		
	}

	@Override
	public boolean deleteById(String userName) {
		loginRepository.deleteById(userName);
		return true;
	}

}
