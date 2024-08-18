import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

import common.SetupBrowser;

public class Exercise3 extends SetupBrowser {

	private static final String SAMPLE_HEADING = "This is a sample page";

	@Test
	public void executeTestNewWindowAndTab() throws InterruptedException {
		driver.get("https://demoqa.com/browser-windows");

		WebElement newWindowButton = driver.findElement(By.id("windowButton"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", newWindowButton);
		newWindowButton.click();

		// Switch to the new window
		// Wait until a new window handle is available
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.getWindowHandles().size() > 1;
			}
		});

		Object[] windowHandles = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandles[1]);

		// Now you can get elements on the new window
		WebElement elementOnNewWindow = driver.findElement(By.id("sampleHeading"));

		String elementOnNewWindowHeading = elementOnNewWindow.getText();

		// closing current window
		driver.close();
		// Switch back to the old tab or window
		driver.switchTo().window((String) windowHandles[0]);

		WebElement elementNewTab = driver.findElement(By.id("tabButton"));
		js.executeScript("arguments[0].scrollIntoView(true);", elementNewTab);
		elementNewTab.click();

		// Wait until a new tab handle is available
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.getWindowHandles().size() > 1;
			}
		});

		// Get the handle of the current window
		String currentTabHandle = driver.getWindowHandle();

		// Get the handles of all windows
		Set<String> tabHandles = driver.getWindowHandles();

		// Switch to the new window
		for (String tabHandle : tabHandles) {
			if (!tabHandle.equals(currentTabHandle)) {
				driver.switchTo().window(tabHandle);
				break;
			}
		}

		WebElement elementOnNewTab = driver.findElement(By.id("sampleHeading"));
		String newTabHeading = elementOnNewTab.getText();
		driver.close();

		// Step 6: Print the text in new tab
		System.out.println("This is heading of new tab" + newTabHeading);
		assertEquals(SAMPLE_HEADING, elementOnNewWindowHeading);
		assertEquals(SAMPLE_HEADING, newTabHeading);
	}

}
