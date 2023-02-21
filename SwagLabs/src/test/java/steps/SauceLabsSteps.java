package steps;

import static org.testng.Assert.assertEquals;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SauceLabsPage;

public class SauceLabsSteps {

	
	public TestContextSetup testContextSetup;
	public SauceLabsPage sauceLabsPage;
	
	
	
	public SauceLabsSteps(TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
		this.sauceLabsPage= testContextSetup.pageObjectManager.getSauceLabsPage();
	}
	
	  @Then("^user is redirected to the \"([^\"]*)\" url$")
	    public void user_is_redirected_to_the_something_url(String strArg1) throws Throwable {
	        
		  assertEquals(sauceLabsPage.getPageUrl(), strArg1);
		  
		  
	    }
	  
	  @And("^the page title is \"([^\"]*)\"$")
	    public void the_page_title_is_something(String strArg1) throws Throwable {
	      
		  assertEquals(sauceLabsPage.getPageTitle(), strArg1);
		  
	    }

	
}
