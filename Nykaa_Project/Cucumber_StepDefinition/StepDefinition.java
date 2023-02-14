package Cucumber_StepDefinition;

import org.testng.Assert;

import Nykaa.PageObjects.a_LoginPage;
import Nykaa.PageObjects.d_CartVerification;
import Nykaa_Test._Test_Utility;
import io.cucumber.java.en.*;

public class StepDefinition extends _Test_Utility{
	
	String[] actualProducts;
	String[] expectedProducts;
	int count;
	
	@When("^I landed on Nykaa HomePage$")
	public void I_landed_on_Nykaa_HomePage() throws Exception {
		initializeDriver();
		login = new a_LoginPage(driver);
		cart = new d_CartVerification(driver);
		Launch();
		verifyTitle("Buy Cosmetics Products & Beauty Products Online in India at Best Price | Nykaa");
		//System.out.println("Into this");
	}
	
	@Given("^Logged in with phonenumber (.+)$")
	public void logged_in_with_phonenumber(String phoneNumber) throws Exception {
		homepage = login.Login(phoneNumber);
	}

	@Then("^I verify my login with username (.+)$")
	public void i_verify_my_login_with_username(String username){
		Assert.assertTrue(login.verifyLogin(userName));
	}
	
	@When("^I add items (.+) with itemsCount (.+) in cart$")
	public void i_add_items_with_itemscount_in_cart(String items,int itemsCount) throws Exception {
		expectedProducts = new String[itemsCount];
		actualProducts = new String[itemsCount];
		count=itemsCount;
		// Scenario 2: Empty Cart
		String message = homepage.EmptyBag();
		Assert.assertTrue(message.contains("Empty"));

		// Scenario 3: Search for a product and grab top 'x' products details and add
		// that into cart.
		prod = homepage.searchForProducts(items);
		verifyTitle("Buy Cosmetics Products & Beauty Products Online in India at Best Price | Nykaa");
		expectedProducts = prod.getProductsDetailsAndAddToCart(items, itemsCount);

	}

	@Then("^I visit the cart and verify the items present in it$")
	public void i_visit_the_cart_and_verify_the_items_present_in_it() {
		actualProducts = cart.getBagDetails();
		Boolean b = true;
		for (int x = 0, y = count - 1; x < count && y >= 0; x++, y--) {
			if (expectedProducts[x].contains(actualProducts[y])) {
				b = true;
			} else
				b = false;
		}
		Assert.assertTrue(b);
		driver.quit();
	}
}
