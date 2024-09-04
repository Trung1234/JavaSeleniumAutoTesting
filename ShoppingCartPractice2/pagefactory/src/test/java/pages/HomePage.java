package pages;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.BasePage;



public class HomePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@value='S']/following-sibling::span")
    private WebElement sizeSButton;

    @FindBy(xpath = "//div[@class='sc-1h98xa9-2 fGgnoG']")
    private WebElement cartIcon;

    @FindBy(xpath = "//p[text()='SUBTOTAL']/following-sibling::div/p")
    private WebElement lblSubTotalAmount;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> btnAddCarts;

    @FindBy(xpath = "//button[text()='Checkout']")
    private WebElement checkOutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isAlertExist() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //Store the alert text in a variable
        String text = alert.getText();
        return Objects.nonNull(text);
    }

    public void goToLink(String url) {
        driver.get(url);
    }

    public String getSubtotal() {
        return lblSubTotalAmount.getText();
    }

    public void addItemToCart() {
        if (!btnAddCarts.isEmpty()) {
        	WebElement btnAddToCart = btnAddCarts.get(0);
        	btnAddToCart.click();
        	btnAddToCart.click();
        }
    }

//    public void goToCart() {
//        cartIcon.click();
//    }

    public void goFilterSizeS() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete'"));
        sizeSButton.click();
    }

    public void clickCheckOut() {
        checkOutButton.click();
    }
}