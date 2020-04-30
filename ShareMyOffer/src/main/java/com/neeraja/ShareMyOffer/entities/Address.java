package com.neeraja.ShareMyOffer.entities;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.ToString;

@Entity
@Table(name = "address")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@ToString

public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "address_id")
	private int id;
	
	@NotNull(message = "is required")
	@Column(name = "house_number")
	private String houseNumber;
	
	@NotNull(message = "is required")
	@Column(name = "land_mark")
	private String landMark;
	
	@NotNull(message = "is required")
	@Column(name = "street")
	private String street;
	
	@NotNull(message = "is required")
	@Column(name = "city")
	private String city;
	
	@NotNull(message = "is required")
	@Column(name = "state")
	private String state;
	
	@NotNull(message = "is required")
	@Column(name = "country")
	private String country;
	
	@NotNull(message = "is required")
	@Column(name = "pincode")
	private int pinCode;
	
	@NotNull(message = "is required")
	@Column(name = "latitude")
	private float latitude;
	
	@NotNull(message = "is required")
	@Column(name = "longitude")
	private float longitude;
	


}
