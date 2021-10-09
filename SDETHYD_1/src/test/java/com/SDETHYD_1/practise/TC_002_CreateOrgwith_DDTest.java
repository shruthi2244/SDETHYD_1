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

public class TC_002_CreateOrgwith_DDTest {
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
		driver.findElement(By.id("5")).click();
		driver.findElement(By.xpath("(//input[@value=\"Mailer Export\"])[1]")).click();
		WebElement donotcalldd=driver.findElement(By.name("donotcall"));
		Select dncdd=new Select(donotcalldd);
		dncdd.selectByIndex(1);
		WebElement emailoptoutdd=driver.findElement(By.name("emailoptout"));
		Select emailoutdd=new Select(emailoptoutdd);
		emailoutdd.selectByIndex(2);
		WebElement referencedd=driver.findElement(By.name("reference"));
		Select refdd=new Select(referencedd);
		refdd.selectByIndex(0);
		WebElement notifyownerdd=driver.findElement(By.name("notify_owner"));
		Select notifyodd=new Select(notifyownerdd);
		notifyodd.selectByIndex(1);
		driver.findElement(By.name("export_type")).click();
		driver.findElement(By.name("button")).click();
		driver.findElement(By.xpath("//input[@value=\"  Cancel  \"]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		WebElement searchdropdown=driver.findElement(By.id("bas_searchfield"));
		Select indd=new Select(searchdropdown);
	indd.selectByIndex(1);
	driver.findElement(By.name("submit")).click();
	WebElement OrgName=driver.findElement(By.xpath("//a[@title=\"Organizations\" and text()='shruthi']"));
	    if(OrgName.isDisplayed()) {
	Assert.assertTrue(true);
}
}
}