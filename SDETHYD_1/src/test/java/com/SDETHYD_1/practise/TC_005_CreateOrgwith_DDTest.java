package com.SDETHYD_1.practise;

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

public class TC_005_CreateOrgwith_DDTest {
	@Test
	public void createorgwithDD() throws Throwable {
//		Random random=new Random();
//		int randomnumber=random.nextInt(1000);
//		System.out.println(randomnumber);
		
		Random random=new Random();
		int randomnumber=random.nextInt(1000);
		System.out.println(randomnumber);
		String orgname="shruthi1"+randomnumber;
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
		driver.findElement(By.id("25")).click();
		driver.findElement(By.xpath("(//input[@value=\"Mass Edit\"])[2]")).click();
		driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		WebElement assigneddropdown=driver.findElement(By.name("assigned_group_id"));
		Select assigneddd=new Select(assigneddropdown);
		assigneddd.selectByIndex(2);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		WebElement OrgName=driver.findElement(By.xpath("//a[@title=\"Organizations\" and text()='shruthi1']"));
	    if(OrgName.isDisplayed()) {
	Assert.assertTrue(true);
	    }
	}
		

}
