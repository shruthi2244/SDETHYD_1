package com.mmt.practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonDropDownTest {
	public static void main(String args[]) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	 List<WebElement> allDropDown = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));
	for(int i=0;i<=allDropDown.size()-1;i++)
	{
		String title = allDropDown.get(i).getText();
		System.out.println(title);
	}
	}

}
