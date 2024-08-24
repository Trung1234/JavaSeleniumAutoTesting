package com.autotest.homework3;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import page.SauceDemoHomePage;
import page.SauceDemoLoginPage;
import setup.SetupBrowser;

/**
 * Automated this test case using POM
 * @author Admin
 *
 */
public class Exercise3 extends SetupBrowser {
	
	@Test
    public void testLoginLogout() throws InterruptedException {
		// 1. Go to https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        // 2. Login with valid account
        loginPage.clickLogin();
        // 3. Verify login successful or not
        assertTrue(loginPage.isLoginSuccessful());
        Thread.sleep(3000);
        SauceDemoHomePage homePage = new SauceDemoHomePage(driver);
        // 4. Click top left menu
        homePage.clickMenu();
        Thread.sleep(2000);
        // 5. Click Logout
        homePage.clickLogout();
        Thread.sleep(2000);
        // 6. Verify logout successful or not
        assertTrue(homePage.isLogoutSuccessful());

    }
}
