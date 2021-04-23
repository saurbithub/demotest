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
public class TC_07_ProfilePictureUpload extends CBase {
	public WebDriver driver;

	@Then("^profile pic upload$")
	public void profile_pic_upload() throws Throwable {
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

		driver.quit();
		/*
		 * AUTO IT is used to upload profile picture
		 * 
		 * ControlFocus("Open","","Edit1") ControlSetText("Open","",
		 * "Edit1","C:\Users\saura\Desktop\Saurabh Documents\Bloom Documents\PROFILE PIC.jpg"
		 * ) ControlClick("Open","","Button1")
		 */

		WebElement uploadPic = driver.findElement(By.xpath(
				"//div[@aria-label='Add avatar photo']//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-b88u0q r-1777fci r-rjixqe r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0']//*[local-name()='svg']"));
		uploadPic.click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("C:\\Users\\saura\\Desktop\\FileUpload.exe");
		WebElement applybtn = driver.findElement(By.xpath("//span[contains(text(),'Apply')]"));
		applybtn.click();
		Thread.sleep(1000);
		WebElement savebtn = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
		savebtn.click();
		Thread.sleep(1000);
driver.close();

	}

}
