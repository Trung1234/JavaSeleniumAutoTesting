package setup;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetupBrowser {

	protected WebDriver driver;

	@BeforeTest
	public void setup() {
		// Set the path to the chromedriver executable if needed
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}


}