package com.Selenium.basics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor jse;
	public static Actions act;
	public static Scanner sc = new Scanner(System.in);

	public static void initialize() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		act = new Actions(driver);

	}

	public static String[] accessWebElements(List<WebElement> list) {
		String[] str = new String[list.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = list.get(i).getText();
		}
		return str;
	}

	public static void TakeScreenshot(String fileName) throws IOException {
		File SS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SS, new File("./ScreenShot/" + fileName + ".png"));
	}

	public static void ScrollingBy(String pixels) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + pixels + ")", "");
	}
}
