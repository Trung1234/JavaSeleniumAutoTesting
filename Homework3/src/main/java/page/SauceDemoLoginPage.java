package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import interfaces.LoginPage;

public class SauceDemoLoginPage implements LoginPage{
	private WebDriver driver;

	public SauceDemoLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(By.name("user-name")).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(By.name("login-button")).click();
	}

	public boolean isLoginSuccessful() {
		try {
		    return driver.findElement(By.cssSelector(".inventory_list")).isDisplayed();
		} catch (NoSuchElementException e) {
		    return false;
		}		
	}
}