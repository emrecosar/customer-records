package com.emrecosar.customerrecords.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;

public final class FileHelper {

	public static final String PATH_TO_JSON = "json/";
	
	public static String readFile(String fileName) throws NullPointerException, IOException {

		ClassLoader classLoader = new FileHelper().getClass().getClassLoader();
        File file = new File(classLoader.getResource(PATH_TO_JSON + fileName).getFile());
		
        return new String(Files.readAllBytes(file.toPath()));
	}

	public static String readFile(URL fileUrl) throws IOException {

		BufferedReader bufferReader = null;
		StringBuilder result = new StringBuilder();
		try {
			bufferReader = new BufferedReader(new InputStreamReader(fileUrl.openStream()));
			String line;
			while ((line = bufferReader.readLine()) != null) {
				result.append(line).append(System.lineSeparator());
			}
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ex) {
			}
		}

		return result.toString().trim();
	}

}
