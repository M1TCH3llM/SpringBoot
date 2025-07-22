package com.synergisticit.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class Address {
	
@NotEmpty   private String addressLine1;
@NotEmpty	private String addressLine2;
@NotEmpty	private String city;
@NotEmpty	private String state;
@NotEmpty	private String country;
@NotEmpty	private String zip;

public Address() {
	
}

public Address(@NotEmpty String addressLine1, @NotEmpty String addressLine2, @NotEmpty String city,
		@NotEmpty String state, @NotEmpty String country, @NotEmpty String zip) {
	super();
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.city = city;
	this.state = state;
	this.country = country;
//	this.zip = zip;
}

public String getAddressLine1() {
	return addressLine1;
}

public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}

public String getAddressLine2() {
	return addressLine2;
}

public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}

@Override
public String toString() {
	return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
			+ state + ", country=" + country + ", zip=" + zip + "]";
}




}
