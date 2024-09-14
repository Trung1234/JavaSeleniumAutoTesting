package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import core.BaseTest;
import pages.KatalonDemoCuraPage;


public class ATC002MakeAppointmentTest extends BaseTest {

	private static final String VISIT_DATE  = "22/12/2000";
	private static final String TEST_COMMENT  = "This is test comment";
	private static final String TEST_FACILITY  = "Seoul CURA Healthcare Center";

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