package org.stepdefinition;

import java.time.Duration;

import org.base.BaseClass;
import org.configuration.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	@Before
	public void intialization() {
		try {
			String browser = PropertiesReader.getProperty("browser.name");
			iniBrow(browser);
			String url = PropertiesReader.getProperty("magneto.url");
			getUrl(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			System.out.println("Browser successfully Initialized");
		} catch (Exception e) {
			System.out.println("Browser Not Initialized" + e.getMessage());
		}
	}

	@After
	public void exit() {
		try {
			driver.quit();
			driver.manage().deleteAllCookies();
			System.out.println("Window Closed");
		} catch (Exception e) {
			System.out.println("Window Not Closed" + e.getMessage());
		}
	}
}
