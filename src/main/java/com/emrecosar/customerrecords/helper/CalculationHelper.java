package com.emrecosar.customerrecords.helper;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.domain.Office;
import com.emrecosar.customerrecords.exception.CalculationIsNotValidException;

public class CalculationHelper {

	public static final double EACH_RADIAN_ON_A_GREAT_CIRCLE_IN_KM = 6371.00;

	public static double calculateDistance(Customer currentCustomer, Office office) {

		double customerLatitude = Math.toRadians(currentCustomer.getLatitude());
		double customerLongitude = Math.toRadians(currentCustomer.getLongitude());
		double officeLatitude = Math.toRadians(office.getLatitude());
		double officeLongitude = Math.toRadians(office.getLongitude());

		// law of cosines
		double angle = Math.acos(Math.sin(customerLatitude) * Math.sin(officeLatitude) + Math.cos(customerLatitude)
				* Math.cos(officeLatitude) * Math.cos(customerLongitude - officeLongitude));

		if (Double.isNaN(angle))
			throw new CalculationIsNotValidException(currentCustomer.getLatitude(), currentCustomer.getLongitude(),
					office.getLatitude(), office.getLongitude());

		// each radian on a great circle of Earth is 6371 kilometers
		return EACH_RADIAN_ON_A_GREAT_CIRCLE_IN_KM * angle;
	}

}