package com.emrecosar.customerrecords.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.domain.Office;
import com.emrecosar.customerrecords.helper.TestHelper;

@RunWith(MockitoJUnitRunner.class)
public class DistanceCalculationServiceImplTest {

	@Mock
	CustomerService customerService;

	@Mock
	OfficeService officeService;
	
	DistanceCalculationServiceImpl distanceCalculationServiceImpl;
	
	@Before
	public void setup() {
		distanceCalculationServiceImpl = new DistanceCalculationServiceImpl(customerService, officeService);
	}
	
	@Test(expected = IOException.class)
	public void givenRangeAndUrl_whenFindCustomersInRange_thenThrowIOException() throws IOException {
		
		URL url = new URL(TestHelper.invalidCustomersGistUrl);
		Integer range = 100;
		
		when(customerService.getCustomers(url)).thenThrow(new IOException());
		
		distanceCalculationServiceImpl.findCustomersInRange(range, url);
		
	}
	
	@Test
	public void givenRangeAndUrl_whenFindCustomersInRange_thenReturnEmptyCustomerList() throws IOException {
		
		URL url = new URL(TestHelper.customersGistUrl);
		Integer range = 100;
		
		when(customerService.getCustomers(url)).thenReturn(new ArrayList<Customer>());
		when(officeService.getOffice(Matchers.any())).thenReturn(TestHelper.getDublinOffice());
		
		List<Customer> actual = distanceCalculationServiceImpl.findCustomersInRange(range, url);
		
		assertThat(actual).isNotNull();
		assertThat(actual.size()).isEqualTo(0);
		
		verify(customerService).getCustomers(url);
		verify(officeService).getOffice(Matchers.any());
		verifyNoMoreInteractions(customerService);
		verifyNoMoreInteractions(officeService);
		
	}
	
	@Test
	public void givenRangeAndUrl_whenFindCustomersInRange_thenReturnCustomers() throws IOException {
		
		URL url = new URL(TestHelper.customersGistUrl);
		Integer range = 100;
		
		Office office = TestHelper.getDublinOffice();
		List<Customer> customers = TestHelper.getValid2Customers();
		
		when(customerService.getCustomers(url)).thenReturn(customers);
		when(officeService.getOffice(Matchers.any())).thenReturn(office);
		
		List<Customer> actual = distanceCalculationServiceImpl.findCustomersInRange(range, url);
		
		assertThat(actual).isNotNull();
		assertThat(actual.size()).isEqualTo(1);
		
		verify(customerService).getCustomers(url);
		verify(officeService).getOffice(Matchers.any());
		verifyNoMoreInteractions(customerService);
		verifyNoMoreInteractions(officeService);
		
	}
	
}
