package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class TestHooks {
	
	public WebDriver driver;

	public TestContextSetup testContextSetup;
	
	public TestHooks (TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void afterScenario() throws IOException {
		
		//testContextSetup.driverProvider.getDriver().quit();
		testContextSetup.pageObjectManager.driver.quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		driver = testContextSetup.pageObjectManager.driver;
		if(scenario.isFailed())
		{
		//screenshot
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}
	
}
}

