package com.emrecosar.customerrecords.domain;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseGeoTag {
	
	@NotNull
	@JsonIgnore
	private double latitude;
	
	@NotNull
	@JsonIgnore
	private double longitude;
	
	public BaseGeoTag(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
