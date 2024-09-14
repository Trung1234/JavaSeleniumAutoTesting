package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import core.BaseTest;
import pages.KatalonDemoCuraPage;

public class ATC001DoLoginTest extends BaseTest {


	@Test()
	public void testogin() throws InterruptedException {
		// 1. Go to https://katalon-demo-cura.herokuapp.com
		goToLink("https://katalon-demo-cura.herokuapp.com");

		KatalonDemoCuraPage katalonDemoCuraPage = new KatalonDemoCuraPage(getDriver());

		// 2. Click menu toggle at the top right page
		katalonDemoCuraPage.clickMenu();
		// Select “Login”
		katalonDemoCuraPage.clickLoginMenu();

		katalonDemoCuraPage.enterUsername(USER_NAME);
		katalonDemoCuraPage.enterPassword(PASSWORD);
		// + Click Login button
		katalonDemoCuraPage.clickLoginButton();

		// Verify login successful or not
		assertTrue(katalonDemoCuraPage.isLoginSuccessful());
		// Click menu toggle at the top right page
		katalonDemoCuraPage.clickMenu();
		katalonDemoCuraPage.clickLogout();
		
		// Verify logout successful or not
		assertTrue(katalonDemoCuraPage.isLogoutSuccessful());
	}
}
