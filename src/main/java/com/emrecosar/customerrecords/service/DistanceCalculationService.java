package com.emrecosar.customerrecords.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.emrecosar.customerrecords.domain.Customer;

public interface DistanceCalculationService {

	List<Customer> findCustomersInRange(Integer range, URL customerUrl) throws IOException;
	
}
