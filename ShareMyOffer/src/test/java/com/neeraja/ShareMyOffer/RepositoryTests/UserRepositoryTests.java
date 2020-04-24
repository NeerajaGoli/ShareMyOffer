package com.neeraja.ShareMyOffer.RepositoryTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neeraja.ShareMyOffer.dao.UserRepository;
import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.User;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	private User user1;

	private User user2;
	
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

		user2 = new User();
		user2.setFirstName("DEF");
		user2.setLastName("UVW");
		user2.setDateOfBirth("1999-06-22");
		user2.setMobileNumber("7013450459");
		user2.setEmail("def@gmail.com");
		user2.setRating(3.5);
		
		address = new Address();
		address.setHouseNumber("12-1-449/2");
		address.setLandMark("temple");
		address.setStreet("Lalapet");
		address.setCity("Secunderabad");
		address.setState("Telangana");
		address.setCountry("India");
		address.setPinCode(500027);
		address.setLatitude(1.23);
		address.setLongitude(3.4);
		
		user1.setAddress(address);
		user2.setAddress(address);
	}

	@Test
	public void testFindById() {
		User dbUser = userRepository.save(user1);
		log.info(dbUser.getId() + "");
		Optional<User> resultUser = userRepository.findById(dbUser.getId());
		assertThat(resultUser.get()).isEqualTo(dbUser);
	}

	@Test
	public void testFindAll() {
		User dbUser1 = userRepository.save(user1);
		User dbUser2 = userRepository.save(user2);
		List<User> dbUsers = Arrays.asList(dbUser1, dbUser2);
		List<User> resultUsers = userRepository.findAll();
		assertThat(resultUsers).isEqualTo(dbUsers);
	}

	@Test
	public void testDelete() {
		User dbUser = userRepository.save(user1);
		userRepository.deleteById(dbUser.getId());
		Optional<User> result = userRepository.findById(dbUser.getId());
		assertThat(result.isPresent()).isEqualTo(false);
	}
}
