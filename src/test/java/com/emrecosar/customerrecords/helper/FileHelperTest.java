package com.emrecosar.customerrecords.helper;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;

public final class FileHelperTest {

	@Test
	public void givenFileName_whenReadFile_thenReturnFileString() throws IOException {

		String fileName = TestHelper.fileName;

		String expected = TestHelper.validOfficeJson;

		String actual = FileHelper.readFile(fileName);

		assertThat(actual).isNotNull();
		assertThat(expected.toString()).isEqualTo(actual.toString());

	}

	@Test(expected = NullPointerException.class)
	public void givenFileName_whenReadFile_thenThrowNullPointerException() throws IOException {

		String fileName = TestHelper.invalidFileName;

		FileHelper.readFile(fileName);
	}

	@Test
	public void givenURL_whenReadFile_thenReturnFileString() throws IOException {

		URL fileUrl = new URL(TestHelper.customersGistUrl);

		String expected = TestHelper.valid32CustomersJson;

		String actual = FileHelper.readFile(fileUrl);

		assertThat(actual).isNotNull();
		assertThat(expected.length()).isEqualTo(actual.length());
		assertThat(expected.toString()).isEqualTo(actual.toString());

	}

	@Test(expected = IOException.class)
	public void givenFileName_whenReadFile_thenThrowIOException() throws IOException {

		URL fileUrl = new URL(TestHelper.invalidCustomersGistUrl);

		FileHelper.readFile(fileUrl);

	}

}
