package com.autotest.homework3;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import page.Guru99HomePage;
import page.Guru99LoginPage;
import setup.SetupBrowser;


public class Practice1 extends SetupBrowser {
	
	@Test
    public void testLoginLogout() throws InterruptedException {
		// 1. Go to https://demo.guru99.com/v4/index.php
        driver.get("https://demo.guru99.com/v4/");

        Guru99LoginPage loginPage = new Guru99LoginPage(driver);
        loginPage.enterUsername("mngr587414");
        loginPage.enterPassword("ybEmaqU");
        // 2. Login with valid account
        loginPage.clickLogin();

        // 3. Verify login successful or not
        assertTrue(loginPage.isLoginSuccessful());
        Thread.sleep(3000);
        Guru99HomePage homePage = new Guru99HomePage(driver);

        // 5. Logout
        homePage.clickLogout();

        // Handle alert popup after logout
        driver.switchTo().alert().accept();
        // Wait for the home page to load after logout and verify
        wait.until(ExpectedConditions.titleContains("Guru99 Bank Home Page"));
        // 6. Verify logout successful or not
        assertTrue(homePage.isLogoutSuccessful());

    }
}