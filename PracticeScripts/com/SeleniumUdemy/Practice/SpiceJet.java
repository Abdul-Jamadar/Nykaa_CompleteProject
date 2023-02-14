package com.SeleniumUdemy.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Selenium.basics.BaseClass;

public class SpiceJet extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		initialize();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("(//*[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).clear();
		driver.findElement(By.xpath("(//*[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).clear();
		driver.findElement(By.xpath("(//*[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).click();
		List<WebElement> list1 = driver.findElements(By.xpath("(//*[@class='css-1dbjc4n r-19yat4t r-1rt2jqs'])[1]"));
		String[] str1 = accessWebElements(list1);
		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
		}
		driver.findElement(By.xpath("(//*[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]"))
				.sendKeys("Pune");
		driver.findElement(By.xpath("(//*[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).clear();
		driver.findElement(By.xpath("(//*[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]"))
				.sendKeys("Delhi");
		driver.findElement(By.xpath("(//*[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41'])[15]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']"))
				.click();
		driver.quit();
	}
}
