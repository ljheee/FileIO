package com.ljheee.io.entity;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 7011045830109188158L;

	private String city;
	private String street;
	
	public Address() {
	}
	
	public Address(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}
	
	
	
	
	
}
