package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
    	WebDriverManager.chromedriver().setup();
//    	WebDriver driver = new ChromeDriver();
//    	System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite
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