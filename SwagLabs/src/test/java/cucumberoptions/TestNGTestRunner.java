package cucumberoptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features\\Checkout.feature",
glue = "steps",
dryRun=false,
monochrome=true,
plugin = {"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	
}
