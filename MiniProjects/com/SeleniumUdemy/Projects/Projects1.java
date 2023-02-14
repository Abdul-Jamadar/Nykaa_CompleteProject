//Go to Amazon
//search for sneakers for men
//apply filters price 500-1000 and customer reviews 4 and up
//grab top 5 product's brand & price.
//do the same in Flipkart.

package com.SeleniumUdemy.Projects;
import com.Selenium.basics.BaseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class Projects1 extends BaseClass {

	public static void main(String[] args) throws Exception {
		initialize();
		String[] amazonProductsPrice = new String[5];
		// AMAZON
		System.out.println("****************AMAZON****************");
		driver.get("https://www.amazon.in/");
		String keyword = "Sneakers for men";

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword + Keys.ENTER);

		// Apply 4 and above filter
		driver.findElement(By.xpath("(//div[@id='reviewsRefinements']//li)[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'₹500 - ₹1,000')]")));

		// Apply 500-1000 RS filter.
		driver.findElement(By.xpath("//*[contains(text(),'₹500 - ₹1,000')]")).click();

		// Take SS
		// ScrollingBy("900");
		TakeScreenshot("Amazon");

		// Grab price of top 5 products.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='SEARCH_RESULTS']")));
		List<WebElement> productListAmazon = driver.findElements(By.cssSelector("div[class*='SEARCH_RESULTS']"));
		for (int i = 0; i < 5; i++) {
			int a = i + 1;
			amazonProductsPrice[i] = productListAmazon.get(i).findElement(By.cssSelector("span[class='a-price-whole']"))
					.getText();
			String brand = driver.findElement(By.xpath("(//h5)[" + a + "]")).getText();
			System.out.println(a + ". Brand is " + brand + " and cost is Rs." + amazonProductsPrice[i]
					+ "\n-------------------------------------------------");

		}

		System.out.println("****************FLIPKART****************");
		// FLIPKART
		String[] flipkartProducts = new String[5];

		driver.get("https://www.flipkart.com/");

		Thread.sleep(2000);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='q']")));

		// Search
		driver.findElement(By.cssSelector("[name='q']")).sendKeys(keyword + Keys.ENTER);

		// Applying filter
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@class='_2YxCDZ'])[1]")));
		Select minPriceList = new Select(driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[1]")));
		minPriceList.selectByValue("500");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[contains(text(),'4★ & above')]")).click();

		Thread.sleep(2000);

		Select maxPriceList = new Select(driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[2]")));
		maxPriceList.selectByVisibleText("₹1000");

		Thread.sleep(2000);

		// Take SS
		// ScrollingBy("480");
		TakeScreenshot("Flipkart");
		
		//Display top 5 brands and its price
		for (int i = 0; i < 5; i++) {
			int a = i + 1;
			flipkartProducts[i] = driver
					.findElement(By.xpath("(//div[@class='_1YokD2 _3Mn1Gg']//div[@class='_30jeq3'])[" + a + "]"))
					.getText().split("₹")[1];
			String brand = driver.findElement(By.xpath("(//div[@class='_2WkVRV'])[" + a + "]")).getText();
			System.out.println(a + ". Brand is " + brand + " and cost is Rs." + flipkartProducts[i]
					+ "\n---------------------------------------");
		}

	}

}
