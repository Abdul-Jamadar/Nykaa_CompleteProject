package Nykaa.PageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class _Utility_Nykaa {
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor jse;
	public Actions act;
	public Scanner sc = new Scanner(System.in);

	public _Utility_Nykaa(WebDriver driver) {
		this.driver=driver;
	}

	public void waitForElementToAppear(int seconds, WebElement signInOption) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(signInOption));
	}
	
	public void waitForElementToBeClickable(int seconds, WebElement signInOption) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(signInOption));
	}

	public void TakeScreenshot(String fileName) throws IOException {
		File SS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SS, new File("./Nykaa_Project/ScreenShots/" + fileName + ".png"));
	}
	
	public void ScrollingBy(String pixels) {
		jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + pixels + ")", "");
	}

}
