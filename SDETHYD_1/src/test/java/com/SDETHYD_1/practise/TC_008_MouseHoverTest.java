package com.SDETHYD_1.practise;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_008_MouseHoverTest {
	@Test
	public void createorgwithDD() throws Throwable {
//		Random random=new Random();
//		int randomnumber=random.nextInt(1000);
//		System.out.println(randomnumber);
		
		Random random=new Random();
		int randomnumber=random.nextInt(1000);
		System.out.println(randomnumber);
		String orgname="shruth"+randomnumber;
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
//		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
//		WebElement opencal=driver.findElement(By.xpath("//img[@title=\"Open Calculator...\"]"));
//		
//		Actions ac=new  Actions(driver);
//		ac.moveToElement(opencal).build().perform();
//		System.out.println(opencal.getAttribute("title"));
		WebElement searchbox=driver.findElement(By.xpath("//input[@value=\"Search...\"]"));
		searchbox.sendKeys("shruthi");
		System.out.println(searchbox.getAttribute("value"));
		//
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		co.addArguments("start-maximized");
		//)

}
}





