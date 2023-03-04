package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ReusableUtils;

public class CheckoutTwo extends ReusableUtils {


    public WebDriver driver;

    public CheckoutTwo (WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css=".inventory_item_name")
    WebElement inventoryItem;

    @FindBy(css=".inventory_item_price")
    WebElement inventoryItemPrice;

    @FindBy(id="finish")
    WebElement finishButtn;


    @FindBy(id="cancel")
    WebElement cancelButtn;

    @FindBy (css=".summary_total_label")
    WebElement grandTotal;


    public boolean isTitleDisplayed() {

        return driver.getPageSource().contains("Checkout: Overview");
    }

    public void finish(){
        moveToElementAndClick(finishButtn);

    }

    public boolean isProductDisplayed(String productName) {

        return inventoryItem.getText().equalsIgnoreCase(productName);
    }

    public boolean isTotalCorrectAfterTax(String price) {

//        Double price = Double.parseDouble(inventoryItemPrice.getText().substring(1));
//
//        Double afterTax = price* 1.08;
//        System.out.println(grandTotal.getText());
        String total = grandTotal.getText().split("\\$")[1];
        System.out.println(total);

        return total.equalsIgnoreCase(price);

    }
}
