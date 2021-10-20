package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   @FindBy(linkText="Organizations") private WebElement organizationLnk;
   @FindBy(linkText="Products") private WebElement pdtLnk;
   @FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement administratorImg;
   @FindBy(linkText="Sign Out") private WebElement signOutLnk;
public WebDriver getDriver() {
	return driver;
}
public void setDriver(WebDriver driver) {
	this.driver = driver;
}
public WebElement getOrganizationLnk() {
	return organizationLnk;
}
public void setOrganizationLnk(WebElement organizationLnk) {
	this.organizationLnk = organizationLnk;
}
public WebElement getPdtLnk() {
	return pdtLnk;
}
public void setPdtLnk(WebElement pdtLnk) {
	this.pdtLnk = pdtLnk;
}
public WebElement getAdministratorImg() {
	return administratorImg;
}
public void setAdministratorImg(WebElement administratorImg) {
	this.administratorImg = administratorImg;
}
public WebElement getSignOutLnk() {
	return signOutLnk;
}
public void setSignOutLnk(WebElement signOutLnk) {
	this.signOutLnk = signOutLnk;
}  
  
   public void org() {
	   organizationLnk.click();
	
}
public void logout() {
	Actions ac=new Actions(driver);
	   ac.moveToElement(administratorImg).perform();
	   signOutLnk.click();
	
}
}

