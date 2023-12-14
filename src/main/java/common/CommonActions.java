package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import constants.Attribute;
import reports.Loggers;

public class CommonActions {
	WebDriver driver;
	CommonWaits waits;
	
	public CommonActions (WebDriver driver, CommonWaits waits ) {
		this.driver = driver;
		this.waits = waits;
	}
	public static void verifyTitle(WebDriver driver, String expectedTitle) {
		try {
			Loggers.logTheTest("Actual Title is : " + driver.getTitle() + " ---> And Expected Title is :" + expectedTitle);
			Assert.assertEquals(driver.getTitle(), expectedTitle);
		} catch (NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest("Driver is not initiated properly Or Home Page Title doesn't match");
			Assert.fail();
		}
	}
	
	public static void inputText(WebElement element, String input) {
		try {
			element.sendKeys(input);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		
		}}
	
	public static void clickElement(WebElement element) {
		try {
			element.click();
			Loggers.logTheTest(element + "<---------> has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() ); // getMessage() Returns the detail message string of this throwable.
			Assert.fail();
		}
	}
		
		public static void pause(long sec) {
			try {
				Thread.sleep(sec * 1000);
				Loggers.logTheTest("Sleeping ... zZz " + sec);
			}catch (InterruptedException e) {
				e.printStackTrace();
				Loggers.logTheTest("Sleep interrupted");
			
			}}
		
		public static boolean buttonEnabled(WebElement element) {
			try {
				element.isEnabled();
				Loggers.logTheTest(element + "<---------> is Enable");
			} catch (NoSuchElementException | NullPointerException e) {
				e.printStackTrace();
				Loggers.logTheTest(element + "<----------> is Disable\n" + e.getMessage() ); // getMessage() Returns the detail message string of this throwable.
				Assert.fail();
			}
			return true;
			
		}
		public static void verifyTextOfTheWebElement(WebElement element, String expected) {
			String actual = element.getText();
			Loggers.logTheTest(element + " ---> Actual text : " + actual + ". Expected text : " + expected);
			Assert.assertEquals(actual, expected, "Text In the WebElement doesn't match");
		}
		
		public static String getAttributeValue(WebElement element, Attribute attribute) {
			return element.getAttribute(attribute.toString());
		}
		public static String currentUrl(WebDriver driver) {
			Loggers.logTheTest("Current URL is : " + driver.getCurrentUrl());
			return driver.getCurrentUrl();
			
		}
		public static void verifyAttribute02(WebElement element, String expectedErrorMsg, Attribute attribute) {
			String actual = getAttributeValue(element, attribute);
			// element.getAttribute(attribute.toString());
			Loggers.logTheTest(element + " ---> Actual Error Message Under the field is : " + actual + ". And Expected was: " + expectedErrorMsg);
			Assert.assertEquals(actual, expectedErrorMsg);
		}
			public static void verifyErrorMsgUnderTheField(WebElement element, String expectedErrorMsg) {
				verifyAttribute02(element, expectedErrorMsg, Attribute.INNER_TEXT); //"innerHTML"
			}		
			
}
