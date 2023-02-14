package com.SeleniumUdemy.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Selenium.basics.BaseClass;
/*
 * Navigate to Green Kart
 * Add items and quantity
 * Checkout and Compare the items in cart with users input
 * 
 * */
public class GreenKart extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		initialize();
		String[] items = new String[] { "Mango", "Apple", "Corn", "Banana", "Pears" };
		int[] qty = new int[] { 12, 6, 3, 12, 4 };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> list = driver.findElements(By.xpath("//h4"));
		String[] str = accessWebElements(list);
		int x = 0;
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < str.length; j++) {
				if (str[j].contains(items[i])) {
					// System.out.println(items[i]+" "+str[j]);
					x = j + 1;
					WebElement e = driver
							.findElement(By.xpath("(//div[@class='product']//div//a[@class='increment'])[" + x + "]"));
					for (int k = 1; k < qty[i]; k++) {
						e.click();
					}
					// System.out.println(x);
					driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[" + x + "]")).click();
					Thread.sleep(5000);
					break;
				}
			}
		}

		System.out.println("Printing Cart Items and Quantity");
		driver.findElement(By.xpath("//*[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		Thread.sleep(2000);
		List<WebElement> list1 = driver.findElements(By.xpath("//tr"));
		String[] cartItems = new String[list1.size() - 1];
		String[] finalPrice = new String[cartItems.length];
		int g = 2;
		for (int j = 2, k = 0; j <= list1.size(); j++, k++) {
			// (2,2 2,3)(3,2 3,3)(4,2 4,3)
			cartItems[k] = driver.findElement(By.xpath("(//*[@id='productCartTables']//tr)[" + j + "]//td[" + g + "]"))
					.getText();
			int a = g + 1;
			finalPrice[k] = driver.findElement(By.xpath("(//*[@id='productCartTables']//tr)[" + j + "]//td[" + a + "]"))
					.getText();
		}
		int[] finalQty = new int[finalPrice.length];
		for (int i = 0; i < finalPrice.length; i++) {
			finalQty[i] = Integer.parseInt(finalPrice[i]);
		}
		driver.quit();
		short z = 0;
		for (int c = 0; c < cartItems.length; c++) {
			if (items[c].equalsIgnoreCase(cartItems[c].split("-")[0].replace(" ", "")) && qty[c] == finalQty[c]) {
				z = 0;
			} else {
				System.out.println("Mismatch");
				z = 1;
			}
		}
		if (z == 0) {
			System.out.println("Test Passed.");
		} else {
			System.out.println("Test Failed");
		}
	}

}
