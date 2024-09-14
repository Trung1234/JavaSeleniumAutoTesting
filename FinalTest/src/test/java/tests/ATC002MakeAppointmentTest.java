package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import core.BaseTest;
import pages.AppointmentConfirmPage;
import pages.BookingPage;
import pages.KatalonDemoCuraPage;


public class ATC002MakeAppointmentTest extends BaseTest {

	private static final String VISIT_DATE  = "22/12/2000";
	private static final String TEST_COMMENT  = "This is test comment";
	private static final String TEST_FACILITY  = "Seoul CURA Healthcare Center";
	private static final String TEST_RADIO  = "Medicaid";
	private static final String READMSION = "Yes";
	
	@Test()
	public void testMakeAppointment() throws InterruptedException {
		// 1. Go to https://katalon-demo-cura.herokuapp.com
		goToLink("https://katalon-demo-cura.herokuapp.com");

		KatalonDemoCuraPage katalonDemoCuraPage = new KatalonDemoCuraPage(getDriver());
		// 2. Click “Make Appointment” button
		katalonDemoCuraPage.clickMakeAppointment();
		//+ Enter username and password in Demo account
		katalonDemoCuraPage.enterUsername(USER_NAME);
		katalonDemoCuraPage.enterPassword(PASSWORD);
		// + Click Login button
		katalonDemoCuraPage.clickLoginButton();
		BookingPage bookingPage = new BookingPage(getDriver());
		// •	Select “Seoul CURA Healthcare Center” in Facility
		bookingPage.selectFacility(TEST_FACILITY);
		// •	Click “Apply for hospital readmission” checkbox
		bookingPage.checkHospotalReadmission();
		// •	Select “Medicaid” radio button
		bookingPage.checkRadioMedicaid();
		// •	Enter the date time in Visit Date
		bookingPage.entervsitDate(VISIT_DATE);
		//•	Enter the comment as “This is test comment”
		bookingPage.enterComment(TEST_COMMENT);
		// Click “Book Appointment” button
		bookingPage.clickBookAppointment();		
		// Verify the information on the screen
		AppointmentConfirmPage appointmentConfirmPage = new AppointmentConfirmPage(getDriver());

		assertEquals(TEST_FACILITY,appointmentConfirmPage.getFacility());
		assertEquals(READMSION,appointmentConfirmPage.getHospitalReadmission());
		assertEquals(TEST_RADIO,appointmentConfirmPage.getProgram());
		assertEquals(VISIT_DATE,appointmentConfirmPage.getVisitDate());
		assertEquals(TEST_COMMENT,appointmentConfirmPage.getComment());
	}
}