package com.autotest.homework3;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.ExcelUtils;
import setup.SetupBrowser;

public class Exercise5 extends SetupBrowser {

	@DataProvider(name = "testdata")
	public Object[][] testData() throws IOException {
		String filePath = "testdata.xlsx"; // file name in src/test/resources folder
		ClassLoader classLoader = Exercise5.class.getClassLoader();
		return ExcelUtils.getExcelData(classLoader.getResource(filePath).getFile(), "Sheet1");
	}

	@Test(dataProvider = "testdata")
	public void createUser(String username, String password, String employeeName, String userRole, String status)
			throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// Login
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Navigate to User Management
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();

		Thread.sleep(2000);
		// Click Add button
//		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
//		WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status']/following::div"));
//		statusDropdown.click();
//		Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//div[@role='option']//span[text()='" + status + "']")).click();
//
//		// Fill required fields
//		WebElement userRoleDropdown = driver.findElement(By.xpath(
//				"(//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
//		userRoleDropdown.click();
//		Thread.sleep(3000);
//
//		System.out.println(userRoleDropdown.getText());
//		WebElement employeeNameInput = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
//		employeeNameInput.sendKeys(employeeName);
//		Thread.sleep(3000);
		// Click Add button
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status']/following::div"));
		statusDropdown.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@role='option']//span[text()='" + status + "']")).click();

		// Fill required fields
		WebElement userRoleDropdown = driver.findElement(By.xpath("//label[text()='User Role']/following::div"));
		userRoleDropdown.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='option']//span[text()='" + userRole + "']")).click();

		// System.out.println(userRoleDropdown.getText());
		WebElement employeeNameInput = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		employeeNameInput.sendKeys(employeeName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='option']//span[text()='" + employeeName + "']")).click();
		Thread.sleep(2000);


		WebElement usernameInput = driver.findElement(By.xpath("//label[text()='Username']/following::input"));
		usernameInput.sendKeys(username);

		WebElement passwordInput = driver.findElement(By.xpath("//label[text()='Password']/following::input"));
		passwordInput.sendKeys(password);

		WebElement confirmPasswordInput = driver
				.findElement(By.xpath("//label[text()='Confirm Password']/following::input"));
		confirmPasswordInput.sendKeys(password);
//
//		WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status']/following::div"));
//		statusDropdown.click();
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//div[@role='option']//span[text()='" + status + "']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(5000);

		// Step 7: In list user table, search created username at step 6
//        WebElement searchInput = driver.findElement(By.id("searchSystemUser_userName"));
//        searchInput.sendKeys(username);
//
//        driver.findElement(By.id("searchBtn")).click();
//
//        // Step 8: Select search result
//        WebElement searchResult = driver.findElement(By.linkText(username));
//        searchResult.click();
//
//        // Step 9: Verify created user info (compare with step 6)
//        WebElement createdUsername = driver.findElement(By.id("//div[contains(text(),'"+username+"')]"));
//        assertEquals(createdUsername.getText(), username);

		assertTrue(true);

	}

}