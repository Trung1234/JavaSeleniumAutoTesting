import common.DriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Exercise4 {
    @Test
    public void executeTest() {
        DriverManager driverManager = DriverManager.createDriverManager("chrome", true);
       driverManager.navigate("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

// Or switch to iframe by id
        driverManager.switchToFrame(driverManager.findElement(By.xpath("//iframe[@id='iframeResult']")));
        WebElement element = driverManager.findElement(By.tagName("h1"));

        String test = element.getText();

        driverManager.close();

        assertEquals(test, "This page is displayed in an iframe");
    }

}
