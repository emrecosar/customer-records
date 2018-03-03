package com.emrecosar.customerrecords.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.emrecosar.customerrecords.CustomerRecordsApplication;
import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.helper.TestHelper;
import com.emrecosar.customerrecords.service.DistanceCalculationService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerRecordsApplication.class)
public class DistanceCalculationControllerTest {

	@Mock
	DistanceCalculationService distanceCalculationService;

	MockMvc mvc;

	private final String URL = "/get-invited-customers";

	@Before
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(new DistanceCalculationController(distanceCalculationService)).build();
	}

	@Test
	public void givenRangeAndUrl_whenGetInvitedCustomers_thenReturnNotFound() throws Exception {

		when(distanceCalculationService.findCustomersInRange(Matchers.anyInt(), Matchers.any()))
				.thenReturn(new ArrayList<Customer>());

		mvc.perform(get(URL).param("range", "100").param("customerUrl",
				"https://gist.githubusercontent.com/emrecosar/763aeb36d4ba4aa616496f674fe41b65/raw/859e89c8fc3714cba8aebe3e3d72c181b73e68d6/customers.txt"))
				.andExpect(status().isNotFound());

	}

	@Test
	public void givenRangeAndUrl_whenGetInvitedCustomers_thenReturnCustomers() throws Exception {

		when(distanceCalculationService.findCustomersInRange(Matchers.anyInt(), Matchers.any()))
				.thenReturn(TestHelper.getValid2Customers());

		mvc.perform(get(URL).param("range", "100").param("customerUrl",
				"https://gist.githubusercontent.com/emrecosar/763aeb36d4ba4aa616496f674fe41b65/raw/859e89c8fc3714cba8aebe3e3d72c181b73e68d6/customers.txt"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(2)));

	}

}
