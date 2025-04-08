package test;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BasicValidation {

	public static WebDriver driver;
	String appUrl = "https://www.facebook.com";

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get(appUrl);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void ValidateUrl() {
		String expectedResult = "https://www.facebook.com/";
		String actualResult = driver.getCurrentUrl();

		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);

		assertTrue(actualResult.equals(expectedResult), "Mismatch in application URL");

	}

	@Test
	public void welcomeMessageValidation() {
		String expectedResult = "Facebook helps you connect and share with the people in your life.";
		String actualResult = driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();

		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);

		assertTrue(actualResult.equals(expectedResult), "Mismatch in welcome message");

	}

}
