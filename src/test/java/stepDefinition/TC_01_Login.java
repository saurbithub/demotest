package stepDefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import Cucumber.Automation.CBase;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class TC_01_Login extends CBase {
	public WebDriver driver;

	@Given("^Get logged into twitter$")
	public void get_logged_into_twitter() throws Throwable {

		driver = initializeDriver();

		driver.get("https://twitter.com/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("techiewalkie");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@7083" + Keys.ENTER);
		
		driver.close();

	}

}
