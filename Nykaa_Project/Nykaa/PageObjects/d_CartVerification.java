package Nykaa.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class d_CartVerification extends _Utility_Nykaa {

	WebDriver driver;

	public d_CartVerification(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='css-0 e1ewpqpu1'] button")
	WebElement viewCart;

	@FindBy(xpath = "//iframe[@class='css-acpm4k']")
	WebElement iframe1;

	@FindBy(xpath = "//div[@data-test-id='cart_body']//div[@data-test-id='cart_item']")
	List<WebElement> cartItems;

	@FindBy(css = "span[class='css-9sv7cv ehes2bo0']")
	WebElement backButton;

	@FindBy(css = "div[class*='dropDown_list']")
	WebElement dropDownList;

	@FindBy(css = "[class='css-dwg5hz euw1lbv0']")
	WebElement profile;

	@FindBy(xpath = "//div[@class='css-1phoa3e'][1]")
	WebElement logOut;

	// Scenario 6: Get details of products inside the Bag.
	public String[] getBagDetails() {
		waitForElementToAppear(5, viewCart);
		viewCart.click();
		driver.switchTo().frame(iframe1);
		String[] actualProducts = new String[cartItems.size()];
		System.out.println("-----------------------** Actual Products List: **-----------------------\n");
		for (int i = 0; i < cartItems.size(); i++) {
			int a = i + 1;
			actualProducts[i] = driver.findElement(By.xpath(
					"(//div[@data-test-id='cart_body']//div[@data-test-id='cart_item']//span[@data-test-id='product-name'])["
							+ a + "]"))
					.getText();
			System.out.println(a + ". " + actualProducts[i] + "\n");
		}
		backButton.click();
		driver.switchTo().defaultContent();
		return actualProducts;
	}

	public void Logout() throws InterruptedException {
		driver.switchTo().defaultContent();
		waitForElementToAppear(5, profile);
		profile.click();
		waitForElementToAppear(5, dropDownList);
		dropDownList.findElement(By.cssSelector("button")).click();
		waitForElementToAppear(5, logOut);
		logOut.click();
	}

}
