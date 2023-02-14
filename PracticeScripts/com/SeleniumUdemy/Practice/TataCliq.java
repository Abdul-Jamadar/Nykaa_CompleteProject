//	Taking details of top 10 products on Tata Cliq website each product opens in a differently tab.

package com.SeleniumUdemy.Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.Selenium.basics.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TataCliq extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		initialize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.tatacliq.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-text-input")));
		driver.findElement(By.id("search-text-input")).sendKeys("Trimmer" + Keys.ENTER);
		String str = driver.getWindowHandle();
		Thread.sleep(3000);
		List<WebElement> products = driver
				.findElements(By.xpath("//div[@id='grid-container']//div[@class='Grid__element']"));
		for (int i = 0; i < 10; i++) {
			products.get(i).click();
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			itr.next();
			driver.switchTo().window(itr.next());
			// driver.switchTo().window();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//div[@class='ProductGalleryDesktop__image'])[1]")));
			System.out.println(driver.getTitle().split(" ")[1]);
			driver.close();
			driver.switchTo().window(str);

		}
	}

}
