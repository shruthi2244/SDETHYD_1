package com.mmt.practise;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.generic.BaseClass;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebUtility;

public class TC_000gruops_test extends BaseClass{
	    
		@Test(groups="smoke")
		public void createOrgwith_DDTest() throws Throwable {

			FileInputStream fis=new FileInputStream("./common.properties");
			Properties prop=new Properties();
			prop.load(fis);
			//FileUtility  fu= new FileUtility();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
			driver.switchTo().window(parentwindow);
			Thread.sleep(2000);
		}
	@Test(groups="regression")
	public void createorgwithDD() throws Throwable {
		JavaUtility ju=new JavaUtility();
		ju.generateRandomNo();
		Random random=new Random();
		int randomnumber=random.nextInt(1000);
		System.out.println(randomnumber);
		String orgname="QSPHYD_5"+randomnumber;
		System.out.println(orgname);
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Home he=new Home(driver);
		he.org();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement industrydropdown=driver.findElement(By.name("industry"));
		
		WebUtility wu=new WebUtility();
		wu.selectelementfromDropdown(industrydropdown, "Construction");
		WebElement ratingdropdown=driver.findElement(By.name("rating"));

		wu.selectelementfromDropdown(ratingdropdown, "Market Failed");
		WebElement typedropdown=driver.findElement(By.name("accounttype"));

		wu.selectElementfromDropdown(typedropdown, 4);
		driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();
		Thread.sleep(2000);
		he.org();
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		WebElement searchdropdown=driver.findElement(By.id("bas_searchfield"));
		wu.selectElementfromDropdown(searchdropdown, 1);
	    driver.findElement(By.name("submit")).click();
	    WebElement OrgName=driver.findElement(By.xpath("//a[@title=\"Organizations\" and text()='QSPHYD_5103']"));
	    if(OrgName.isDisplayed()) {
	    Assert.assertTrue(true);	
	    Reporter.log("created contacts", false);
}
}

}
