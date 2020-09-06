package com.Pages.OrangeHRMApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class Orange_HRM_Landing_Page extends BaseClass {

	public WebDriver driver;

	public Orange_HRM_Landing_Page(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	// Locating assign leave link
	@FindBy(xpath = "//td[1]//div[1]//a[1]//img[1]")
	WebElement assign_leaves_link;

	public void assignLeavesClick() {
		assign_leaves_link.click();

	}

}
