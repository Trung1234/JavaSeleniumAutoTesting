package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
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
		return driver.findElement(By.cssSelector(".inventory_list")).isDisplayed();
	}
}