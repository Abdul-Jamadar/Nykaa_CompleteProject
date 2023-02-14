package com.Selenium.basics;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class StreamPractice extends BaseClass{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialize();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		List<WebElement> elementsList=driver.findElements(By.xpath("//table[@id='customers']//tr//td[1]"));
		List<String> list=elementsList.stream().filter(s->s.getText().contains("Adobe")).map(s->getCountry(s)).collect(Collectors.toList());
		list.forEach(a->System.out.println(a));
	}
	
	public static String getCountry(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[2]")).getText();
		
	}

}
