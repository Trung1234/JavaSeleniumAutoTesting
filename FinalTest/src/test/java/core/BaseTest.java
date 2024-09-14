package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;

	protected static final String USER_NAME = "John Doe";

	protected static final String PASSWORD = "ThisIsNotAPassword";

	@BeforeTest
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
//	@BeforeTest
//	@Parameters("browser")
//	public void beforeSuite(String browser) {
//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//	}

	@AfterTest
	public void afterSuite() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

	protected void goToLink(String url) {
		driver.get(url);
	}

	protected WebDriver getDriver() {
		return driver;
	}

}