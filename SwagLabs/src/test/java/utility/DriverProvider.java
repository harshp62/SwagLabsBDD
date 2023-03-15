package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverProvider {
	
	public  Properties pr;
	public  FileReader fr;
	public WebDriver driver;
	
	public WebDriver getDriver() throws IOException {
		
		if(driver==null) {
			
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			pr = new Properties();
			pr.load(fr);
			
			
		}
		
		if(pr.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.get(pr.getProperty("url"));
		}

		else if (pr.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(pr.getProperty("url"));
		
	}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;

}
	
}
