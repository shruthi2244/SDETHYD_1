package com.federo.GenericLib;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeClass;


public class BaseTest implements IAutoConsts {
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		FileLib flib=new FileLib();
		String browserName=flib.readPropertyData(PROP_PATH, "browser");
		if(browserName.equals("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Enter proper browser name");
		}
		driver.manage().window().maximize();
		String appURL=flib.readPropertyData(PROP_PATH, "url");
		driver.get(appURL);
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		String expectedLoginTitle=flib.readPropertyData(PROP_PATH, "loginTitle");
		wlib.verify(wlib.getPageTitle(), expectedLoginTitle, "Loginpage");
	}
	
	
	public void closeBrowser()
	{
		driver.close();
	}
}
