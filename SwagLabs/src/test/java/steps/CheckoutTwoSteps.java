package steps;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pages.CheckoutTwo;

import static org.testng.Assert.assertTrue;

public class CheckoutTwoSteps {

    TestContextSetup testContextSetup;
    CheckoutTwo checkoutTwo;

    public CheckoutTwoSteps (TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        checkoutTwo = testContextSetup.pageObjectManager.getCheckoutTwo();
    }


    @Then("user is navigated to checkout part two page")
    public void userIsNavigatedToCheckoutPartTwoPage() {
        assertTrue(checkoutTwo.isTitleDisplayed());
    }

    @And("{string} name is displayed")
    public void nameIsDisplayed(String arg0) {

        assertTrue(checkoutTwo.isProductDisplayed(arg0));
    }


    @And("the total price of the product after tax is {string}")
    public void theTotalPriceOfTheProductAfterTaxIs(String arg0) {

        assertTrue(checkoutTwo.isTotalCorrectAfterTax(arg0));
    }

    @When("user clicks on finish button")
    public void userClicksOnFinishButton() {

        checkoutTwo.finish();
    }


}
