package steps;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.en.Then;
import pages.ExternalLinksPage;

import static org.testng.Assert.assertTrue;

public class ExternalLinksSteps {

    TestContextSetup testContextSetup;
    ExternalLinksPage externalLinksPage;

    public ExternalLinksSteps(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        this.externalLinksPage = testContextSetup.pageObjectManager.getExternalLinksPage();
    }


    @Then("^the user is navigated to the (.+) link page$")
    public void theUserIsNavigatedToTheLinkLinkPage(String linkname) throws Exception {

        if(linkname.equalsIgnoreCase("facebook")) {

            assertTrue(externalLinksPage.getUrl().equalsIgnoreCase("https://www.facebook.com/saucelabs"));
        } else if (linkname.equalsIgnoreCase("linkedin")) {


            assertTrue(externalLinksPage.getUrl().contains("linkedin"));

        } else if (linkname.equalsIgnoreCase("twitter")) {

            assertTrue(externalLinksPage.getUrl().equalsIgnoreCase("https://twitter.com/saucelabs"));

        }

        else throw new Exception("link not found");
    }
}
