package com.neeraja.ShareMyOffer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	
	@OneToOne
	@JoinColumn(unique = true, name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(unique = true, name = "offer_id")
	private Offer offer;
	
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
	
	@Null
	@Column(name = "latitude")
	private double latitude;
	
	@Null
	@Column(name = "longitude")
	private double longitude;
	
	public Address(int id, String houseNumber,String landMark,String street,String city,String state,String country,int pincode,double latitude,double longitude,User user) {
		this.id = id;
		this.houseNumber = houseNumber;
		this.landMark = landMark;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pincode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.user = user;
	}
	
	public Address(int id, String houseNumber,String landMark,String street,String city,String state,String country,int pincode,double latitude,double longitude,Offer offer) {
		this.id = id;
		this.houseNumber = houseNumber;
		this.landMark = landMark;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pincode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.offer = offer;
	}
}
