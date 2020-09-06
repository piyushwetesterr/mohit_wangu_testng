package com.Pages.OrangeHRMApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;

public class Orange_HRM_Assign_Leave_Page extends BaseClass {

	public WebDriver driver;

//	public Orange_HRM_Assign_Leave_Page(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}

	public Orange_HRM_Assign_Leave_Page(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	// Locating employeename field
	@FindBy(xpath = "//label[@for='assignleave_txtEmployee']/following::input[1]")
	WebElement assign_leave_page_employee_name_field;

	// Locating leavetype field
	@FindBy(id = "assignleave_txtLeaveType")
	WebElement assign_leave_page_leave_type_field;

	// Locating leavefromdate field
	@FindBy(id = "assignleave_txtFromDate")
	WebElement assign_leave_from_date;

	// Locating leavetodate field
	@FindBy(id = "assignleave_txtToDate")
	WebElement assign_leave_to_date;

	// Locating comment field
	@FindBy(id = "assignleave_txtComment")
	WebElement assign_leave_comment_box;

	// Locating Assign button
	@FindBy(id = "assignBtn")
	WebElement assign_button;

	public void enterEmployeeName(String employeename) throws InterruptedException {

		Thread.sleep(3000);
		
		assign_leave_page_employee_name_field.click();
		assign_leave_page_employee_name_field.sendKeys(employeename);
		assign_leave_page_employee_name_field.sendKeys(Keys.ENTER);

	}

	public void selectLeaveType(String inputvalue) {

		Select leaveSelect = new Select(assign_leave_page_leave_type_field);

		leaveSelect.selectByValue(inputvalue);
	}

	public void selectLeaveFromDate(String leave_from_date) {

		assign_leave_from_date.click();

		List<WebElement> LeaveFromDates = driver.findElements(By.cssSelector("a[class='ui-state-default']"));

		for (int i = 0; i < LeaveFromDates.size(); i++) {

			if (LeaveFromDates.get(i).getText().equals(leave_from_date)) {
				LeaveFromDates.get(i).click();

			}

		}

	}

	public void selectLeaveToDate(String leave_to_date) {

		assign_leave_to_date.click();

		List<WebElement> LeaveToDates = driver.findElements(By.cssSelector("a[class='ui-state-default']"));

		for (int i = 0; i < LeaveToDates.size(); i++) {

			if (LeaveToDates.get(i).getText().equals(leave_to_date)) {
				LeaveToDates.get(i).click();

			}

		}

	}

	public void addCommentForLeave(String comment_for_leave) {

		assign_leave_comment_box.sendKeys(comment_for_leave);

	}

	public void clickAssignButton() {
		assign_button.click();

	}

}
