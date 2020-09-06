package baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties properties;

	public BaseClass() {

		properties = new Properties();
		try {
			FileInputStream fisConfig = new FileInputStream("src//test//resources//Properties//config.property");
			try {
				properties.load(fisConfig);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public WebDriver browserSetUp() {

		String browser = properties.getProperty("browser");

		//String url = properties.getProperty("url");

		if (browser.equalsIgnoreCase("chrome"))

			WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.get(url);

		return driver;

	}

	public static void tearDown() {
		driver.quit();

	}

}
