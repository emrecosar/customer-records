package com.emrecosar.customerrecords.domain;

import javax.validation.constraints.NotNull;

public class Office extends BaseGeoTag {

	@NotNull
	private String name;

	public Office(String name, double latitude, double longitude) {
		super(latitude, longitude);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
