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
		homePage.goToLink("https://react-shopping-cart-67954.firebaseapp.com/index.php/");
		Thread.sleep(2000);
		// On the left side, click on filter size = S
		homePage.goFilterSizeS();
		homePage.addItemToCart();
		String subTotal = homePage.getSubtotal();
		System.out.println("subtotal price in the cart : " + subTotal);

		homePage.clickCheckOut();

		Thread.sleep(1000);
		// Verify the alert is displayed
		assertTrue(Objects.nonNull(homePage.getAlertText()));

		// Verify the subtotal price in the cart and in the alert is matched
		System.out.println("Alert text: " + homePage.getAlertText());

		assertEquals(subTotal, homePage.getAlertText().substring(homePage.getAlertText().lastIndexOf("$")) );

	}
}