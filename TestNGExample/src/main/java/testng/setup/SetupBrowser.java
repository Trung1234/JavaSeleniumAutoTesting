package testng.setup;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public  class SetupBrowser {

    protected static WebDriver driver;

    /**
     * Singleton instance method to get the WebDriver
     * @return
     */
    public static WebDriver getDriverInstance() {
        if (Objects.isNull(driver)) {
            // Set the path to the chromedriver executable if needed
        	 System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }



    @BeforeClass
    public void setUp() {
        driver = getDriverInstance();
    }

    @AfterClass
    public void tearDown() {
        closeDriver();
    }

    /**
     * Method to close the drive
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}