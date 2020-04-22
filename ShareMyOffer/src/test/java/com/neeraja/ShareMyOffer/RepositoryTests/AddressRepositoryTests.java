package com.neeraja.ShareMyOffer.RepositoryTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neeraja.ShareMyOffer.dao.AddressRepository;
import com.neeraja.ShareMyOffer.dao.UserRepository;
import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.User;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class AddressRepositoryTests {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private User user1;
	
	private Address address;
	
	@Before
	public void testSetUp() {
		
		user1 = new User();
		user1.setFirstName("XYZ");
		user1.setLastName("ABC");
		user1.setDateOfBirth("1999-06-22");
		user1.setMobileNumber("7013450458");
		user1.setEmail("xyz@gmail.com");
		user1.setRating(3.5);
		userRepository.save(user1);
		
		address = new Address("12-1-449/2","temple","Lalapet","Secunderabad","Telangana","India",500027,1.23,3.4,user1);
	}
	
	@Test
	public void testFindById() {
		Address dbAddress = addressRepository.save(address);
		log.info(dbAddress.toString());
		Optional<Address> resultAddress = addressRepository.findById(dbAddress.getId());
		assertThat(resultAddress.get()).isEqualTo(dbAddress);
	}
	
	@Test
	public void testDelete() {
		Address dbAddress = addressRepository.save(address);
		addressRepository.deleteById(dbAddress.getId());
		Optional<Address> result = addressRepository.findById(dbAddress.getId());
		assertThat(result.isPresent()).isEqualTo(false);
		
	}
}
