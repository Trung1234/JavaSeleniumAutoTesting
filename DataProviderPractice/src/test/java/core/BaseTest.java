package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    private WebDriver driver;

    @BeforeTest 
    @Parameters("browser")
    public void beforeSuite(String browser) {
    	if (browser.equalsIgnoreCase("chrome"))  {
    		WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
    	}
    	if (browser.equalsIgnoreCase("firefox"))  {
    		 WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
    	}
    }

    @AfterTest
    public void afterSuite() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
    
    public WebDriver getDriver() {
        return driver;
    }

}