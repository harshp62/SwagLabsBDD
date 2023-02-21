package dependencyinjection;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import utility.DriverProvider;
import utility.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public DriverProvider driverProvider;
	public PageObjectManager pageObjectManager;
	
	public TestContextSetup() throws IOException {
		
		driverProvider = new DriverProvider();
		pageObjectManager = new PageObjectManager(driverProvider.getDriver());
	}

}
