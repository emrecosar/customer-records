package com.emrecosar.customerrecords.service;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.domain.Office;
import com.emrecosar.customerrecords.helper.CalculationHelper;

@Service
public class DistanceCalculationServiceImpl implements DistanceCalculationService {

	private final String OFFICE_FILE_NAME = "dublin.json";

	CustomerService customerService;

	OfficeService officeService;

	@Autowired
	public DistanceCalculationServiceImpl(CustomerService customerService, OfficeService officeService) {
		this.customerService = customerService;
		this.officeService = officeService;
	}

	/*
	 * @see com.emrecosar.customerrecords.service.DistanceCalculationService#findCustomersInRange(java.lang.Integer, java.net.URL)
	 */
	@Override
	public List<Customer> findCustomersInRange(Integer range, URL customerUrl) throws IOException {
		
		// get customers and office
		List<Customer> customerList = customerService.getCustomers(customerUrl);
		Office office = officeService.getOffice(OFFICE_FILE_NAME);

		// calculate distance and filter
		List<Customer> inRangeCustomerList = customerList.stream()
				.filter(c -> range >= CalculationHelper.calculateDistance(c, office)).collect(Collectors.toList());

		// sort customer list
		Collections.sort(inRangeCustomerList);

		// print out result to system log if you wish
		inRangeCustomerList.forEach(System.out::println);

		return inRangeCustomerList;
	}

}
