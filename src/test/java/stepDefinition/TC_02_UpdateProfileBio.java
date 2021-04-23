package stepDefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Cucumber.Automation.CBase;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class TC_02_UpdateProfileBio extends CBase {
	public WebDriver driver;

	@Given("^update the profile$")
	public void update_the_profile() throws Throwable {
		driver = initializeDriver();

		driver.get("https://twitter.com/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("techiewalkie");
		WebElement btnsubmit = driver.findElement(By.xpath("//input[@type='password']"));
		btnsubmit.sendKeys("Test@7083");
		btnsubmit.submit();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[contains(text(),'Edit profile')]")).click();
		Thread.sleep(5000);

		WebElement updatebio = driver.findElement(By.xpath("//textarea[@name='description']"));
		updatebio.click();
		updatebio.clear();
		updatebio.sendKeys("Selenium Automation Tester");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		
		driver.close();

	}

}
