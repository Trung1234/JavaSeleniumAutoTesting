package com.example;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BrowserTest {
    WebDriver driver;


	@BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {
		//DesiredCapabilities capability = DesiredCapabilities.; 
        // Set up WebDriver based on browser type
        if (browser.equalsIgnoreCase("chrome")) {
//        	DesiredCapabilities capability1 = DesiredCapabilities.chrome();
//        	capability1.setBrowserName("chrome");
        	// Set the path to the chromedriver executable if needed
    		//System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();

           // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability1);
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
        	//DesiredCapabilities capability2 = DesiredCapabilities.firefox();
        	//capability2.setBrowserName("firefox");

        	//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability2);
        	 // Set the path to the GeckoDriver executable
           // System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
           // WebDriverManager.firefoxdriver().setup();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @Test
    public void testTitle() {
        driver.get("https://learn.microsoft.com/en-us/");
        System.out.println("Title of the page is: " + driver.getTitle());
    }


	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
