package com.synergisticit.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class Address {
	
@NotEmpty	private String addressLin1;
@NotEmpty	private String addressLin2;
@NotEmpty	private String city;
@NotEmpty	private String state;
@NotEmpty	private String counrty;
@NotEmpty	private String zip;



	public Address() {
		
	}
	
	public Address(@NotEmpty String addressLin1, @NotEmpty String addressLin2, @NotEmpty String city,
			@NotEmpty String state, @NotEmpty String counrty, @NotEmpty String zip) {
		super();
		this.addressLin1 = addressLin1;
		this.addressLin2 = addressLin2;
		this.city = city;
		this.state = state;
		this.counrty = counrty;
		this.zip = zip;
	}

	public String getAddressLin1() {
		return addressLin1;
	}

	public void setAddressLin1(String addressLin1) {
		this.addressLin1 = addressLin1;
	}

	public String getAddressLin2() {
		return addressLin2;
	}

	public void setAddressLin2(String addressLin2) {
		this.addressLin2 = addressLin2;
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

	public String getCounrty() {
		return counrty;
	}

	public void setCounrty(String counrty) {
		this.counrty = counrty;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	
}
