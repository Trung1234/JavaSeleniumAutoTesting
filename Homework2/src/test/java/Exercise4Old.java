
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.SetupBrowser;

public class Exercise4Old extends SetupBrowser {
	@Test
	public void executeTest() throws InterruptedException {

		// Navigate to the webpage
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

		// Switch to the iframe
		driver.switchTo().frame("iframeResult");
		// Switch to the child iframe
		driver.switchTo().frame(0);

		// Get and check the expected text
		WebElement textElement = driver.findElement(By.tagName("h1"));
		String actualText = textElement.getText();
		if (actualText.contains("This page is displayed in an iframe")) {
			System.out.println("Expected text found!");
		} else {
			System.out.println("Expected text not found!");
		}
		assertEquals(actualText, "This page is displayed in an iframe");

	}
}
