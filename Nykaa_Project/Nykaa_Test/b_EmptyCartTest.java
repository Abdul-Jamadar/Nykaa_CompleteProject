package Nykaa_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class b_EmptyCartTest extends _Test_Utility{
	@Test(priority = 1)
	public void Login_Test() throws Exception {
		// Scenario 1: Sign in And verify Username.
		Launch();
		verifyTitle("Buy Cosmetics Products & Beauty Products Online in India at Best Price | Nykaa");
		homepage=login.Login(phoneNumber);
		Assert.assertTrue(login.verifyLogin(userName));
	}

	@Test(dependsOnMethods = {"Login_Test"})
	public void EmptyBag_Test() throws Exception {
		// Scenario 2: Empty the Cart/Bag
		String message = homepage.EmptyBag();
		Assert.assertTrue(message.contains("Empty"));
	}
}
