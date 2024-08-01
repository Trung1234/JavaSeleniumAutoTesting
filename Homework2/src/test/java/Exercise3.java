import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common.SetupBrowser;


public class Exercise3  extends SetupBrowser {


    private static final String SAMPLE_HEADING  = "This is a sample page";

    @Test
    public void executeTestNewWindowAndTab() {
        //DriverManager driverManager = DriverManager.createDriverManager("chrome", true);
        driver.get("https://demoqa.com/browser-windows");


        WebElement element = driver.findElement(By.id("windowButton"));
        WebElement elementNewTab = driver.findElement(By.id("tabButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();


        // Switch to the new window

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        // Now you can get elements on the new window
        WebElement elementOnNewWindow = driver.findElement(By.id("sampleHeading"));

        String elementOnNewWindowHeading = elementOnNewWindow.getText();

        //closing current window
        driver.close();
        //Switch back to the old tab or window
        driver.switchTo().window((String) windowHandles[0]);


        actions.moveToElement(elementNewTab).click().perform();


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

        // Step 6:  Print the text in new tab
        System.out.println("This is heading of new tab" + newTabHeading);
        assertEquals(SAMPLE_HEADING ,elementOnNewWindowHeading);
        assertEquals(SAMPLE_HEADING, newTabHeading);
    }

}
