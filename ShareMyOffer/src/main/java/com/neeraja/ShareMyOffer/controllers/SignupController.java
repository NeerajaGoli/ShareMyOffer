package com.neeraja.ShareMyOffer.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neeraja.ShareMyOffer.dto.AddressDTO;
import com.neeraja.ShareMyOffer.dto.LoginDTO;
import com.neeraja.ShareMyOffer.dto.UserDTO;
import com.neeraja.ShareMyOffer.objectMappers.AddressMapper;
import com.neeraja.ShareMyOffer.objectMappers.UserMapper;
import com.neeraja.ShareMyOffer.services.AuthService;
import com.neeraja.ShareMyOffer.services.LoginService;
import com.neeraja.ShareMyOffer.services.RoleService;
import com.neeraja.ShareMyOffer.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/signup")
@Slf4j
public class SignupController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthService authService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private UserMapper userMapper;
	
	private UserDTO userDTO;
	
	private AddressDTO addressDTO;
	
	private LoginDTO loginDTO;

	@GetMapping("/showMySignUpPage")
	public String showMySignUpPage(Model theModel) {
		UserDTO userDTO = new UserDTO();
		AddressDTO addressDTO = new AddressDTO();
		LoginDTO loginDTO = new LoginDTO();
		theModel.addAttribute("user", userDTO);
		theModel.addAttribute("address", addressDTO);
		theModel.addAttribute("login", loginDTO);
		return "signup-page";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("user") UserDTO userDTO,
			@Valid @ModelAttribute("address") AddressDTO addressDTO, @Valid @ModelAttribute("login") LoginDTO loginDTO,
			BindingResult theBindingResult, Model theModel) {

		
 		if (theBindingResult.hasErrors()) {
			return "signup-page";
		}

		if (userService.findByMobileNumber(userDTO.getMobileNumber()) != null) {
			theModel.addAttribute("addUserError",
					"User with mobile number " + userDTO.getMobileNumber() + " already exists");
			theModel.addAttribute("user", new UserDTO());
			theModel.addAttribute("address", new AddressDTO());
			theModel.addAttribute("login", new LoginDTO());
			return "signup-page";
		}

		log.info(addressDTO.toString());
		loginDTO.setUserName(userDTO.getMobileNumber());
		loginDTO.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
		loginDTO.setRoles(Arrays.asList(roleService.findByRoleName("ROLE_USER")));
		theModel.addAttribute("user", userDTO);
		theModel.addAttribute("address", addressDTO);
		theModel.addAttribute("login", loginDTO);
		authService.sendOtp("+91"+userDTO.getMobileNumber());
		return "otp-page";
	}
	
	@RequestMapping("/verifyOtp")
	public String verifyOtp(@ModelAttribute("user") UserDTO userDTO,
							@ModelAttribute("address") AddressDTO addressDTO,
							@ModelAttribute("login") LoginDTO loginDTO,
							Model theModel,
							HttpServletRequest request) {
		String otp = request.getParameter("otp");
		log.info(otp);
		String mobileNumber = "+91"+userDTO.getMobileNumber();
		loginDTO.setRoles(Arrays.asList(roleService.findByRoleName("ROLE_USER")));
		log.info(loginDTO.getUserName());
		log.info(loginDTO.getPassword());
		log.info("Mobile number : " + mobileNumber);
		if(authService.verifyOtp(mobileNumber,otp)) {
			userService.save(userDTO, addressDTO);
			loginService.save(loginDTO);
		} else {
			theModel.addAttribute("otpErrorMessage", "Invalid OTP!");
			return "otp-page";
		}
		return "login-page";
	}
	
	
	@RequestMapping("/otp")
	public String resendOtp(@ModelAttribute("user") UserDTO userDTO,
							@ModelAttribute("address") AddressDTO addressDTO,
							@ModelAttribute("login") LoginDTO loginDTO,
							Model theModel,
							HttpServletRequest request) {
		authService.sendOtp("+91"+userDTO.getMobileNumber());
		loginDTO.setRoles(Arrays.asList(roleService.findByRoleName("ROLE_USER")));
		theModel.addAttribute("user", userDTO);
		theModel.addAttribute("address", addressDTO);
		theModel.addAttribute("login", loginDTO);
		return "otp-page";
	}
	
}
