package Nykaa.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class b_HomePage extends _Utility_Nykaa {

	WebDriver driver;

	public b_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String home;

	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement signIn;

	@FindBy(xpath = "//button[contains(text(),'Sign in with Mobile / Email')]")
	WebElement signInOption;

	@FindBy(name = "emailMobile")
	WebElement mobile;

	@FindBy(name = "otpValue")
	WebElement Otp;

	@FindBy(xpath = "//span[@class='css-17ukzrr euw1lbv4']")
	WebElement userName;

	@FindBy(xpath = "//iframe[@class='css-acpm4k']")
	WebElement iframe;

	@FindBy(xpath = "//div[@class='flip-card']")
	List<WebElement> removeButton;

	@FindBy(xpath = "(//div[@class='flip-card']//div[@data-test-id='product-remove'])[1]")
	WebElement deleteButton;

	@FindBy(xpath = "(//button[contains(text(),'Remove')])[1]")
	WebElement removeButton1;

	@FindBy(xpath = "(//span[@class='css-9sv7cv ehes2bo0'])[1]")
	WebElement backButton;

	@FindBy(css = "[class='css-gwu2a1 e171rb9k0']")
	WebElement cartMsg;

	@FindBy(css = "[class='cart-count']")
	WebElement cartCount;
	
	@FindBy(css = "div[class='css-0 e1ewpqpu1'] button")
	WebElement cartButton;
	
	@FindBy(css = "input[name*='search']")
	WebElement searchBar;
	
	@FindBy(xpath = "//div[@class='css-1nsqxbe e80op0e0']")
	WebElement suggestionBox;

	@FindBy(css = "div[class*='suggestion']")
	List<WebElement> suggestions;

	// Scenario 3: Check if Bag is empty- if no, empty the Bag
	public String EmptyBag() throws InterruptedException {
		home=driver.getWindowHandle();
		cartButton.click();
		String msg = null;
		driver.switchTo().frame(iframe);
		if (removeButton.size() > 0) {
			int a = removeButton.size();
			for (int i = 0; i < a; i++) {
				deleteButton.click();
				Thread.sleep(1000);
				removeButton1.click();
				Thread.sleep(1000);
			}
			msg = cartMsg.getText();
			backButton.click();
			driver.switchTo().window(home);
			return msg;
		} else {
			msg = cartMsg.getText();
			backButton.click();
			driver.switchTo().window(home);
			return msg;
		}
	}
	
	// Scenario 4: Search for product.
			public c_ProductsPage searchForProducts(String searchFor) throws IOException {
				searchBar.clear();
				searchBar.sendKeys(searchFor);
				searchBar.click();
				driver.findElement(By.cssSelector("input[name*='search']")).click();
				waitForElementToAppear(10, suggestionBox);
				WebElement s1 = suggestions.stream().filter(p -> p.getAttribute("data-value").equalsIgnoreCase(searchFor))
						.findFirst().orElse(null);
				s1.click();
				return new c_ProductsPage(driver);
			}
}
