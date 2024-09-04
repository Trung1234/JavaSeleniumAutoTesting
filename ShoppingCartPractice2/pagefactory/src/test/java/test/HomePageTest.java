package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import core.BaseTest;
import pages.HomePage;

public class HomePageTest  extends BaseTest {
    @Test
    public void addCartest() throws InterruptedException {


        HomePage homePage = new HomePage(getDriver());
        homePage.goToLink("https://react-shopping-cart-67954.firebaseapp.com/index.php/");
        Thread.sleep(2000);
        //On the left side, click on filter size = S
       // homePage.goFilterSizeS();
        homePage.addItemToCart();
//
//        homePage.goToCart();;
        homePage.clickCheckOut();
//
//
//
        Thread.sleep(1000);
        assertTrue(homePage.isAlertExist());
//
//        System.out.println("getSubtotal: "+homePage.getSubtotal());
        System.out.println("getSubtotal: ");

       // assertEquals(homePage.getLoggedInUser(), "mngr587414");



    }
}