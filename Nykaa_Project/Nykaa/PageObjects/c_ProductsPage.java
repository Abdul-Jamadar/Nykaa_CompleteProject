package Nykaa.PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class c_ProductsPage extends _Utility_Nykaa {
	
	WebDriver driver;
	
	public c_ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	WebElement productName;

	@FindBy(xpath = "//div[@class='css-vp18r8']//button[@class=' css-12z4fj0']")
	WebElement cartButton;

	@FindBy(css = "div[class*='css-43m2vm']")
	List<WebElement> products;

	//Sceanrio 5: Get top 'n' products details and add them to cart. 
	public String[] getProductsDetailsAndAddToCart(String searchFor, int productsCount) throws Exception {
		String home=driver.getWindowHandle();
		String[] expectedProducts=new String[products.size()];
		System.out.println("-----------------------** Expected Products List: **-----------------------\n");
		for (int i = 0; i < productsCount; i++) {
			int a = i + 1;
			jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", products.get(i));
			Thread.sleep(2000);
			products.get(i).click();
			Set<String> tabs = driver.getWindowHandles();
			Iterator<String> itr = tabs.iterator();
			while (itr.hasNext()) {
				driver.switchTo().window(itr.next());
			}
			ScrollingBy("200");
			TakeScreenshot(searchFor+" "+a);
			expectedProducts[i] = productName.getText();
			System.out.println(a + ". " + expectedProducts[i] + "\n");
			try {
			if(cartButton.isDisplayed()) {
				cartButton.click();
			}
			else
				continue;
			}catch(Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(home);
		}
		return expectedProducts;
	}
}
