package com.neeraja.ShareMyOffer.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "is required")
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "is required")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message = "is required")
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@NotNull(message = "is required")
	@Column(unique = true, name = "mobile_number")
	private String mobileNumber;
	
	@NotNull(message = "is required")
	@Column(unique = true, name = "email")
	private String email;
	
	@NotNull(message = "is required")
	@Column(name = "rating")
	private double rating;
	
	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "address_id")
	private Address address;
	
//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//	private List<UserOffer> userOffers;

}