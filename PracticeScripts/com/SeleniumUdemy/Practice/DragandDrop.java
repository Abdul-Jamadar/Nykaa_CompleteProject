package com.SeleniumUdemy.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.Selenium.basics.BaseClass;

public class DragandDrop extends BaseClass {

	public static void main(String args[]) throws InterruptedException, IOException {
		initialize();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.cssSelector("#credit2"));
		WebElement src1 = driver.findElement(By.cssSelector("#fourth"));
		WebElement dst = driver.findElement(By.cssSelector("#bank"));
		WebElement dst1 = driver.findElement(By.cssSelector("#amt8"));
		act.dragAndDrop(src, dst).build().perform(); 
		act.dragAndDrop(src1, dst1).build().perform();
		driver.quit();

	}
}
