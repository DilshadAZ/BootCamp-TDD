package common;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import constants.Attribute;
import reports.Loggers;

public class CommonActions {
	WebDriver driver;
	CommonWaits waits;

	public CommonActions(WebDriver driver, CommonWaits waits) {
		this.driver = driver;
		this.waits = waits;
	}

	public static boolean elementDisplayed(WebElement element) {
		try {
			boolean flag = element.isDisplayed();
			Loggers.logTheTest(element + "<---------> is Displayed, " + flag);
			Assert.assertTrue(true, "Element is not displayed .....");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Displayed\n" + e.getMessage());
		}
		return true;
	}

	public static void verifyTitle(WebDriver driver, String expectedTitle) {
		try {
			Loggers.logTheTest(
					"Actual Title is : " + driver.getTitle() + " ---> And Expected Title is :" + expectedTitle);
			Assert.assertEquals(driver.getTitle(), expectedTitle);
		} catch (NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest("Driver is not initiated properly Or Home Page Title doesn't match");
			Assert.fail();
		}
	}

	public static void verifyAttribute01(WebElement element, String expected, Attribute attribute) {
		String actual = getAttributeValue(element, attribute);
		// element.getAttribute(attribute.toString());
		Loggers.logTheTest(element + " ---> We can Enter : " + actual
				+ " Character in the field which was similar with the Expected as: " + expected);
		Assert.assertEquals(actual, expected);

	}

	public static void verifyLengthOfTheFieldContent(WebElement element, String expected) {
		verifyAttribute01(element, expected, Attribute.MAX_LENGTH);
	}

	public static void inputText(WebElement element, String input) {
		try {
			element.sendKeys(input);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();

		}
	}

	public static void inputTextThenClickTab(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.TAB);
			Loggers.logTheTest(
					input + " <-----> has been put into <-----> " + element + " and then clicked by Tab Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	public static String validationOfHeader(WebElement element, String expectedHeader) {
		Assert.assertEquals(element.getText(), expectedHeader);
		Loggers.logTheTest(
				element + " ---> Actual Header : " + element.getText() + ". Expected Header : " + expectedHeader);
		return null;

	}

	public static String validationOfSubHeader(WebElement element, String expectedSubHeader) {
		Assert.assertEquals(element.getText(), expectedSubHeader);
		Loggers.logTheTest(element + " ---> Actual Sub Header : " + element.getText() + ". Expected SubHeader : "
				+ expectedSubHeader);
		return null;
	}

	public static boolean elementEnabled(WebElement element) {
		try {
			boolean flag = element.isEnabled();
			Loggers.logTheTest(element + "<---------> is Enabled, " + flag);
			Assert.assertTrue(true, "Element is Disabled ....."); // TODO Nasir: Need to make sure
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is Disabled\n" + e.getMessage()); // getMessage() Returns the
																							// detail message string of
																							// this throwable.
			Assert.fail();
		}
		return true;
	}

	public static void clickElement(WebElement element) {
		try {
			element.click();
			Loggers.logTheTest(element + "<---------> has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage()); // getMessage() Returns
																								// the detail message
																								// string of this
																								// throwable.
			Assert.fail();
		}
	}

	public static void pause(long sec) {
		try {
			Thread.sleep(sec * 1000);
			Loggers.logTheTest("Sleeping ... zZz " + sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Loggers.logTheTest("Sleep interrupted");

		}
	}

	public static boolean buttonEnabled(WebElement element) {
		try {
			element.isEnabled();
			Loggers.logTheTest(element + "<---------> is Enable");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is Disable\n" + e.getMessage()); // getMessage() Returns the
																						// detail message string of this
																						// throwable.
			Assert.fail();
		}
		return true;

	}

	public static void verifyTextOfTheWebElement(WebElement element, String expected) {
		String actual = element.getText();
		System.out.println(actual);
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
		Loggers.logTheTest(element + " ---> Actual Error Message Under the field is : " + actual
				+ ". And Expected was: " + expectedErrorMsg);
		Assert.assertEquals(actual, expectedErrorMsg);
	}

	public static void verifyErrorMsgUnderTheField(WebElement element, String expectedErrorMsg) {
		verifyAttribute02(element, expectedErrorMsg, Attribute.INNER_TEXT); // "innerHTML"
	}

	public static void switchToChildWindow(WebDriver driver, WebElement element) {
		try {
			clickElement(element);
			Set<String> allWindowHandles = driver.getWindowHandles();
			Loggers.logTheTest("Total Windows Opened: " + allWindowHandles.size());
			String parent = (String) allWindowHandles.toArray()[0];
			String child = (String) allWindowHandles.toArray()[1];
			driver.switchTo().window(child);
			Loggers.logTheTest(" The Window moved to --> " + child);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	public static void clearTextFromTheField(WebElement element) {
		try {
			element.clear();
			Loggers.logTheTest("The Text from the " + element + " ---> is cleared");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}

	}
	
	
	public static void selectByVal(WebElement element, String value) {
		Select select = new Select(element); 
		select.selectByValue(value);
	}
	
	public static void keyPress(String key, WebElement element) {
		
		if(key.equals("tab")) element.sendKeys(Keys.TAB);
		if(key.equals("left")) element.sendKeys(Keys.ARROW_LEFT);
		if(key.equals("right")) element.sendKeys(Keys.ARROW_RIGHT);
		if(key.equals("up")) element.sendKeys(Keys.ARROW_UP);
		if(key.equals("down")) element.sendKeys(Keys.ARROW_DOWN);
		if(key.equals("enter")) element.sendKeys(Keys.RETURN);
	}
}