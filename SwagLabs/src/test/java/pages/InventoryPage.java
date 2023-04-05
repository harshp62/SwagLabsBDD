package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ReusableUtils;

public class InventoryPage extends ReusableUtils {

    public WebDriver driver;

    public InventoryPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(xpath = "//div[@class='header_secondary_container']/span[text()='Products']")
    WebElement productsTab;

    @FindBy(id = "about_sidebar_link")
    WebElement aboutLink;

    @FindBy(xpath = "//a[contains (@id, 'title_link')]/div")
    List<WebElement> productNames;

    @FindBy(css = "select.product_sort_container")
    WebElement filterOption;

    @FindBy(css = "div[class='pricebar'] div")
    List<WebElement> prices;

    @FindBy(css = "button.btn")
    List<WebElement> addToCart;

    @FindBy(css = "a.shopping_cart_link")
    WebElement goToCartButton;

    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartAddedBadge;

    @FindBy(css = "button.btn")
    List<WebElement> removeFromCart;

    @FindBy(linkText="Twitter")
    WebElement twitterLinkBtn;

    @FindBy(linkText="Facebook")
    WebElement facebookLinkBtn;

    @FindBy(linkText="LinkedIn")
    WebElement linkedinLinkBtn;




    public boolean isInvMenuDisplayed() {

        return menuButton.isDisplayed();
    }

    public boolean isproductsTabDisplayed() {

        return productsTab.isDisplayed();
    }

    public void openMenuTab() {

        jsClick(menuButton);
    }

    public void clickAboutLink() {

        jsClick(aboutLink);
    }

    public boolean isAboutLinkDisplayed() {

        return aboutLink.isDisplayed();

    }

    public List<String> getProductNames(List<WebElement> productNames) {

        List<String> prodNames;

        prodNames = productNames.stream().map(n -> n.getText()).collect(Collectors.toList());

        return prodNames;
    }

    public List<String> getProductNames() {

        List<String> prodNames = new ArrayList<>();

        prodNames = productNames.stream().map(n -> n.getText()).collect(Collectors.toList());


        return prodNames;
    }

    public void filterResults(String value) {

        dropdownSelect(filterOption, value);
    }

    public boolean checkAlphaFilter(String filter) {


        List<String> prodList = getProductNames(productNames);

        List<Character> firstLetter;
        List<Character> fLetter;
        List<Character> oList;

        fLetter = prodList.stream().map(n -> n.charAt(0)).collect(Collectors.toList());
        oList = fLetter.stream().sorted().collect(Collectors.toList());


        if (filter.equalsIgnoreCase("za")) {
            oList = fLetter.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        } else {

            oList = fLetter.stream().sorted().collect(Collectors.toList());
        }

        System.out.println("Original List: " + fLetter);
        System.out.println("Ordered List: " + oList);

        return fLetter.equals(oList);

    }

    public boolean checkPriceFIlter(String filter) {

        List<String> prodList = getProductNames(prices);

        List<Double> priceIntValue;

        priceIntValue = prodList.stream().map(n -> Double.parseDouble(n.substring(1))).collect(Collectors.toList());

        List<Double> orderedList = new ArrayList<>(priceIntValue);

        if (filter.equalsIgnoreCase("hilo")) {


            Collections.sort(orderedList, Collections.reverseOrder());
        } else {

            orderedList = priceIntValue.stream().sorted().collect(Collectors.toList());

        }

        System.out.println("price_orderedList: " + orderedList);
        System.out.println("price_priceIntValue: " + priceIntValue);

        return priceIntValue.equals(orderedList);
    }

    public void addProductToCart(String productname) throws Exception {

        List<WebElement> addToCartList = waitForElements(By.cssSelector("button.btn"));
        for (WebElement element : addToCartList) {
            System.out.println(productname);
            System.out.println(element.getAttribute("id").split("cart")[1].replace('-', ' ').trim());
        }
        boolean found = false;
        for (int i = 0; i < addToCartList.size(); i++) {

            if (addToCartList.get(i).getAttribute("id").split("cart")[1].replace('-', ' ').trim()
                    .equalsIgnoreCase(productname)) {

                addToCartList.get(i).click();
                found = true;
                break;
            }

        }
        if (found == false) {

            throw new Exception("No such product found");
        }


    }

    public void removeProductFromCart(String productname) throws Exception {

//		List<WebElement> addToCartList = waitForElements(By.cssSelector("button.btn"));
        boolean found = false;
        for (int i = 0; i < removeFromCart.size(); i++) {
            System.out.println(removeFromCart.get(i).getAttribute("id"));

            if (removeFromCart.get(i).getAttribute("id").contains("remove")) {

                if (removeFromCart.get(i).getAttribute("id").split("remove")[1].replace('-', ' ').trim()
                        .equalsIgnoreCase(productname)) {

                    removeFromCart.get(i).click();
                    found = true;
                    break;
                }
            }

        }
        if (found == false) {

            throw new Exception("No such product found");
        }


    }

    public void goToCart() {

        goToCartButton.click();

    }

    public boolean isShoppingCartEmpty() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean elementAbsent = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));
        return elementAbsent;
    }

    public void goToLink(String linkname) throws Exception {

        if (linkname.equalsIgnoreCase("facebook")) {

            jsClick(facebookLinkBtn);

            Thread.sleep(3000);
            switchWindows("Sauce Labs | Facebook");

//            String login = driver.findElement(By.xpath("(//span[text()='Log In'])[2]")).getText();
//            System.out.println(login);
//
//            System.out.println(driver.getCurrentUrl());
//            Thread.sleep(5000);

        } else if (linkname.equalsIgnoreCase("linkedin")) {

            jsClick(linkedinLinkBtn);
            Thread.sleep(3000);
            switchWindows("Sauce Labs | LinkedIn");

        } else if (linkname.equalsIgnoreCase("twitter")) {

            jsClick(twitterLinkBtn);
            Thread.sleep(3000);
            switchWindows("Sauce Labs (@saucelabs) / Twitter");

        } else throw new Exception("No such link present");

    }

}
