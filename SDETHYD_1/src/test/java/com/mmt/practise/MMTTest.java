package com.mmt.practise;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MMTTest {
	public static void main(String args[]) {
		Date dateobj=new Date();
		String currentdate= dateobj.toString();
		System.out.println(currentdate);
		//Tue Oct 05 13:23:09 IST 2021
		String[] arr=currentdate.split(" ");
		String date=arr[2];
		String day=arr[0];
		String month=arr[1];
		String year=arr[5];
		String todaysdate=day+" "+month+" "+date+" "+year;
		System.out.println(todaysdate);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions ac=new Actions(driver);
		ac.moveByOffset(10, 10).click().perform();
		driver.findElement(By.id("fromCity")).sendKeys("BOM");
		driver.findElement(By.xpath("//div[contains(text(), 'BOM')]")).click();
		driver.findElement(By.id("toCity")).sendKeys("GOI");
		driver.findElement(By.xpath("//div[contains(text(), 'GOI')]")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[@aria-label=\"+todaysdate+\"]")).click();
		
	}

}
