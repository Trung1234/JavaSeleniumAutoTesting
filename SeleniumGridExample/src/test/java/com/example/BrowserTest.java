package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.example.factory.BrowserOptionsFactory;
import com.example.factory.BrowserOptionsFactoryProducer;
import com.example.factory.ChromeOptionsFactory;
import com.example.factory.FirefoxOptionsFactory;

public class BrowserTest {
	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws MalformedURLException {
		// Create DesiredCapabilities and merge with ChromeOptions
		BrowserOptionsFactory factory = BrowserOptionsFactoryProducer.getFactory(browser);
		if (factory instanceof ChromeOptionsFactory) {
			// Set ChromeOptions
			ChromeOptions options = (ChromeOptions) factory.createOptions();
			// Connect to the Selenium Grid hub
			driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"), options);
		} else if (factory instanceof FirefoxOptionsFactory) {
			// Set ChromeOptions
			FirefoxOptions options = (FirefoxOptions) factory.createOptions();
			// Connect to the Selenium Grid hub
			driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"), options);
		}
	}

	@Test
	public void testTitle() {
		driver.get("https://learn.microsoft.com/en-us/");
		System.out.println("Title of the page is: " + driver.getTitle());
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
