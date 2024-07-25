import common.DriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Exercise3 {
    @Test
    public void executeTestNewWindow() {
        DriverManager driverManager = DriverManager.createDriverManager("chrome", true);
        driverManager.navigate("https://demoqa.com/browser-windows");

        WebElement element = driverManager.findElement(By.id("windowButton"));

        Actions actions = new Actions(driverManager.getDriver());
        actions.moveToElement(element).click().perform();

        // Get the handle of the current window
        String currentWindowHandle = driverManager.getWindowHandle();

        // Get the handles of all windows
        Set<String> windowHandles = driverManager.getWindowHandles();

        // Switch to the new window
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driverManager.switchToWindow(windowHandle);
                break;
            }
        }
        // Now you can get elements on the new window
        WebElement elementOnNewWindow = driverManager.findElement(By.id("sampleHeading"));

        String test = elementOnNewWindow.getText();

        driverManager.close();;

        assertEquals(test, "This is a sample page");
    }

//    @Test
//    public void executeTestNewWTab() {
//        DriverManager driverManager = DriverManager.createDriverManager("chrome", true);
//        driverManager.navigate("https://demoqa.com/browser-windows");
//
//        WebElement elementNewTab = driverManager.findElement(By.id("tabButton"));
//        Actions actions = new Actions(driverManager.getDriver());
//        actions.moveToElement(elementNewTab).click().perform();
//
//
//        // Get the handle of the current window
//        String currentTabHandle = driverManager.getWindowHandle();
//
//// Get the handles of all windows
//        Set<String> tabHandles = driverManager.getWindowHandles();
//
//
//// Switch to the new window
//        for (String tabHandle : tabHandles) {
//            if (!tabHandle.equals(currentTabHandle)) {
//                driverManager.switchToWindow(tabHandle);
//                break;
//            }
//        }
//        driverManager.close();
//        WebElement elementOnNewTab = driverManager.findElement(By.id("sampleHeading"));
//        String test = elementOnNewTab.getText();
//        System.out.println("This is heading of new tab"+elementOnNewTab.getText());
//        assertEquals(test, "This is a sample page");
//    }


}
