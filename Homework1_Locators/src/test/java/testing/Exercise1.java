package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {
	private static WebDriver driver;

	public static void main(String[] args) {
		setUpDriver();

		writeSelectorsOfElementById();
		writeSelectorsOfElementByXPath();
		closeDriver();
	}

	private static void setUpDriver() {
		// Set the path to the chromedriver executable if needed
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");

	}

	private static void writeSelectorsOfElementById() {
		// - Name Text Box
		System.out.println("- First Name Text Box : " + getPlaceholderById("firstName"));
		// - Last name Text Box
		System.out.println("- Last name Text Box : " + getPlaceholderById("lastName"));
		// - Email Address Text Box
		System.out.println("- Last name Text Box : " + getPlaceholderById("userEmail"));
		// - Date of Birth Text Box
		System.out.println("- Date of Birth Text Box : " + getValueDatepickerById("dateOfBirthInput"));
		// - Current Address Text Box
		System.out.println("- Current Address Text Box : " + getPlaceholderById("currentAddress"));
		// - Submit Button
		System.out.println("- Submit Button: " + getValuerById("submit"));
	}

	private static void writeSelectorsOfElementByXPath() {
		// - Name Text Box
		System.out.println("- First Name Text Box : " + getPlaceholderByXPath("firstName"));
		// - Last name Text Box
		System.out.println("- Last name Text Box : " + getPlaceholderByXPath("lastName"));
		// - Email Address Text Box
		System.out.println("- Last name Text Box : " + getPlaceholderByXPath("userEmail"));
		// - Date of Birth Text Box
		System.out.println("- Date of Birth Text Box : " + getValueDatepickerByXPath("dateOfBirthInput"));
		// - Current Address Text Box
		// System.out.println("- Current Address Text Box : " +
		// getPlaceholderByXPath("currentAddress"));
		// - Submit Button
		// System.out.println("- Submit Button: " + getValuerByXPath("submit"));
	}

	private static String getPlaceholderById(String id) {
		return driver.findElement(By.id(id)).getAttribute("placeholder");
	}

	private static String getValueDatepickerById(String id) {
		return driver.findElement(By.id(id)).getAttribute("value");
	}

	private static String getValuerById(String id) {
		return driver.findElement(By.id(id)).getText();
	}

	private static String getPlaceholderByXPath(String id) {
		return driver.findElement(By.xpath("//input[@id='" + id + "']")).getAttribute("placeholder");
	}

	private static String getValueDatepickerByXPath(String id) {
		return driver.findElement(By.xpath("//input[@id='" + id + "']")).getAttribute("value");
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
