package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.ReusableUtils;

public class CheckoutComplete extends ReusableUtils {

    WebDriver driver;

    public CheckoutComplete (WebDriver driver) {

        super(driver);
        this.driver = driver;

    }

    @FindBy(css="h2")
    WebElement message;

    public boolean isTitleDisplayed() {

        return driver.getPageSource().contains("Checkout: Complete!");

    }

    public boolean verifyMessage(String message) {

        return waitForElement(By.cssSelector("h2")).getText().equalsIgnoreCase(message);
    }
}
