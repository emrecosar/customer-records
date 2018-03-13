package com.emrecosar.customerrecords.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecosar.customerrecords.domain.Office;
import com.emrecosar.customerrecords.helper.FileHelper;
import com.emrecosar.customerrecords.helper.JsonHelper;
import com.google.gson.JsonSyntaxException;

@Service
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	public OfficeServiceImpl() {
	}

	/*
	 * @see com.emrecosar.customerrecords.service.OfficeService#getOffice(java.lang.String)
	 */
	@Override
	public Office getOffice(String fileName) throws JsonSyntaxException, NullPointerException, IOException {

		String officeJson = FileHelper.readFile(fileName);
		Office office = JsonHelper.getOfficeFromJson(officeJson);

		return office;
	}

}
