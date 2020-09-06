package Wetesterr.Wetesterr_Framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.OrangeHRMApp.Orange_HRM_Login_Page;

import baseClass.BaseClass;
import custom_Methods.UtilityMethods;

public class OrangeHRM_Login_Module extends BaseClass {

	public WebDriver driver;

	UtilityMethods utils = new UtilityMethods();

	String url = properties.getProperty("url");

	@BeforeClass
	public void launch_Browser() {
		driver = browserSetUp();
		
	}

	@Test
	public void Login_to_Application() {
		
		utils.openURL(url);

		Orange_HRM_Login_Page orange_hrm_login_page = new Orange_HRM_Login_Page(driver);

		String username_config = properties.getProperty("username");

		String password_config = properties.getProperty("password");

		orange_hrm_login_page.enterUserName(username_config);

		orange_hrm_login_page.enterPassword(password_config);

		orange_hrm_login_page.clickSubmit();

	}

	@AfterClass
	public void closeBrowser() {
		tearDown();

	}

}
