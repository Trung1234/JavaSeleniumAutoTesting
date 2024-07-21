package testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import testng.setup.SetupBrowser;

public class Main extends SetupBrowser {

	@Test(priority = 1)
	public void executeTest() {
		driver.get("https://anhtester.com");

		String expectedTitle = "Anh Tester Automation Testing";
		String originalTitle = driver.getTitle();

		System.out.println("*** Checking For The Title ***");

		assertEquals(originalTitle, expectedTitle);

	}

}
