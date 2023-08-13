package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
 
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc =  new Properties();
	public static FileReader fr,fr1;

	
	@BeforeMethod
	public void setUp() throws IOException {
		
		if(driver==null) {
			fr = new FileReader( System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
		    fr1 = new FileReader( System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
			//System.out.println(prop.getProperty("browser"));
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();// move to base file as it is common
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		    driver = new ChromeDriver(options); // move to base as it is common
			driver.get(prop.getProperty("url")); // move to properties
			System.out.println(driver);


		}
		
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();// move to base file as it is common
		    driver = new FirefoxDriver(); // move to base as it is common
			driver.get(prop.getProperty("url")); // move to properties
			
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Teardown Successful");
	}
}
