import common.DriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Exercise4 {
    @Test
    public void executeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // 1. Open Chrome browser
        // (already done above)

        // 2. Maximize the browser window
        driver.manage().window().maximize();

        // 3. Navigate to https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width webpage
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		// Switch to first frame
        driver.switchTo().frame(0);
		// Switch to second frame
        driver.switchTo().frame(0);
        WebElement iframeElement = driver.findElement(By.xpath(" //h1[normalize-space()='This page is displayed in an iframe']"));

        String iframeText = iframeElement.getText();

        if (iframeText.contains("This page is displayed in an iframe")) {
            System.out.println("Expected text found!");
        } else {
            System.out.println("Expected text not found!");
        }
        System.out.println(iframeText);
        Thread.sleep(2000);
        driver.switchTo().parentFrame();
        Thread.sleep(3000);
        driver.close();
        assertEquals(iframeText, "This page is displayed in an iframe");
    }
}
