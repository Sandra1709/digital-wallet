package com.ust.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Wallet {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String pan;
	private long  aadhar;
	private long  phone_no;
	private String license;
	
	

}
