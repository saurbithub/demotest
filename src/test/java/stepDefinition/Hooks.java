package stepDefinition;

import Cucumber.Automation.CBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CBase {
	@Before("@SeleniumTest")
	public void beforevalidation() {
		
		System.out.println("beforevalidation");
		
	}
	
@After("@SeleniumTest")
public void aftervalidation() {
		
	System.out.println("aftervalidation");
	driver.close();
		
	}

}
