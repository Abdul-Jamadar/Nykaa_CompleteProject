package Nykaa.PageObjects;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class a_LoginPage extends _Utility_Nykaa {

	String OTP;
	String Name;
	String home;

	public a_LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='css-16vyron']")
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

	// Scenario 1: Sign in
	public b_HomePage Login(String phoneNumber) throws Exception {
		home = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		waitForElementToAppear(10, signIn);
		signIn.click();
		waitForElementToAppear(5, signInOption);
		signInOption.click();
		waitForElementToAppear(5, signInOption);
		mobile.sendKeys(phoneNumber + Keys.ENTER);
		Thread.sleep(5000);
		System.out.println("Enter the Otp: ");
		Thread.sleep(5000);
//		OTP = sc.next();
//		Otp.sendKeys(OTP + Keys.ENTER);
		// System.console().readLine();
		return new b_HomePage(driver);
	}

	// Scenario 2: Verify sign in
	public Boolean verifyLogin(String uName) {
		waitForElementToAppear(5, userName);
		Name = userName.getText();
		Boolean match = Name.equalsIgnoreCase(uName);
		return match;
	}

}
