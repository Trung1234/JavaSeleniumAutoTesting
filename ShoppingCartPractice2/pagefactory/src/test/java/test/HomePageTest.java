package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Objects;

import org.testng.annotations.Test;

import core.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest {
	
	@Test
	public void addCartest() throws InterruptedException {

		HomePage homePage = new HomePage(getDriver());
		goToLink("https://react-shopping-cart-67954.firebaseapp.com/index.php/");

		// On the left side, click on filter size = S
		homePage.goFilterSizeS();
		homePage.addItemToCart();
		String subTotal = homePage.getSubtotal();


		homePage.clickCheckOut();


		// Verify the alert is displayed
		assertTrue(Objects.nonNull(homePage.getAlertText()));

		// Verify the subtotal price in the cart and in the alert is matched
		assertEquals(subTotal, homePage.getAlertText().substring(homePage.getAlertText().lastIndexOf("$")) );

	}
}