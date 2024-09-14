package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;

public class AppointmentConfirmPage extends BasePage {

	@FindBy(how = How.ID, using = "facility")
	private WebElement facility;
	@FindBy(how = How.ID, using = "hospital_readmission")
	private WebElement hospitalReadmission;
	@FindBy(how = How.ID, using = "program")
	private WebElement program;
	@FindBy(how = How.ID, using = "visit_date")
	private WebElement visitDate;
	@FindBy(how = How.ID, using = "comment")
	private WebElement comment;

	public AppointmentConfirmPage(WebDriver driver) {
		super(driver);
	}

	public String getFacility() {
		return facility.getText();
	}

	public String getHospitalReadmission() {
		return hospitalReadmission.getText();
	}

	public String getProgram() {
		return program.getText();
	}

	public String getVisitDate() {
		return visitDate.getText();
	}

	public String getComment() {
		return comment.getText();
	}
}
