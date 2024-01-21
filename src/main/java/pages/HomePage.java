package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static common.CommonActions.*;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@itemprop='logo']")
	WebElement logo;

	@FindBy(id = "NAV_ABOUT_US")
	WebElement aboutUs;

	@FindBy(id = "NAV_WEALTH_MANAGEMENT")
	WebElement wealthManagement;

	@FindBy(xpath = "//h2[@class='cnx-regular headline ']")
	WebElement personalHeader;
	@FindBy(xpath = "//input[@name='onlineId1']")
	WebElement userId;

	@FindBy(xpath = "//input[@name='passcode1']")
	WebElement password;
	@FindBy(xpath = "//input[@name='saveOnlineId']")
	WebElement saveTheID;
	@FindBy(xpath = "//span[text()='Log In']")
	WebElement logInButton;

	@FindBy(xpath = "//h1[text()='Log In to Online Banking']")
	WebElement logInErrorMessage;

	public void homePageValidation() {
		pause(3);
		elementDisplayed(logo);
		currentUrl(driver);
		verifyTitle(driver, "Bank of America - Banking, Credit Cards, Loans and Merrill Investing");
	}

	public void aboutUsValidation() {
		pause(3);
		clickElement(aboutUs);
		// switchToChildWindow(driver, aboutUs);
		pause(3);
		currentUrl(driver);

	}

	public void wealthManagementValidatoion() {
		pause(3);
		// clickElement(wealthManagement);
		switchToChildWindow(driver, wealthManagement);
		pause(3);
		currentUrl(driver);
	}

	public void logInValidation() {
		inputText(userId, "Dilshad");
		clearTextFromTheField(userId);
		inputText(userId, "Zannat");
		inputText(password, "12345");
		pause(3);
		clickElement(saveTheID);
		pause(3);
		verifyTextOfTheWebElement(logInButton, "Log In");
		clickElement(logInButton);
		pause(3);
		currentUrl(driver);
		validationOfHeader(logInErrorMessage, "Log In to Online Banking");
	}

}