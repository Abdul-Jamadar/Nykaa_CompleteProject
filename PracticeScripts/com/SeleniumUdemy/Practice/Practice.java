package com.SeleniumUdemy.Practice;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class Practice {

	@Test
	public void Run() throws IOException, InterruptedException {
		// TODO Auto-generated method 
		MutableCapabilities cpas=new MutableCapabilities();
		WebDriver driver=new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),cpas);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		driver.get("https://www.amazon.in/");
		jse.executeScript("document.getElementById('twotabsearchtextbox').setAttribute('value','Ball')");
		jse.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bat"+Keys.ENTER);
//		File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		Files.copy(SS,new File("./ScreenShotFolder/SS.png"));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[data-index='3']")).click();
		String tab = null;
		Set<String> tabs=driver.getWindowHandles();
		Iterator<String> itr=tabs.iterator();
		while(itr.hasNext()) {
			tab=itr.next();
		}
		driver.switchTo().window(tab);
		System.out.println(driver.findElement(By.xpath("(//h1)[1]")).getText());
		
	}

}
