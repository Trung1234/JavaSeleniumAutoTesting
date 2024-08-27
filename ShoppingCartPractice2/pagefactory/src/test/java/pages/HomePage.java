package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;



public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='S']")
    protected WebElement sizeSButton;

    @FindBy(how = How.XPATH, using = "//div[@class='sc-1h98xa9-2 fGgnoG']")
    protected WebElement cartIcon;

    @FindBy(how = How.CSS, using = "div[class='sc-124al1g-2 dwOYCh'] button[class='sc-124al1g-0 jCsgpZ']")
    protected WebElement addCartButton;

}