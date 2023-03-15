package steps;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutOne;

import static org.testng.Assert.assertTrue;

public class CheckoutOneSteps {

    TestContextSetup testContextSetup;
    CheckoutOne checkoutOne;

    public CheckoutOneSteps (TestContextSetup testContextSetup) {

        this.testContextSetup=testContextSetup;
        checkoutOne = testContextSetup.pageObjectManager.getCheckoutOne();
    }

    @Then("user is navigated to the checkout one page")
    public void userIsNavigatedToTheCheckoutOnePage() {

        assertTrue(checkoutOne.isTitleDisplayed());
    }


    @When("user enters his information as {string}, {string}, {string} and continues")
    public void user_enters_his_information_as_and_continues(String firstname, String lastname, String postalcode) {

        checkoutOne.enterCheckoutDetails(firstname, lastname,postalcode);
    }


    @Then("^(.+) error is displayed$")
    public void errorIsDisplayed(String arg0) {

        assertTrue(checkoutOne.isErrorDisplayed(arg0));
    }


    @When("user enters his information as {string}, {string}, {string} and continues next")
    public void userEntersHisInformationAsAndContinuesNext(String arg0, String arg1, String arg2) {

        checkoutOne.enterCheckoutDetails(arg0,arg1,arg2);
    }
}
