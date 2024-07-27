package com.autotest.homework3;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.ResultCode;
import page.LoginPage;
import setup.SetupBrowser;

public class Exercise4 extends SetupBrowser {

	/**
	 * Validate 2 fields Username and password
	 * @param username
	 * @param password
	 * @param expectedResult
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "loginData")
	public void testValidateLogin(String username, String password, String expectedResult) throws InterruptedException {
		// 1. Go to https://www.saucedemo.com/
		driver.get("https://www.saucedemo.com/");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		// 2. Validate 2 fields Username and password with 4 cases:
		loginPage.clickLogin();
		Thread.sleep(2000);
		// Verify login successful or not
		if(ResultCode.SUCCESS.getMessage().equals(expectedResult)) {			
			assertTrue(loginPage.isLoginSuccessful());
		} else {
			assertFalse(loginPage.isLoginSuccessful());
		}
	}

	@DataProvider(name = "loginData")
	public Object[][] getDataLogin() {
		Object[][] data = new Object[4][3];

		// blank user, blank pass
		data[0][0] = "";
		data[0][1] = "";
		data[0][2] = ResultCode.BAD_REQUEST.getMessage();

		// invalid user, valid pass
		data[1][0] = "invalidUser";
		data[1][1] = "secret_sauce";
		data[1][2] = ResultCode.NOT_FOUND.getMessage();

		// invalid pass, valid user
		data[2][0] = "standard_user";
		data[2][1] = "invalidPass";
		data[2][2] =  ResultCode.NOT_FOUND.getMessage();

		// valid user, valid pass
		data[3][0] = "standard_user";
		data[3][1] = "secret_sauce";
		data[3][2] = ResultCode.SUCCESS.getMessage();

		return data;
	}
}
