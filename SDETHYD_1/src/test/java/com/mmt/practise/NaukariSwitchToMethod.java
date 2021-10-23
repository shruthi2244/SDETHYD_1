package com.mmt.practise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukariSwitchToMethod {
	public static void main(String args[]) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		Set<String> window = driver.getWindowHandles();
		Iterator<String> win = window.iterator();
		while(win.hasNext()) {
		String childwindow1   =	win.next();
		String currentitle=driver.switchTo().window(childwindow1).getTitle();
		if(currentitle.equalsIgnoreCase("fujitsu")) {
			driver.switchTo().window(childwindow1).close();
		}
		}
	}

}
