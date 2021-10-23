package com.mmt.practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest {
	@Test
	public void test1() {
		String url = System.getProperty("url");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
	}

}
