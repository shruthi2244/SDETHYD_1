package com.mmt.practise;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_002_createcontactswith_DDTest {
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
			WebElement firstnamedropdown=driver.findElement(By.name("salutationtype"));
			Select fndd=new Select(firstnamedropdown);
			fndd.selectByVisibleText("Mrs.");
			driver.findElement(By.name("firstname")).sendKeys("sh");
			driver.findElement(By.name("lastname")).sendKeys("bada");
			driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.name("search_text")).sendKeys("sh");
			WebElement indropdown=driver.findElement(By.name("search_field"));
			Select indd=new Select(indropdown);
			indd.selectByVisibleText("First Name");
			driver.findElement(By.name("submit")).click();
			WebElement OrgName=driver.findElement(By.xpath("//a[@title=\"Contacts\" and text()='sh']"));
		    if(OrgName.isDisplayed()) {
		Assert.assertTrue(true);

	}
	}

}

