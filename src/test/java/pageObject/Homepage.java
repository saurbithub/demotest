package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	
	public WebDriver driver;



	public Homepage(WebDriver driver) {
		
		
		this.driver=driver;
	}
	
	By search= By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	
	
	
	public WebElement getSearch() {
		
		
	return	driver.findElement(search);
		
		
	}

}
