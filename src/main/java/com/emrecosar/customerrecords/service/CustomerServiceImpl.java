package com.emrecosar.customerrecords.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.helper.FileHelper;
import com.emrecosar.customerrecords.helper.JsonHelper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerServiceImpl() {
	}

	/*
	 * @see com.emrecosar.customerrecords.service.CustomerService#getCustomers(java.net.URL)
	 */
	@Override
	public List<Customer> getCustomers(URL url) throws IOException {

		String customersJson = FileHelper.readFile(url);
		List<Customer> customerList = JsonHelper.getCustomersFromJson(customersJson);

		return customerList;
	}

}
