package com.emrecosar.customerrecords.helper;

import java.util.ArrayList;
import java.util.List;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.domain.Office;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonHelper {

	public static List<Customer> getCustomersFromJson(String customersJson) {

		String[] splittedCustomersJson = customersJson.split(System.lineSeparator());
		List<Customer> customers = new ArrayList<Customer>(splittedCustomersJson.length);
		for (String customerJson : splittedCustomersJson) {
			Customer customer = new Gson().fromJson(customerJson, Customer.class);
			customers.add(customer);
		}
		return customers;
	}

	public static Office getOfficeFromJson(String json) throws JsonSyntaxException {

		return new Gson().fromJson(json, Office.class);
	}
}
