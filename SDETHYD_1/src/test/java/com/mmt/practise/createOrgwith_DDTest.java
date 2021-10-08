package com.mmt.practise;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class createOrgwith_DDTest {

	@Test
	public void createorgwithDD() throws Throwable {
//		Random random=new Random();
//		int randomnumber=random.nextInt(1000);
//		System.out.println(randomnumber);
		
		Random random=new Random();
		int randomnumber=random.nextInt(1000);
		System.out.println(randomnumber);
		String orgname="QSPHYD_5"+randomnumber;
		System.out.println(orgname);
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
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement industrydropdown=driver.findElement(By.name("industry"));
		Select industrydd=new Select(industrydropdown);
		industrydd.selectByVisibleText("Construction");
		WebElement ratingdropdown=driver.findElement(By.name("rating"));
		Select ratingdd=new Select(ratingdropdown);
		ratingdd.selectByValue("Market Failed");
		WebElement typedropdown=driver.findElement(By.name("accounttype"));
		Select typedd=new Select(ratingdropdown);
		ratingdd.selectByIndex(4);
		driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);

	//Select indd=new Select(indropdown);
	//indd.selectByValue("indd");
//	WebElement OrganizationName=driver.findElement(By.xpath("//a[@title='Organizations']"));
//	driver.findElement(By.name("submit")).click();
//    if(OrganizationName.isDisplayed()) {
//Assert.assertTrue(true);
//	}
}
}