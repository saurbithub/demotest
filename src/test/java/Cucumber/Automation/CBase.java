package Cucumber.Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CBase {
	public static WebDriver driver;
	public  static Properties prop;
	
	public  static WebDriver initializeDriver() throws IOException {
		
		 prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"src\\test\\java\\Cucumber\\Automation\\data.properties");

			prop.load(fis);

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		 driver = new ChromeDriver();

		
		return driver;
		
	}

}
