package com.emrecosar.customerrecords.service;

import java.io.IOException;

import com.emrecosar.customerrecords.domain.Office;

public interface OfficeService {

	Office getOffice(String fileName) throws IOException;
	
}
