package com.SDETHYD_1.practise;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TC_008_WebTableTest {
	@Test
	public void createorgwithDD() throws Throwable {
		WebDriver driver = new ChromeDriver();
		Random random=new Random();
		int randomnumber=random.nextInt(1000);
		System.out.println(randomnumber);
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
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
	
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		List<WebElement> orgtable=driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[10]/td[3]/a"));
		String orgnametodelete="badala";
				for (int i = 2; i < orgtable.size(); i++)
			{
					String s1=orgtable.get(i).getText();
					if(s1.equalsIgnoreCase(orgnametodelete))
					{
						driver.findElement(By.xpath("//a[text()='"+orgnametodelete+"']/../../td[1]/input")).click();
						break;
					}					
			}
				driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
			
				List<WebElement> checkbox=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));

				int count =0;
				System.out.println(checkbox.size());
				for (int i = 3; i <= checkbox.size()+1; i++)
				{
					driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+i+"]/td[1]/input")).click();
					count++;
				}
				System.out.println(count);
	//})
	
}
}











