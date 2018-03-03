package com.emrecosar.customerrecords.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.emrecosar.customerrecords.domain.Customer;

public interface CustomerService {

	List<Customer> getCustomers(URL url) throws IOException;
	
}
