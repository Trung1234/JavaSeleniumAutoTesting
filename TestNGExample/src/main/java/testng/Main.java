package testng;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

	 @Test
	  public void fileUploadTest() {
		 driver.get("https://the-internet.herokuapp.com/upload");
	    File uploadFile = new File("src/test/resources/selenium-snapshot.png");

	    WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
	    fileInput.sendKeys(uploadFile.getAbsolutePath());
	    driver.findElement(By.id("file-submit")).click();

	    WebElement fileName = driver.findElement(By.id("uploaded-files"));
	    assertEquals("selenium-snapshot.png", fileName.getText());
	  }
}
