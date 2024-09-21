package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage<T> {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT),  Duration.ofSeconds(POLLING));
        PageFactory.initElements(driver, this);
    }   
 // Abstract method to ensure that every page has a specific load check
    public abstract boolean isPageLoaded();

    // A generic method to navigate to a specific URL
    public T navigateTo(String url) {
        driver.get(url);
        return (T) this;
    }
}