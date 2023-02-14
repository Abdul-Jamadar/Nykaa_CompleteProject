package com.SeleniumUdemy.Practice;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Amazon {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String username = "abdullahjamadar1";
		String accesskey = "1g2Ndg1jErlaIjYI5Hn1y2SD861ZY2TwJMsTqsefi30BE6pXPf";
		String gridURL = "@hub.lambdatest.com/wd/hub";
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setCapability("platform", "win10");
		WebDriver driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL),
				capabilities);
		driver.get("https://www.amazon.in");
		// driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Black");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("black" + Keys.ENTER).build().perform();
		// a.
		// driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[1]/span/a/div/img"))
		driver.close();
	}

}
