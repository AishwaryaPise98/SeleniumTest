package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseClass;
import utilities.ReadXLData;

public class MyFirstTestFW extends BaseClass {

	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testdata")
	public static void LoginTest(String username, String password) throws InterruptedException {
		
		
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();// move to locator - properties
		System.out.println("Login Successful");
		//Can be moved to a method called login	
		driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("password_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
		Thread.sleep(8000);

	}

}
