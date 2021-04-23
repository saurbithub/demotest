package stepDefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Cucumber.Automation.CBase;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class TC_06_FetchTheTweets extends CBase {
	public WebDriver driver;

	@Then("^Fetch all the tweets$")
	public void fetch_all_the_tweets() throws Throwable {
		driver = initializeDriver();

		driver.get("https://twitter.com/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("techiewalkie");
		WebElement btnsubmit = driver.findElement(By.xpath("//input[@type='password']"));
		btnsubmit.sendKeys("Test@7083");
		btnsubmit.submit();
		Thread.sleep(10000);

		String MyCompleteText = driver
				.findElement(
						By.xpath("//span[contains(text(),\"What is Lorem Ipsum Lorem Ipsum is simply dummy te\")]"))
				.getText();

		String[] mytext = MyCompleteText.split(
				"What is Lorem Ipsum Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum has been the industry's standard dummy text ever since the 1500s when an unknown printer took a galley of type and scrambled it to make");
		System.out.println("I am text after  Account: " + mytext[1]);
		driver.close();



	}
}
