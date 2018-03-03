package com.emrecosar.customerrecords.helper;

import java.util.ArrayList;
import java.util.List;

import com.emrecosar.customerrecords.domain.Customer;
import com.emrecosar.customerrecords.domain.Office;

public class TestHelper {

	public static final String valid2CustomersJson = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}\n"
			+ "{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}";

	public static final String syntaxError2CustomersJson = "{{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}\n"
			+ "{\"latitude\": \"52.833502\", \"user_id\": 25, \"name\": \"David Behan\", \"longitude\": \"-8.522366\"}";

	public static final String fileName = "dublin.json";

	public static final String invalidFileName = "dublin";

	public static final String syntaxErrorDublinOfficeJson = "{\"latitude\": \"53.339428\", \"name\": \"Dublin Office\", \"longitude\": \"-6.257664\"}}";

	public static final String customersGistUrl = "https://gist.githubusercontent.com/emrecosar/763aeb36d4ba4aa616496f674fe41b65/raw/859e89c8fc3714cba8aebe3e3d72c181b73e68d6/customers.txt";

	public static final String invalidCustomersGistUrl = "https://gist.githubusercontent.com/emrecosar/763aeb36d4ba4aa616496f674fe41b65/raw/859e89c8fc3714cba8aebe3e3d72c181b73e68d6/customer";

	public static List<Customer> getValid2Customers() {
		List<Customer> customers = new ArrayList<Customer>(2);

		Customer customer1 = new Customer(12, "Christina McArdle", 52.986375, -6.043701);
		Customer customer2 = new Customer(1, "Alice Cahill", 51.92893, -10.27699);

		customers.add(customer1);
		customers.add(customer2);

		return customers;
	}

	public static final String validOfficeJson = "{\"latitude\": \"53.339428\", \"name\": \"Dublin Office\", \"longitude\": \"-6.257664\"}";

	public static Office getDublinOffice() {
		return new Office("Dublin Office", 53.339428, -6.257664);
	}

	public static final String valid32CustomersJson = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}\n"
			+ "{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}\n"
			+ "{\"latitude\": \"51.8856167\", \"user_id\": 2, \"name\": \"Ian McArdle\", \"longitude\": \"-10.4240951\"}\n"
			+ "{\"latitude\": \"52.3191841\", \"user_id\": 3, \"name\": \"Jack Enright\", \"longitude\": \"-8.5072391\"}\n"
			+ "{\"latitude\": \"53.807778\", \"user_id\": 28, \"name\": \"Charlie Halligan\", \"longitude\": \"-7.714444\"}\n"
			+ "{\"latitude\": \"53.4692815\", \"user_id\": 7, \"name\": \"Frank Kehoe\", \"longitude\": \"-9.436036\"}\n"
			+ "{\"latitude\": \"54.0894797\", \"user_id\": 8, \"name\": \"Eoin Ahearn\", \"longitude\": \"-6.18671\"}\n"
			+ "{\"latitude\": \"53.038056\", \"user_id\": 26, \"name\": \"Stephen McArdle\", \"longitude\": \"-7.653889\"}\n"
			+ "{\"latitude\": \"54.1225\", \"user_id\": 27, \"name\": \"Enid Gallagher\", \"longitude\": \"-8.143333\"}\n"
			+ "{\"latitude\": \"53.1229599\", \"user_id\": 6, \"name\": \"Theresa Enright\", \"longitude\": \"-6.2705202\"}\n"
			+ "{\"latitude\": \"52.2559432\", \"user_id\": 9, \"name\": \"Jack Dempsey\", \"longitude\": \"-7.1048927\"}\n"
			+ "{\"latitude\": \"52.240382\", \"user_id\": 10, \"name\": \"Georgina Gallagher\", \"longitude\": \"-6.972413\"}\n"
			+ "{\"latitude\": \"53.2451022\", \"user_id\": 4, \"name\": \"Ian Kehoe\", \"longitude\": \"-6.238335\"}\n"
			+ "{\"latitude\": \"53.1302756\", \"user_id\": 5, \"name\": \"Nora Dempsey\", \"longitude\": \"-6.2397222\"}\n"
			+ "{\"latitude\": \"53.008769\", \"user_id\": 11, \"name\": \"Richard Finnegan\", \"longitude\": \"-6.1056711\"}\n"
			+ "{\"latitude\": \"53.1489345\", \"user_id\": 31, \"name\": \"Alan Behan\", \"longitude\": \"-6.8422408\"}\n"
			+ "{\"latitude\": \"53\", \"user_id\": 13, \"name\": \"Olive Ahearn\", \"longitude\": \"-7\"}\n"
			+ "{\"latitude\": \"51.999447\", \"user_id\": 14, \"name\": \"Helen Cahill\", \"longitude\": \"-9.742744\"}\n"
			+ "{\"latitude\": \"52.966\", \"user_id\": 15, \"name\": \"Michael Ahearn\", \"longitude\": \"-6.463\"}\n"
			+ "{\"latitude\": \"52.366037\", \"user_id\": 16, \"name\": \"Ian Larkin\", \"longitude\": \"-8.179118\"}\n"
			+ "{\"latitude\": \"54.180238\", \"user_id\": 17, \"name\": \"Patricia Cahill\", \"longitude\": \"-5.920898\"}\n"
			+ "{\"latitude\": \"53.0033946\", \"user_id\": 39, \"name\": \"Lisa Ahearn\", \"longitude\": \"-6.3877505\"}\n"
			+ "{\"latitude\": \"52.228056\", \"user_id\": 18, \"name\": \"Bob Larkin\", \"longitude\": \"-7.915833\"}\n"
			+ "{\"latitude\": \"54.133333\", \"user_id\": 24, \"name\": \"Rose Enright\", \"longitude\": \"-6.433333\"}\n"
			+ "{\"latitude\": \"55.033\", \"user_id\": 19, \"name\": \"Enid Cahill\", \"longitude\": \"-8.112\"}\n"
			+ "{\"latitude\": \"53.521111\", \"user_id\": 20, \"name\": \"Enid Enright\", \"longitude\": \"-9.831111\"}\n"
			+ "{\"latitude\": \"51.802\", \"user_id\": 21, \"name\": \"David Ahearn\", \"longitude\": \"-9.442\"}\n"
			+ "{\"latitude\": \"54.374208\", \"user_id\": 22, \"name\": \"Charlie McArdle\", \"longitude\": \"-8.371639\"}\n"
			+ "{\"latitude\": \"53.74452\", \"user_id\": 29, \"name\": \"Oliver Ahearn\", \"longitude\": \"-7.11167\"}\n"
			+ "{\"latitude\": \"53.761389\", \"user_id\": 30, \"name\": \"Nick Enright\", \"longitude\": \"-7.2875\"}\n"
			+ "{\"latitude\": \"54.080556\", \"user_id\": 23, \"name\": \"Eoin Gallagher\", \"longitude\": \"-6.361944\"}\n"
			+ "{\"latitude\": \"52.833502\", \"user_id\": 25, \"name\": \"David Behan\", \"longitude\": \"-8.522366\"}";

}
