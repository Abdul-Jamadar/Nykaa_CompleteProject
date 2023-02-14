package com.Selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Height_Width extends BaseClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialize();
		driver.get("http://www.google.in");
		WebElement box=driver.findElement(By.name("q"));
		System.out.println(box.getRect().getDimension());
		System.out.println(box.getRect().getWidth());
		
		driver.quit();
	}

}
