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
import com.neeraja.ShareMyOffer.entities.Address;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class AddressRepositoryTests {

	@Autowired
	private AddressRepository addressRepository;
	
	private Address address;
	
	@Before
	public void testSetUp() {
		
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
