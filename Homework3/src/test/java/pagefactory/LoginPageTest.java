package pagefactory;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagefactory.core.BaseTest;
import pagefactory.pages.HomePage;
import pagefactory.pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.navigateToLoginPage("https://demo.guru99.com/v4/");
        loginPage.inputUserName("mngr587414");
        loginPage.intputPassword("ybEmaqU");
        loginPage.clickToLoginButton();

        Thread.sleep(1000);

        assertEquals(homePage.getLoggedInUser(), "mngr587414");

        homePage.logout();

        Thread.sleep(1000);

        Assert.assertEquals("You Have Succesfully Logged Out!!", homePage.getAlertText());

    }
}