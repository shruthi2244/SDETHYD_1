package com.mmt.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class createcontactswindowtest {
	@Test
	public void createOrgwith_DDTest() throws Throwable {
			WebDriver driver=new ChromeDriver();
			FileInputStream fis=new FileInputStream("./common.properties");
			Properties prop=new Properties();
			prop.load(fis);
			if
			(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
			{
			driver=new FirefoxDriver();
			}
			else {
				driver=new ChromeDriver();
			}
			//driver.get("http://localhost:8888/");
			
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
		
			driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			driver.findElement(By.name("firstname")).sendKeys("shru");
			driver.findElement(By.name("lastname")).sendKeys("badal");
			driver.findElement(By.xpath("(//img[@alt=\"Select\"])[1]")).click();
			Set<String> windows=driver.getWindowHandles();
			Iterator<String> window=windows.iterator();
			String parentwindow=window.next();
			String childwindow=window.next();
			driver.switchTo().window(childwindow);
			driver.findElement(By.id("search_txt")).sendKeys("shru");
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[@id=\"1\" and text()='shruthi']")).click();
			
}
}
