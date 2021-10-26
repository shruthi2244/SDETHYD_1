package com.mmt.practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LenskartTest {
	public static void main(String args[]) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.lenskart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> allLinks=driver.findElements(By.name("//input[@name=\"q\"]"));
	//int noOfLinks=allLinks.size();
	//System.out.println("No of links: "+ "number of links");
	for(int i=0;i<=allLinks.size()-1;i++) {
		//WebElement oneAddress=allLinks.get(i);
		String text=allLinks.get(i).getText();
		System.out.println(text);
	}

}
}