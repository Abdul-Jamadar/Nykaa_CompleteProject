package Nykaa_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class a_LoginTest extends _Test_Utility {

	@Test
	public void Login_Test() throws Exception {
		// Scenario 1: Sign in And verify Username.
		Launch();
		verifyTitle("Buy Cosmetics Products & Beauty Products Online in India at Best Price | Nykaa");
		homepage = login.Login(phoneNumber);
		Assert.assertTrue(login.verifyLogin("Abdul"));
	}
}
