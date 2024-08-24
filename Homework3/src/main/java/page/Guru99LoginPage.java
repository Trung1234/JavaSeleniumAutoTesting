package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import interfaces.LoginPage;

public class Guru99LoginPage implements LoginPage {
	private WebDriver driver;

	public Guru99LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void enterUsername(String username) {
		driver.findElement(By.cssSelector("input[name='uid']")).sendKeys(username);

	}

	@Override
	public void enterPassword(String password) {
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
	}

	@Override
	public void clickLogin() {
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

	}

	@Override
	public boolean isLoginSuccessful() {
		return driver.getTitle().contains("Home");
	}

}