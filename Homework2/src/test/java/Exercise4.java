
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.SetupBrowser;

public class Exercise4 extends SetupBrowser {
	@Test
	public void executeTest() throws InterruptedException {

		// Navigate to the webpage
		driver.get("https://demoqa.com/frames");

		// Switch to the iframe
		driver.switchTo().frame("frame1");


		// Get and check the expected text
		WebElement textElement = driver.findElement(By.tagName("h1"));
		String actualText = textElement.getText();
		if (actualText.contains("This page is displayed in an iframe")) {
			System.out.println("Expected text found!");
		} else {
			System.out.println("Expected text not found!");
		}
		assertEquals(actualText, "This is a sample page");

	}
}
