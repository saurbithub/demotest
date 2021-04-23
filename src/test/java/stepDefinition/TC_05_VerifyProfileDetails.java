package stepDefinition;

import org.junit.runner.RunWith;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.junit.Test;
import Cucumber.Automation.CBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class TC_05_VerifyProfileDetails extends CBase {
	public WebDriver driver;

	@Then("^Verify profile details$")
	public void verify_profile_details() throws Throwable {
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

		WebElement updatelocation = driver.findElement(By.xpath("//input[@name='location']"));
		WebElement updateurl = driver.findElement(By.xpath("//input[@name='url']"));

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

		String verifyupdatebio = updatebio.getAttribute("value");
		String verifyupdatelocation = updatelocation.getAttribute("value");
		String verifyupdateurl = updateurl.getAttribute("value");

		// assertSame(verifyupdatebio, "Selenium Automation Tester");
		// assertSame(verifyupdatelocation, "pune");
		// assertSame(verifyupdateurl, "https://www.twitter.com");

		Assert.assertEquals(verifyupdatebio, "Selenium Automation Tester", "Got the bio as expected");

		Assert.assertEquals(verifyupdatelocation, "PUNE", "Got the location as expected");

		Assert.assertEquals(verifyupdateurl, "https://www.twitter.com", "Got the URL as expected");

		driver.close();
	}

}
