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

	@Override
	public List<Customer> findCustomersInRange(Integer range, URL customerUrl) throws IOException {
		// TODO Auto-generated method stub

		// get customer and office
		List<Customer> customerList = customerService.getCustomers(customerUrl);
		Office office = officeService.getOffice(OFFICE_FILE_NAME);

		// calculate and filter
		List<Customer> inRangeCustomerList = customerList.stream()
				.filter(c -> range >= CalculationHelper.calculateDistance(c, office)).collect(Collectors.toList());

		// sort
		Collections.sort(inRangeCustomerList);

		// print out result as you requested
		inRangeCustomerList.forEach(System.out::println);

		return inRangeCustomerList;
	}

}
