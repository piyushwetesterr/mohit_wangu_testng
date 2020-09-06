package com.Pages.OrangeHRMApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class Orange_HRM_Login_Page extends BaseClass {

	public WebDriver driver;

	public Orange_HRM_Login_Page(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	// Locating username field
	@FindBy(id = "txtUsername")
	WebElement login_page_username_field;

	// Locating password field
	@FindBy(id = "txtPassword")
	WebElement login_page_password_field;

	// Locating submit button
	@FindBy(id = "btnLogin")
	WebElement login_page_submit_button;

	public void enterUserName(String username) {
		login_page_username_field.sendKeys(username);

	}

	public void enterPassword(String password) {

		login_page_password_field.sendKeys(password);
	}

	public void clickSubmit() {

		login_page_submit_button.click();

	}

}
