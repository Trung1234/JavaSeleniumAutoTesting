package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;

public class LoginPage  extends BasePage {
	
    @FindBy(how = How.NAME, using = "user-name")
    private WebElement userName;

    @FindBy(how = How.NAME, using  = "password")
    private WebElement passwordText;

    @FindBy(how = How.NAME, using  = "login-button")
    private WebElement loginButton;
    
    @FindBy(how = How.CSS, using  = ".inventory_list")
    private WebElement loginPage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void enterUsername(String username) {
		userName.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordText.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public boolean isLoginSuccessful() {
		try {
		    return loginPage.isDisplayed();
		} catch (NoSuchElementException e) {
		    return false;
		}		
	}

}
