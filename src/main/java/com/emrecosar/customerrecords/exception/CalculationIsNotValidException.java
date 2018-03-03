package com.emrecosar.customerrecords.exception;

public class CalculationIsNotValidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8506664956101203360L;

	private double geo1latitude;
	private double geo1longitude;
	private double geo2latitude;
	private double geo2longitude;

	public CalculationIsNotValidException(double geo1latitude, double geo1longitude, double geo2latitude,
			double geo2longitude) {
		super();
		this.geo1latitude = geo1latitude;
		this.geo1longitude = geo1longitude;
		this.geo2latitude = geo2latitude;
		this.geo2longitude = geo2longitude;
	}

	@Override
	public String toString() {
		return "Calculation result is not valid. [Geo1Latitude:" + geo1latitude + "][Geo1Laongitude:" + geo1longitude
				+ "[Geo2Latitude:" + geo2latitude + "][Geo2Laongitude:" + geo2longitude + "]";
	}

}
