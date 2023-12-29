package pages;

import static common.CommonActions.clickElement;
import static common.CommonActions.currentUrl;
import static common.CommonActions.pause;
import static common.CommonActions.validationOfHeader;
import static common.CommonActions.validationOfSubHeader;
import static common.CommonActions.verifyTextOfTheWebElement;
import static common.CommonActions.elementDisplayed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLoans {
	WebDriver driver;

	public HomeLoans(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Home Loans']//parent::a[@id='navHomeLoans']")
	WebElement homeLoans;

	@FindBy(xpath = "//span[text()='Explore home loans']")
	WebElement exploreHomeLoans;
	@FindBy(linkText = "Mortgage")
	WebElement mortage;

	@FindBy(xpath = "//h1[text()='Home Mortgage Loans']")
	WebElement homeMortageLoansHeader;

	@FindBy(xpath = "//h2[text()='The perfect home starts with the right mortgage']")
	WebElement homeMortageLoansSubHeader;
	@FindBy(id = "applyNow")
	WebElement applyNow;

	@FindBy(id = "dmaFlowButton")
	WebElement iWantToBuyHome;
	@FindBy(id = "propertyContractYes")
	WebElement iAmReadyToApply;
	
	@FindBy (xpath="//div[@class='form-headline']")
	WebElement logInSaveTime;
	@FindBy(id = "isBofaCustomer-yes")
	WebElement yes;

	@FindBy(id = "isBofaCustomer-no")
	WebElement no;
	@FindBy(xpath="//input[@value='No']")
	WebElement continueButton;
	@FindBy(xpath="//span[text()='Your information']")
	WebElement yourInformation;

	public void homeLoanValidation() {

		//pause(3);
		// verifyTextOfTheWebElement(homeLoans, "Home Loans");
		// verifyTitle(driver, "Home Loans");
		clickElement(homeLoans);
		verifyTextOfTheWebElement(exploreHomeLoans, "Explore home loans");
		clickElement(mortage);
		currentUrl(driver);
		//
		//pause(3);
		//validationOfHeader(homeMortageLoansHeader, "Home Mortgage Loans");
		//validationOfSubHeader(homeMortageLoansSubHeader, "The perfect home starts with the right mortgage");
		//pause(3);
		//elementDisplayed(applyNow);
		clickElement(applyNow);
		
		System.out.println(applyNow.getAttribute("text"));
		//verifyTextOfTheWebElement(applyNow, "Apply now");
		System.out.println("********************");
		// currentUrl(driver);
		//pause(3);
		clickElement(iWantToBuyHome);
		elementDisplayed(iWantToBuyHome);
		//verifyTextOfTheWebElement(iWantToBuyHome, null);
		pause(3);
		currentUrl(driver);
		
		clickElement(iAmReadyToApply);
		pause(3);
		clickElement(no);
	
		clickElement(continueButton);
		currentUrl(driver);
		pause(3);
		//validationOfSubHeader(yourInformation, "Your information");
		elementDisplayed(yourInformation);
		
		

	}

}