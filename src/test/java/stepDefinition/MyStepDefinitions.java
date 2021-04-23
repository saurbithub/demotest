package stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Cucumber.Automation.CBase;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Homepage;

public class MyStepDefinitions extends CBase {

	Homepage hp;
	public WebDriver driver;

	@Given("^User is on Greencart Landing page$")
	public void User_is_on_Greencart_Landing_page() throws IOException {

		driver = initializeDriver();

		// driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.get(prop.getProperty("url"));

	}

	@When("^User searched for \"([^\"]*)\" Vegetable$")
	public void User_searched_for_something_Vegetable(String strArg1) throws InterruptedException {
hp=new Homepage(driver);
hp.getSearch().sendKeys(strArg1);
	//	driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys(strArg1);
		Thread.sleep(3000);

	}

	@Then("^\"([^\"]*)\" results are displayed$")
	public void something_results_are_displayed(String strArg1) {

		Assert.assertTrue(
				driver.findElement(By.xpath("//h4[normalize-space()='Cucumber - 1 Kg']")).getText().contains(strArg1));

	}

	// =================================Scenario-2=============================================================

	// And Added items to cart
	// And User proceeded to checkout page

	@And("^Added items to cart$")
	public void Added_items_to_cart() {

		driver.findElement(By.cssSelector("a[class='increment']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='ADD TO CART']")).click();

	}

	@And("^User proceeded to checkout page$")
	public void User_proceeded_to_checkout_page() {

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();

	}

	@Then("^verify selected \"([^\"]*)\" items are displayed in checkout page$")
	public void verify_selected_something_items_are_displayed_in_checkout_page(String strArg1) {

		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='product-name']")).getText().contains(strArg1));

	}

}
