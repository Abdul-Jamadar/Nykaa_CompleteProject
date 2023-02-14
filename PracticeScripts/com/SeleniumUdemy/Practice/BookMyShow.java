package com.SeleniumUdemy.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Selenium.basics.BaseClass;

public class BookMyShow extends BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialize();
		driver.get("https://in.bookmyshow.com/");
		List<WebElement> list1 = driver.findElements(By.xpath("//*[@class='sc-ghsgMZ eXcGRS']"));
		String[] str1 = accessWebElements(list1);
		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
		}

		driver.findElement(By.xpath("//*[@class='sc-yZwTr dlgCUo']")).click();

		System.out.println("\nOther available cities: \n");
		List<WebElement> list2 = driver.findElements(By.xpath("//*[@class='sc-fjhmcy hVKYol']"));
		String[] str2 = accessWebElements(list2);
		for (int i = 0; i < str2.length; i++) {
			System.out.println(str2[i]);
		}
		driver.quit();

	}

}
