package com.mmt.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class createOrgwith_DDTest {

	@Test
	public void createorgwithDD(WebElement indropdown) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("12345");
	
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys("QSPHYD_5");
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
		
		driver.findElement(By.name("search_text")).sendKeys("QSPHYD_5");

	Select indd=new Select(indropdown);
	indd.selectByValue("indd");
	WebElement OrganizationName=driver.findElement(By.xpath("//a[@title='Organizations']"));
	driver.findElement(By.name("submit")).click();
    if(OrganizationName.isDisplayed()) {
Assert.assertTrue(true);
	}
}
}