package com.SDETHYD_1.practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_006_CreateCricketTeamTest {
	public static void main(String args[]) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> headers=driver.findElements(By.xpath("//table/thead/tr/th"));
		for(int i=0;i<headers.size(); i++) {
			System.out.println(headers.get(i).getText()+" ");
		}
		List<WebElement> teams=driver.findElements(By.xpath("//table/tbody/tr"));
		for(int i=0;i<teams.size(); i++) {
			System.out.println(teams.get(i).getText()+" ");
			System.out.println();
		}
		System.out.println(driver.findElement(By.xpath("(//tbody/td/tr)[last()]")));//here iam getting no such element exception
	
		}
}
