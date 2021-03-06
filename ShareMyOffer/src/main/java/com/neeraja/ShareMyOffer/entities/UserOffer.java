package com.neeraja.ShareMyOffer.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_offer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserOffer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "is required")
	@ManyToOne

	@JoinColumn(name = "user_id")
	private User user;
	
	@NotNull(message = "is required")
	@ManyToOne

	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	@NotNull(message = "is required")
	@Column(name = "purpose")
	private String purpose;
	
}
