package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import interfaces.HomePage;

public class Guru99HomePage implements HomePage {

	private WebDriver driver;

	public Guru99HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void clickLogout() {
		driver.findElement(By.cssSelector("/a[href='Logout.php']")).click();
	}

	@Override
	public boolean isLogoutSuccessful() {
		// TODO Auto-generated method stub
		return driver.findElement(By.name("btnLogin")).isDisplayed();
	}

}
