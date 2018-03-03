package com.emrecosar.customerrecords.domain;

import javax.validation.constraints.NotNull;

public class Customer extends BaseGeoTag implements Comparable<Customer> {

	@NotNull
	private int user_id;

	@NotNull
	private String name;

	public Customer(int user_id, String name, double latitude, double longitude) {
		super(latitude, longitude);
		this.user_id = user_id;
		this.name = name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserId : [" + this.getUser_id() + "]	Name : [" + this.getName() + "]";
	}

	@Override
	public int compareTo(Customer customer) {
		return this.user_id - customer.getUser_id();
	}

}
