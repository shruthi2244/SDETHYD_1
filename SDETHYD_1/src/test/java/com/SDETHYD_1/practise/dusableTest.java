package com.SDETHYD_1.practise;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class dusableTest {
	public static void main(String args[]) {

	
//		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.hdfcbank.com/");
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
	//	co.addArguments("start-maximized");
	}

}
