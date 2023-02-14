package Nykaa_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class d_LogoutTest extends _Test_Utility {

	@Test
	public void LoggingIn_Test() throws Exception {
		// Scenario 1: Sign in And verify Username.
		Launch();
		verifyTitle("Buy Cosmetics Products & Beauty Products Online in India at Best Price | Nykaa");
		homepage = login.Login(phoneNumber);
		Assert.assertTrue(login.verifyLogin(userName));
	}

	@Test(dependsOnMethods = { "Login_Test" })
	public void LoggingOut_Test() throws Exception {
		cart.Logout();
	}
}
