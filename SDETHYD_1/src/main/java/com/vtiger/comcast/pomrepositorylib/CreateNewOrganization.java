package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
	public  CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname") private WebElement orgnamedt;
    @FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement savebtn;
    public void createOrg(String orgName) {
    	orgnamedt.sendKeys(orgName);
    	savebtn.click();
    }
}
