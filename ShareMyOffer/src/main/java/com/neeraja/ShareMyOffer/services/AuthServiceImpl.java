package com.neeraja.ShareMyOffer.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neeraja.ShareMyOffer.dao.LoginRepository;
import com.neeraja.ShareMyOffer.entities.Login;
import com.neeraja.ShareMyOffer.entities.Role;

@Service
public class AuthServiceImpl implements AuthService {
	
	
}
