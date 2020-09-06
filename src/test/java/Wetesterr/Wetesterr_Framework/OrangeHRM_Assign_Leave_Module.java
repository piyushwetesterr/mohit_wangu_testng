package Wetesterr.Wetesterr_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.OrangeHRMApp.Orange_HRM_Assign_Leave_Page;
import com.Pages.OrangeHRMApp.Orange_HRM_Landing_Page;
import com.Pages.OrangeHRMApp.Orange_HRM_Login_Page;

import baseClass.BaseClass;
import custom_Methods.UtilityMethods;

public class OrangeHRM_Assign_Leave_Module extends BaseClass {

	public WebDriver driver;

	UtilityMethods utils = new UtilityMethods();

	String url = properties.getProperty("url");
	
	String username_config = properties.getProperty("username");

	String password_config = properties.getProperty("password");
	
	Orange_HRM_Login_Page orange_hrm_login_page;
	
	Orange_HRM_Landing_Page orange_hrm_landing;
	
	Orange_HRM_Assign_Leave_Page orange_hrm_assign_leave;

	@BeforeClass
	public void launch_Browser() {

		driver = browserSetUp();
		
		utils.openURL(url);

		orange_hrm_login_page = new Orange_HRM_Login_Page(driver);
		
		orange_hrm_landing = new Orange_HRM_Landing_Page(driver);
		
		orange_hrm_assign_leave = new Orange_HRM_Assign_Leave_Page(driver);
	}

	@Test
	public void Assign_Leaves() throws InterruptedException {

		orange_hrm_login_page.enterUserName(username_config);

		orange_hrm_login_page.enterPassword(password_config);

		orange_hrm_login_page.clickSubmit();

		Thread.sleep(5000);

		//orange_hrm_landing.assignLeavesClick();

//		orange_hrm_assign_leave.enterEmployeeName("b");
//
//		orange_hrm_assign_leave.selectLeaveType("3");
//
//		orange_hrm_assign_leave.selectLeaveFromDate("10");
//
//		orange_hrm_assign_leave.selectLeaveToDate("15");
//
//		orange_hrm_assign_leave.addCommentForLeave("test");
//		
//		orange_hrm_assign_leave.clickAssignButton();
//		
//		Thread.sleep(5000);

	}

	@Test
	public void Navigate_to_Leaves_Section() throws InterruptedException {

		//Orange_HRM_Landing_Page orange_hrm_landing = new Orange_HRM_Landing_Page(driver);

		Thread.sleep(5000);

		orange_hrm_landing.assignLeavesClick();

	}

	@Test
	public void Assign_Leave() throws InterruptedException {

//		Orange_HRM_Assign_Leave_Page orange_hrm_assign_leave = new Orange_HRM_Assign_Leave_Page(driver);
//
//		Thread.sleep(10000);

		orange_hrm_assign_leave.enterEmployeeName("b");

		orange_hrm_assign_leave.selectLeaveType("3");

		orange_hrm_assign_leave.selectLeaveFromDate("10");

		orange_hrm_assign_leave.selectLeaveToDate("15");

		orange_hrm_assign_leave.addCommentForLeave("test");

	}

	@AfterClass
	public void closeBrowser() {
		tearDown();

	}

}
