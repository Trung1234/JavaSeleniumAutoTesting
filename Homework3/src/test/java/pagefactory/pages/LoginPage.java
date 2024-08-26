package pagefactory.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pagefactory.core.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.NAME, using = "uid")
    protected WebElement userName;
    @FindBy(how = How.NAME, using = "password")
    protected WebElement password;
    @FindBy(how = How.XPATH, using = "(//input[@name='btnLogin'])")
    protected WebElement loginButton;


    public void navigateToLoginPage(String url) {
        driver.navigate().to(url);
    }

    public void inputUserName(String value) {
        userName.sendKeys(value);
    }

    public void intputPassword(String url) {
        password.sendKeys(url);
    }

    public void clickToLoginButton() {
        loginButton.click();
    }
}