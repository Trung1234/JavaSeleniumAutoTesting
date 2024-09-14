package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import core.BasePage;

public class BookingPage extends BasePage {
		
	@FindBy(how = How.ID, using = "btn-book-appointment")
	private WebElement buttonBookAppointment;
	
	@FindBy(how = How.ID, using = "combo_facility")
	private WebElement comboSacility;

	@FindBy(how = How.ID, using = "chk_hospotal_readmission")
	private WebElement chkHospotalReadmission;

	@FindBy(how = How.ID, using = "radio_program_medicaid")
	private WebElement radioMedicaid;
	
	@FindBy(how = How.ID, using = "txt_visit_date")
	private WebElement txtVsitDate;
	
	@FindBy(how = How.ID, using = "txt_comment")
	private WebElement txtComment;
	
	public BookingPage(WebDriver driver) {
		super(driver);
	}

	// ATC-002-Make Appointment
	

	public void selectFacility(String facility) {
		// Create a Select object with the dropdown WebElement
		Select dropdown = new Select(comboSacility);
		// Select an option by visible text
		dropdown.selectByVisibleText(facility);
	}

	public void checkHospotalReadmission() {
		// •Click “Apply for hospital readmission” checkbox
		chkHospotalReadmission.click();
	}
	public void checkRadioMedicaid() {
		radioMedicaid.click();
	}
	
	public void entervsitDate(String visitDate) {
		txtVsitDate.sendKeys(visitDate);
	}
	
	public void enterComment(String comment) {
		txtComment.sendKeys(comment);
	}
	
	public void clickBookAppointment() {
		buttonBookAppointment.click();
	}
	
//	public Boolean isInputInforDisplay() {
//		return chkHospotalReadmission.isSelected() && 
//	}
}
