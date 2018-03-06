package com.emrecosar.customerrecords.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.service.DistanceCalculationService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerRecordsController {

	DistanceCalculationService distanceCalculationService;

	@Autowired
	public CustomerRecordsController(DistanceCalculationService distanceCalculationService) {
		this.distanceCalculationService = distanceCalculationService;
	}

	@GetMapping("/get-invited")
	public ResponseEntity<List<Customer>> getInvitedCustomers(
			@RequestParam(value = "range", required = false, defaultValue = "100") Integer range,
			@RequestParam(value = "customerUrl", required = true) URL customerUrl) throws IOException {

		List<Customer> invitedCustomers = distanceCalculationService.findCustomersInRange(range, customerUrl);

		if (CollectionUtils.isEmpty(invitedCustomers))
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<List<Customer>>(invitedCustomers, HttpStatus.OK);
	}

}
