package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise2 {

	private static WebDriver driver;

	public static void main(String[] args) {
		setUpDriver();

		writeSelectorsOfElements();
		closeDriver();
	}

	private static void setUpDriver() {
		// Set the path to the chromedriver executable if needed
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"https://account.booking.com/sign-in?op_token=EgVvYXV0aCKOAwoUdk8xS2Jsazd4WDl0VW4yY3BaTFMSCWF1dGhvcml6ZRo1aHR0cHM6Ly9zZWN1cmUuYm9va2luZy5jb20vbG9naW4uaHRtbD9vcD1vYXV0aF9yZXR1cm4qrQJVc01CaWVBYi01cmdzb3FNaUdJRkk3ei1IWUFqcmE0NDlDc2hBMGNMUVdaNk9BU3RRXzBuT2Jqb0tDbmFhY2hQMWVKWjQzQmdaU1ZoSDV4MXdiXzd2ZDE1c3VHZXpOaHFlcmpYQmtySVZ5WGxQeWdfVW5NZW15VGQxTU5lNGhJYjVJRm41MWNwZVZuaEtERlB0a2RnOTB1YmY5aGloellxa0sySWhWY09taVl1QVNQbVZQblVjbUgxNnJ6ZXVFeDFUZ1FzMHpYUnVmSjBjaGlwUGxZN2pXV1hXbkxGczBxMzhUOGc3dlRZQVM1eUZMTk9xSTBSNzN4aU9FME9SNHBNcWVSMTNDWFQqZXlKcFpDSTZJblJ5WVhabGJHeGxjbDlvWldGa1pYSWlmUT09QgRjb2RlKjEIjsgSMP7ins_akic6AEIAWLne-bQGkgEQdHJhdmVsbGVyX2hlYWRlcpoBBWluZGV4");

	}

	private static void writeSelectorsOfElements() {
		// - Email address Box
		System.out.println("- Email address Text Box by id  : " + getPlaceholderById("username"));
		// .driver. username
		System.out.println("- Email address Text Box by  name : " + getPlaceholderByName("username"));
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

		// Check if the button has type="submit"
		if ("submit".equals(submitButton.getAttribute("type"))) {
			System.out.println("- Text in button : " + submitButton.findElement(By.tagName("span")).getText());
		}
		// 'Sign in with Facebook'
		// //a[@title='Sign in with Facebook']
		WebElement facebookButton = driver.findElement(By.xpath("//a[@title='Sign in with Facebook']"));

		System.out.println("- Text in facebook Button : " + facebookButton.getAttribute("title"));
	}

	private static String getPlaceholderById(String id) {
		return driver.findElement(By.id(id)).getAttribute("placeholder");
	}

	private static String getPlaceholderByName(String name) {
		return driver.findElement(By.name(name)).getAttribute("placeholder");
	}

	/**
	 * Method to close the drive
	 */
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
