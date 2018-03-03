package com.emrecosar.customerrecords.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.helper.TestHelper;

public class CustomerServiceImplTest {

	CustomerServiceImpl customerServiceImpl;
	
	@Before
	public void setup() {
		customerServiceImpl = new CustomerServiceImpl();
	}
	
	@Test
	public void givenUrl_whenGetCustomers_thenReturnCustomers() throws IOException {
		
		URL url = new URL(TestHelper.customersGistUrl);
		
		List<Customer> actual = customerServiceImpl.getCustomers(url);
		
		assertThat(actual).isNotNull();
		assertThat(actual.size()).isEqualTo(32);
	}
	
}
