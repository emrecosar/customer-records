package com.emrecosar.customerrecords.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.emrecosar.customerrecords.domain.Office;
import com.google.gson.JsonSyntaxException;

public class OfficeServiceImplTest {

	OfficeServiceImpl officeServiceImpl;
	
	@Before
	public void setup() {
		officeServiceImpl = new OfficeServiceImpl();
	}
	
	@Test
	public void givenFileName_whenGetOffice_thenReturnOffice() throws JsonSyntaxException, NullPointerException, IOException {
		
		String fileName = "dublin.json";
		
		Office expected = new Office("Dublin Office", 53.339428, -6.257664);
		
		Office actual = officeServiceImpl.getOffice(fileName);
		
		assertThat(actual).isNotNull();
		assertThat(expected.getName()).isEqualTo(actual.getName());
		assertThat(expected.getLatitude()).isEqualTo(actual.getLatitude());
		assertThat(expected.getLongitude()).isEqualTo(actual.getLongitude());
		
	}
	
	@Test(expected = NullPointerException.class)
	public void givenFileName_whenGetOffice_thenThrowNullPointerException() throws JsonSyntaxException, NullPointerException, IOException {
		
		String fileName = "dublin";
		
		officeServiceImpl.getOffice(fileName);
		
	}
}
