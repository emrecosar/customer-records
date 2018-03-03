package com.emrecosar.customerrecords.helper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.domain.Office;
import com.google.gson.JsonSyntaxException;

public class JsonHelperTest {

	@Test
	public void givenCustomersJson_whenGetCustomers_thenReturnCustomers() {

		String customersJson = TestHelper.valid2CustomersJson;
		List<Customer> expected = TestHelper.getValid2Customers();
		List<Customer> actual = JsonHelper.getCustomersFromJson(customersJson);

		assertThat(actual).isNotNull();
		assertThat(actual.size()).isEqualTo(expected.size());
		assertThat(actual.get(0).getLongitude()).isEqualTo(expected.get(0).getLongitude());

	}

	@Test(expected = JsonSyntaxException.class)
	public void givenCustomersJson_whenGetCustomers_thenThrowJsonSyntaxException() {

		String customersJson = TestHelper.syntaxError2CustomersJson;

		JsonHelper.getCustomersFromJson(customersJson);

	}

	@Test
	public void givenOfficeJson_whenGetOffice_thenReturnOffice() {

		String officeJson = TestHelper.validOfficeJson;

		Office expected = TestHelper.getDublinOffice();

		Office actual = JsonHelper.getOfficeFromJson(officeJson);

		assertThat(actual).isNotNull();
		assertThat(expected.getName()).isEqualTo(actual.getName());
		assertThat(expected.getLatitude()).isEqualTo(actual.getLatitude());
		assertThat(expected.getLongitude()).isEqualTo(actual.getLongitude());

	}

	@Test(expected = JsonSyntaxException.class)
	public void givenOfficeJson_whengetOffice_thenThrowJsonSyntaxException() {

		String officeJson = TestHelper.syntaxErrorDublinOfficeJson;

		JsonHelper.getOfficeFromJson(officeJson);

	}

}
