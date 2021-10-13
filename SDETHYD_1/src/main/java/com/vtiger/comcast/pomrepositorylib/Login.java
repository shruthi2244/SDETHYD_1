package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name") private WebElement usernameEdt;
	@FindBy(name="user_password") private WebElement userpasswordEdt;
	@FindBy(id="submitButton") private WebElement loginBtn;
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public void setUsernameEdt(WebElement usernameEdt) {
		this.usernameEdt = usernameEdt;
	}
	
	public WebElement getUserpasswordEdt() {
		return userpasswordEdt;
	}
	public void setUserpasswordEdt(WebElement userpasswordEdt) {
		this.userpasswordEdt = userpasswordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}
public void loginToApp(String userName, String password) {
	usernameEdt.sendKeys(userName);
	userpasswordEdt.sendKeys(password);
	loginBtn.click();
}
	
	
	
}



