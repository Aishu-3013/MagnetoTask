package org.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	private static final Properties properties = new Properties();

	static {
		try (InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("config.properties")) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
