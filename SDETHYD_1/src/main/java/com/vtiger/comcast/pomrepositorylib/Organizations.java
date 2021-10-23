package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	
	public Organizations(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Calendar.gif\"]") private WebElement createorgimg;
	public WebElement getCreateorgimg() {
		return createorgimg;
	}
	public void setCreateorgimg(WebElement createorgimg) {
		this.createorgimg = createorgimg;
	}
	public void orgimg() {
		createorgimg.click();
	}

}
