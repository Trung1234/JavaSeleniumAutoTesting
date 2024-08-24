package com.autotest.homework3;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import page.Guru99HomePage;
import page.Guru99LoginPage;
import setup.SetupBrowser;


public class Practice1 extends SetupBrowser {
	
	@Test
    public void testLoginLogout() throws InterruptedException {
		// 1. Go to https://demo.guru99.com/v4/index.php
        driver.get("https://demo.guru99.com/v4/index.php/");

        Guru99LoginPage loginPage = new Guru99LoginPage(driver);
        loginPage.enterUsername("mngr587414");
        loginPage.enterPassword("ybEmaqU");
        // 2. Login with valid account
        loginPage.clickLogin();
        Thread.sleep(5000);
        // 3. Verify login successful or not
        assertTrue(loginPage.isLoginSuccessful());
        Thread.sleep(3000);
        Guru99HomePage homePage = new Guru99HomePage(driver);

        // 5. Click Logout
        homePage.clickLogout();
        Thread.sleep(2000);
        // 6. Verify logout successful or not
        assertTrue(homePage.isLogoutSuccessful());

    }
}