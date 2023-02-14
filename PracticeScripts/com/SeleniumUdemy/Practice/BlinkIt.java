package com.SeleniumUdemy.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.Selenium.basics.BaseClass;

public class BlinkIt extends BaseClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialize();
		driver.get("https://blinkit.com/");
		WebElement w1=driver.findElement(By.xpath("//*[text()='Detect my location']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Detect my location']")));
		//w1.click();
		driver.findElement(By.xpath("(//input)[1]")).sendKeys("Delhi"+Keys.ENTER);
	}

}
