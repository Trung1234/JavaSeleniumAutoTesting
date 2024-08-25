package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import interfaces.HomePage;

public class SauceDemoHomePage implements HomePage{
    private WebDriver driver;

    public SauceDemoHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenu() {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }

    public void clickLogout() {
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }

    public boolean isLogoutSuccessful() {
        return driver.findElement(By.name("user-name")).isDisplayed();
    }
}