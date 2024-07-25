package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class DriverManager {
    private WebDriver driver;
//    private WebDriverWait wait;

    private DriverManager(WebDriver driver) {
        this.driver = driver;
//        this.wait = new WebDriverWait(driver, 30);
    }


    public static DriverManager createDriverManager(String browser, boolean headless) {

        WebDriver driver = createDriver(browser, headless);
        return new DriverManager(driver);
    }

    private static WebDriver createDriver(String browser, boolean headless) {
        switch (browser) {
            case "chrome":
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("mobileEmulationEnabled", true);
                capabilities.setCapability("timeouts.implicit", 10); // set implicit wait to 10 seconds

                System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

                return new ChromeDriver(capabilities);
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            case "ie":
                return new InternetExplorerDriver();
            default:
                throw new RuntimeException("Invalid browser specified");
        }
    }
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public void switchToFrame(WebElement windowHandle) {
        driver.switchTo().frame(windowHandle);
    }


    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}