package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;

public class KatalonDemoCuraPage extends BasePage {

	@FindBy(how = How.ID, using = "menu-toggle")
	private WebElement menuToggle;

	@FindBy(how = How.CSS, using = "a[href='profile.php#login']")
	private WebElement loginMenu;

	@FindBy(how = How.LINK_TEXT, using = "Logout")
	private WebElement logoutMenu;

	@FindBy(how = How.ID, using = "txt_comment")
	private WebElement txtComment;

	@FindBy(how = How.NAME, using = "username")
	private WebElement userName;

	@FindBy(how = How.CSS, using = "label[for='txt-username']")
	private WebElement labelUserName;

	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordText;

	@FindBy(how = How.ID, using = "btn-login")
	private WebElement loginButton;

	@FindBy(how = How.ID, using = "btn-book-appointment")
	private WebElement buttonAppointment;

	public KatalonDemoCuraPage(WebDriver driver) {
		super(driver);
	}

	public void clickMenu() throws InterruptedException {
		menuToggle.click();
		Thread.sleep(2000);
	}

	public void clickLoginMenu() {
		loginMenu.click();
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickLogout() throws InterruptedException {
		logoutMenu.click();
		Thread.sleep(2000);
	}

	public void enterUsername(String username) {
		userName.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordText.sendKeys(password);
	}

	public boolean isLoginSuccessful() {
		try {
			return txtComment.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isLogoutSuccessful() {
		try {
			 logoutMenu.isDisplayed();
			 return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

}
