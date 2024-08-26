package pagefactory.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pagefactory.core.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[@href='Logout.php']")
    protected WebElement logoutButton;

    @FindBy(how = How.XPATH, using = "(//tr[@class='heading3'])/td")
    protected WebElement headingLabel;


    public String getLoggedInUser() {

        String lbText = headingLabel.getText();

        String[] parts = lbText.split(":");

        // Trim the second part to remove any leading/trailing spaces
        String managerId = parts[1].trim();

        return managerId;
    }

    public void logout() {

        logoutButton.click();
    }

    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String text = alert.getText();
        alert.accept();

        return text;
    }

}
