package com.autotest.homework3;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import page.HomePage;
import page.LoginPage;
import setup.SetupBrowser;

public class Exercise3 extends SetupBrowser {
	
	@Test
    public void testLoginLogout() throws InterruptedException {

        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoginSuccessful());
        Thread.sleep(3000);
        HomePage homePage = new HomePage(driver);
        homePage.clickMenu();
        Thread.sleep(2000);
        homePage.clickLogout();
        Thread.sleep(2000);
        assertTrue(homePage.isLogoutSuccessful());

    }
}
