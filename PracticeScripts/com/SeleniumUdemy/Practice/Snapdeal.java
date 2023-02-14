package com.SeleniumUdemy.Practice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com");
		System.out.println("Loaded website");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#inputValEnter")).sendKeys("Polo Tshirts"+Keys.ENTER);
		driver.findElement(By.xpath("(//*[@class='product-row js-product-list centerCardAfterLoadWidgets dp-click-widgets']//a)[1]")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            driver.switchTo().window(ChildWindow);
        }
        
        File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(SS, new File("./Screenshots/SS.png"));
        
        Set<String> windowss=driver.getWindowHandles();
        Iterator<String> itr=windowss.iterator();
        String handles;
        while(itr.hasNext()) {
        	handles=itr.next();
        }
        System.out.println("Entered first product");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.id("buy-button-id")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("abdullahjamadar1@gmail.com"+Keys.ENTER);
		Thread.sleep(5000);
		Scanner sc=new Scanner(System.in);  
		System.out.println("Enter code received on mail");
		String code=sc.next();
		driver.findElement(By.cssSelector("#verification-code-val")).sendKeys(code+Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#make-payment")).click();
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//*[@class='payment-mode'][3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("make-payment-button")).click();
		//driver.quit();
	}

}
