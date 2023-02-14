package com.SeleniumUdemy.Practice;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.Selenium.basics.BaseClass;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


public class GoDaddy extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		initialize();
		driver.get("https://www.j2store.org/demo-stores.html");
		TakeScreenshot("ScreenShot");
//		String title=driver.getTitle();
//		Assert.assertEquals(title, "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN");
//		String url=driver.getCurrentUrl();
//		Assert.assertEquals(url, "https://www.godaddy.com/en-in");
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("id-d6f9deab-d554-45df-a52c-8a9ab53948b5")));
//		driver.findElement(By.id("id-d6f9deab-d554-45df-a52c-8a9ab53948b5")).click();
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("((//ul)[2]//li)[2]")));
//		driver.findElement(By.xpath("((//ul)[2]//li)[2]")).click();
//		Assert.assertEquals(driver.getTitle(), "Domain Name Search - Buy and Register Available Domains GoDaddy IN");
//		List<WebElement> headLinks=driver.findElements(By.xpath("//li[@class='menu fmenu']"));
//		for(int i=0;i<headLinks.size();i++) {
//			if(i==4) {
//				break;
//			}
//			headLinks.get(i).click();
//			Thread.sleep(2000);
//			List<WebElement> subLinks=driver.findElements(By.xpath("(//*[@class='cms-nav open'])//li[@class='menu fmenu expanded']//li"));
//			for(int j=0;j<subLinks.size();j++) {
//				System.out.println(subLinks.get(j).getText()); 
//			}
//			System.out.println("-----------------------------------------------------------------");
//		}
		List<WebElement> links = driver.findElements(By.cssSelector("a[href*='https']"));
		SoftAssert a =new SoftAssert();
		for (WebElement link : links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode < 400, "The link with Text " + link.getText() + " is broken with code "  + respCode);
		}
		try{
			a.assertAll();
		}catch(Exception e) {
			e.printStackTrace();
	}
		driver.quit();
	}

}
