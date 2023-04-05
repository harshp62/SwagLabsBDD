package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.ReusableUtils;

public class ExternalLinksPage extends ReusableUtils {

    WebDriver driver;

    public ExternalLinksPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl() {

        return driver.getCurrentUrl();
    }
}
