package com.SeleniumUdemy.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.Selenium.basics.BaseClass;
public class Myntra extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		initialize();
		driver.get("https://www.myntra.com");
		String value="White sneakers Men";
		driver.findElement(By.xpath("//div[@class='desktop-query']//input")).sendKeys(value+Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='results-base']//li//div[@class='product-productMetaInfo']"));
		String[] str=accessWebElements(list);
		for(int i=0;i<list.size();i++) {
			int k=i+1;
			System.out.println(""+k+". "+list.get(i).getText());
		}
		//driver.quit();
		
	}

}
