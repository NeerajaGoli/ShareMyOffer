package com.neeraja.ShareMyOffer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.entities.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
