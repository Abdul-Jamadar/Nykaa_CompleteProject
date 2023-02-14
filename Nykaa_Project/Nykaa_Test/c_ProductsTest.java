package Nykaa_Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Nykaa_resources.DataProviderClass;
import Nykaa_resources.Retry;

public class c_ProductsTest extends _Test_Utility {

	@BeforeClass
	public void Login() throws Exception {
		// Scenario 1: Sign in And verify Username.
		Launch();
		verifyTitle("Buy Cosmetics Products & Beauty Products Online in India at Best Price | Nykaa");
		homepage = login.Login(phoneNumber);
		Assert.assertTrue(login.verifyLogin(userName));

	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviderClass.class, retryAnalyzer = Retry.class)
	public void ProdcutsTest(HashMap<String, String> input) throws Exception {
		int count = Integer.parseInt(input.get("productsCount"));
		String[] expectedProducts = new String[count];
		String[] actualProducts = new String[count];

		// Scenario 2: Empty Cart
		String message = homepage.EmptyBag();
		Assert.assertTrue(message.contains("Empty"));

		// Scenario 3: Search for a product and grab top 'x' products details and add
		// that into cart.
		prod = homepage.searchForProducts((String) input.get("searchFor"));
		verifyTitle("Buy Cosmetics Products & Beauty Products Online in India at Best Price | Nykaa");
		expectedProducts = prod.getProductsDetailsAndAddToCart(input.get("searchFor"), count);

		// Scenario 4: Compare the actual products present in the cart with expected
		// products.
		actualProducts = cart.getBagDetails();
		Boolean b = true;
		for (int x = 0, y = count - 1; x < count && y >= 0; x++, y--) {
			if (expectedProducts[x].contains(actualProducts[y])) {
				b = true;
			} else
				b = false;
		}
		Assert.assertTrue(b);
	}

}
