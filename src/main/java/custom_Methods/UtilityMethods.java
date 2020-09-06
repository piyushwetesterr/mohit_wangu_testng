package custom_Methods;

//import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;

public class UtilityMethods extends BaseClass {

	BaseClass baseclass;

	public void openURL(String URL) {
		
		driver.get(URL);

	}

}
