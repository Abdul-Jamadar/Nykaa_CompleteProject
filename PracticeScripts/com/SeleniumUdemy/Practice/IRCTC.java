package com.SeleniumUdemy.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IRCTC {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();
//		Thread.sleep(3000);
//		//driver.findElement(By.className("btn btn-primary")).click();
//		//Thread.sleep(3000);
//		driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//ul[@role='listbox']//*[contains(text(),'PUNE')]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@role='searchbox'])[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//ul[@role='listbox']//*[contains(text(),'SOLAPUR')]")).click();
//		driver.findElement(By.xpath("//button[@label='Find Trains']")).click();
		
		try{WebElement x=driver.findElement(By.cssSelector("span[class*='ui-calendar']"));
		System.out.println(x.getText());}catch(Exception e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
