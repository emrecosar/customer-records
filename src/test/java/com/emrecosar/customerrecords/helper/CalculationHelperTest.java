package com.emrecosar.customerrecords.helper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.domain.Office;

public class CalculationHelperTest {

	@Test
	public void givenCustomerOffice_whenCalculateDistance_thenReturnExpectedDistance() {

		Customer currentCustomer = new Customer(1, "Customer Name", 52.986375, -6.043701);
		Office office = new Office("Office Name", 53.339428, -6.257664);
		
		/* 
		 * Double can has some problem about computation even on the same machine wtih different runs.
		 * So, this delta is added for after 9th decimal points.
		 */
		double delta = 0.000000001; 
		double expected = 41.76872550078046;
		
		double actual = CalculationHelper.calculateDistance(currentCustomer, office);

		assertThat(actual).isNotNaN();
		
		assertEquals(expected, actual, delta);
		

	}
	
}