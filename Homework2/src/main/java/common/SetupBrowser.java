package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SetupBrowser {

	protected WebDriverWait wait;
	protected WebDriver driver;

	@BeforeClass
	public void setup() {
		// Set the path to the chromedriver executable if needed
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}

	@AfterClass
	public void tearDown() {
		try {
			if (driver != null) {
				driver.quit();
				driver = null;
			}
		} catch (UnreachableBrowserException e) {
			// Log the exception
			System.out.println("Browser was unreachable");
		}
	}

}