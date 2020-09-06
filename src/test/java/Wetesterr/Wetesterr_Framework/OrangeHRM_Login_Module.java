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
import junit.framework.Assert;

public class OrangeHRM_Login_Module extends BaseClass {

	public WebDriver driver;

	UtilityMethods utils = new UtilityMethods();

	String url = properties.getProperty("url");
	
	Orange_HRM_Login_Page orange_hrm_login_page;
	
	String username_config = properties.getProperty("username");

	String password_config = properties.getProperty("password");
	
	String landing_page = properties.getProperty("dashboard_url");

	String current_url;
	
	@BeforeClass
	public void launch_Browser() {
		
		driver = browserSetUp();
		
		utils.openURL(url);
		
		orange_hrm_login_page = new Orange_HRM_Login_Page(driver);
		
	}

	@Test
	public void Login_to_Application() {
		
		Assert.assertTrue(orange_hrm_login_page.getLogin_page_username_field().isDisplayed());

		Assert.assertTrue(orange_hrm_login_page.getLogin_page_username_field().isEnabled());
		
		orange_hrm_login_page.enterUserName(username_config);
		
		Assert.assertTrue(orange_hrm_login_page.getLogin_page_password_field().isDisplayed());

		Assert.assertTrue(orange_hrm_login_page.getLogin_page_password_field().isEnabled());

		orange_hrm_login_page.enterPassword(password_config);
		
		Assert.assertTrue(orange_hrm_login_page.getLogin_page_submit_button().isDisplayed());

		Assert.assertTrue(orange_hrm_login_page.getLogin_page_submit_button().isEnabled());

		orange_hrm_login_page.clickSubmit();
		
		current_url = driver.getCurrentUrl();
		
		Assert.assertEquals(landing_page, current_url);

	}

	@AfterClass
	public void closeBrowser() {
		tearDown();

	}

}
