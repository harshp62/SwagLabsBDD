package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ReusableUtils;

public class CheckoutOne extends ReusableUtils {

    public CheckoutOne (WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="first-name")
    WebElement inputFNameBox;

    @FindBy(id="last-name")
    WebElement inputLNameBox;

    @FindBy(id="postal-code")
    WebElement inputPostalCodeBox;


    @FindBy(id="continue")
    WebElement continueButtn;


    public boolean isTitleDisplayed() {

        return driver.getPageSource().contains("Checkout: Your Information");
    }

    public void enterCheckoutDetails (String firstName, String lastName, String postalCode) {

        inputFNameBox.sendKeys(firstName);
        inputLNameBox.sendKeys(lastName);
        inputPostalCodeBox.sendKeys(postalCode);
//        moveToElementAndClick(continueButtn);
        continueButtn.click();
    }


}
