package com.Selenium.basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;


public class PartialScreenshot extends BaseClass{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		initialize();
		driver.get("https://www.amazon.in/");
		WebElement s=driver.findElement(By.id("twotabsearchtextbox"));
		s.sendKeys("Sunglasses");
		WebElement x=driver.findElement(By.xpath("//div[@class='nav-search-field ']"));
		
		// Logic for taking screenshot for 'x' Webelement.
		File file=x.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("PartialScreenshot.png"));
		
		driver.quit();
		
	}

}
