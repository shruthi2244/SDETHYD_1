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

import com.vtiger.generic.FileUtility;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebUtility;

public class TC_001_createOrgwith_DDTest {

	@Test
	public void createorgwithDD() throws Throwable {
//		Random random=new Random();
//		int randomnumber=random.nextInt(1000);
//		System.out.println(randomnumber);
		JavaUtility ju=new JavaUtility();
		ju.generateRandomNo();
		Random random=new Random();
		int randomnumber=random.nextInt(1000);
		System.out.println(randomnumber);
		String orgname="QSPHYD_5"+randomnumber;
		System.out.println(orgname);
		WebDriver driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("./common.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		FileUtility  fu= new FileUtility();
		if
		(fu.readDatafromPropfile("browser").equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(fu.readDatafromPropfile("browser").equalsIgnoreCase("firefox"))
		{
		driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		//driver.get("http://localhost:8888/");
		
		//driver.get(prop.getProperty("url"));
		driver.get(fu.readDatafromPropfile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("user_name")).sendKeys(fu.readDatafromPropfile("username"));
		//driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("user_password")).sendKeys(fu.readDatafromPropfile("password"));		
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement industrydropdown=driver.findElement(By.name("industry"));
		
//		Select industrydd=new Select(industrydropdown);
//		
//		industrydd.selectByVisibleText("Construction");
		WebUtility wu=new WebUtility();
		wu.selectelementfromDropdown(industrydropdown, "Construction");
		WebElement ratingdropdown=driver.findElement(By.name("rating"));
//		Select ratingdd=new Select(ratingdropdown);
//		ratingdd.selectByValue("Market Failed");
		wu.selectelementfromDropdown(ratingdropdown, "Market Failed");
		WebElement typedropdown=driver.findElement(By.name("accounttype"));
//		Select typedd=new Select(ratingdropdown);
//		typedd.selectByIndex(4);
		wu.selectelementfromDropdown(typedropdown, 4);
		driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		WebElement searchdropdown=driver.findElement(By.id("bas_searchfield"));
//	Select searchdd=new Select(searchdropdown);
//	searchdd.selectByVisibleText("Organization Name");
		wu.selectelementfromDropdown(searchdropdown, "Organization Name");
	driver.findElement(By.name("submit")).click();
	WebElement OrgName=driver.findElement(By.xpath("//a[@title=\"Organizations\" and text()='QSPHYD_5103']"));
	    if(OrgName.isDisplayed()) {
	Assert.assertTrue(true);

}
}
}