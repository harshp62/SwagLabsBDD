package steps;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.annotations.Test;
import pages.CheckoutComplete;

import static org.testng.Assert.assertTrue;

public class CheckoutCompleteSteps {

    TestContextSetup testContextSetup;
    CheckoutComplete checkoutComplete;

    public CheckoutCompleteSteps (TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        checkoutComplete = testContextSetup.pageObjectManager.getCheckoutComplete();
    }

    @Then("user is navigated to checkout complete page")
    public void userIsNavigatedToCheckoutCompletePage() {

        assertTrue(checkoutComplete.isTitleDisplayed());
    }

    @And("Success message {string} is displayed")
    public void successMessageIsDisplayed(String arg0) {

        assertTrue(checkoutComplete.verifyMessage(arg0));
    }
}
