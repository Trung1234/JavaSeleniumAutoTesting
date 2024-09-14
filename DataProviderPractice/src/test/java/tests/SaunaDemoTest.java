package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseTest;
import core.ExcelUtils;
import core.ResultCode;
import pages.LoginPage;



public class SaunaDemoTest extends BaseTest {

	@Test(dataProvider = "loginData")
	public void testogin(String username, String password, String result) throws InterruptedException {
		// 1. Go to https://www.saucedemo.com/
		goToLink("https://www.saucedemo.com/");

		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		// 2. Validate 2 fields Username and password with 4 cases:
		loginPage.clickLogin();
		Thread.sleep(2000);
		// Verify login successful or not
		if (ResultCode.SUCCESS.getMessage().equalsIgnoreCase(result)) {
			assertTrue(loginPage.isLoginSuccessful());
		} else {
			assertFalse(loginPage.isLoginSuccessful());
		}
	}


	@DataProvider(name = "loginData")
	public Object[][] getDataLogin() throws Exception {

//		// invalid pass, invalid user
//		data[4][0] = "standard_user";
//		data[4][1] = "invalidPass";
//		data[4][2] = ResultCode.NOT_FOUND.getMessage();
//		return data;
//		return new Object[][]
//                {
//                        {"", "", ResultCode.BAD_REQUEST.getMessage()},
//                        {"invalidUser", "secret_sauce",ResultCode.NOT_FOUND.getMessage()},
//                        {"standard_user", "ResultCode",ResultCode.NOT_FOUND.getMessage() },
//                        {"standard_user", "secret_sauce",ResultCode.SUCCESS.getMessage()}
//                };
		String filePath = "DataLogin.xlsx"; // file name in src/test/resources folder
		ClassLoader classLoader = SaunaDemoTest.class.getClassLoader();
		return ExcelUtils.getTableArray(classLoader.getResource(filePath).getFile(), "Data");
	}
}