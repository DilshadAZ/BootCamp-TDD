package pages;

import static common.CommonActions.*;
import static common.CommonWaits.*;

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
	WebElement applyNoow;

	@FindBy(id = "dmaFlowButton")
	WebElement iWantToBuyHome;
	@FindBy(id = "propertyContractYes")
	WebElement iAmReadyToApply;

	@FindBy(xpath = "//div[@class='form-headline']")
	WebElement logInSaveTime;
	@FindBy(id = "isBofaCustomer-yes")
	WebElement yes;

	@FindBy(id = "isBofaCustomer-no")
	WebElement no;
	@FindBy(id = "signInContinueButton")
	WebElement continueButton;
	@FindBy(xpath = "//span[text()='Your information']")
	WebElement yourInformation;

	@FindBy(xpath = "//input[@class='first-name-field spa-input-text']")
	WebElement firstNamee;

	@FindBy(id = "firstName_errorMessage")
	WebElement firstNameErrorMessage;

	@FindBy(id = "middleName")
	WebElement middleNamee;

	@FindBy(id = "lastName")
	WebElement lastNamee;
	@FindBy(id = "suffix")
	WebElement select;
	@FindBy(xpath = "//option[text()='Sr']")
	WebElement selectSr;
	@FindBy(id = "phoneNumber")
	WebElement phoneNumberr;

	@FindBy(id = "phoneType")
	WebElement selectPhoneType;
	@FindBy(xpath = "//option[text()='Mobile']")
	WebElement mobile;
	@FindBy(id = "email")
	WebElement eMail;
	
	
	@FindBy(id = "locationField")
	WebElement locationFieldElement;
	@FindBy(id = "streetNumber")
	WebElement streetNumber;
	
	@FindBy(id="addressLineOne")
	WebElement addressLine1;
	@FindBy(id="city")
	WebElement city;
	@FindBy(id="selectState")
	WebElement selectState;
	@FindBy(xpath="//option[text()='Florida']//parent::select[@id='selectState']")
	WebElement florida;
	@FindBy(id="zipcode")
	WebElement zipCode;
	
	
	
	
	@FindBy(id = "differentPrimaryAndMailingAddress")
	WebElement checkBoxOfMailingAddess;
	@FindBy(id = "notUSCitizen")
	WebElement notUSCitizenCheckBox;
	@FindBy(id = "residencyType")
	WebElement residenceType;

	@FindBy(xpath = "option[text()='Visa']")
	WebElement visaOption;

	@FindBy(id = "residencyDocument")
	WebElement residencyDocumentSelect;

	@FindBy(xpath = "//option[text()='H-1B Visa']")
	WebElement h1BVisa;
	@FindBy(id = "countryOfCitizenship")
	WebElement countryOfCitizenship;

	@FindBy(xpath = "//option[text()='Bangladesh']//parent::select[@id='countryOfCitizenship']")
	WebElement Bangladesh;
	@FindBy(id = "ssn")
	WebElement ssnSelect;
	@FindBy(id = "dob")
	WebElement dateOfBirth;
	@FindBy(id = "yearsInSchool")
	WebElement yearInSchool;
	@FindBy(xpath = "//option[text()='18']")
	WebElement select18;
	@FindBy(id = "maritalStatus")
	WebElement maritalStatus;
	@FindBy(xpath = "//option[text()='Married']")
	WebElement married;
	@FindBy(id = "haveDependentsNo")
	WebElement dependenciesNo;
	@FindBy(id = "isMLOExistNo")
	WebElement leaderOfficerCheckBox;
	@FindBy(id = "consentToContact")
	WebElement consentCheckBox;
	@FindBy(id = "personalInformationContinueButton")
	WebElement saveAndContinue;

	public void homeLoanValidation() {

		// pause(3);
		// verifyTextOfTheWebElement(homeLoans, "Home Loans");
		// verifyTitle(driver, "Home Loans");
		clickElement(homeLoans);
		verifyTextOfTheWebElement(exploreHomeLoans, "Explore home loans");
		clickElement(mortage);
		currentUrl(driver);
		//
		// pause(3);
		// validationOfHeader(homeMortageLoansHeader, "Home Mortgage Loans");
		// validationOfSubHeader(homeMortageLoansSubHeader, "The perfect home starts
		// with the right mortgage");
		pause(3);
		elementDisplayed(applyNoow);
		clickElement(applyNoow);
		// verifyTextOfTheWebElement(applyNoow, "Apply now");

		currentUrl(driver);
		pause(3);
		elementDisplayed(iWantToBuyHome);
		clickElement(iWantToBuyHome);

		// verifyTextOfTheWebElement(iWantToBuyHome, null);
		pause(3);
		currentUrl(driver);

		clickElement(iAmReadyToApply);
		pause(3);
		clickElement(no);
		pause(3);
		clickElement(continueButton);
		currentUrl(driver);

		// validationOfSubHeader(yourInformation, "Your information");
		elementDisplayed(yourInformation);
		pause(3);
	}

	public void firstNameValidation() {
		pause(2);
		verifyLengthOfTheFieldContent(firstNamee, "32");
		// inputTextThenClickTab(firstNamee, "-/-/");
		// verifyErrorMsgUnderTheField(firstNameErrorMessage, "Please enter your first
		// name using only letters, apostrophes or hyphens.");

		clearTextFromTheField(firstNamee);
		pause(2);
		inputTextThenClickTab(firstNamee, "Dilshad");
		pause(2);
		inputTextThenClickTab(middleNamee, "DAZ");
		pause(3);
		inputTextThenClickTab(lastNamee, "Zannat");
		pause(3);
		clickElement(select);
		clickElement(selectSr);
		pause(2);
		clickElement(phoneNumberr);
		clickElement(selectPhoneType);
		clickElement(mobile);
		pause(3);
		inputTextThenClickTab(eMail, "shshsh@gmail.com");
		pause(2);
		inputText(locationFieldElement, "45 Southwest 9th Street");
		pause(2);
		inputTextThenClickTab(streetNumber, "45");
		pause(2);
		inputText(addressLine1, "Southwest 9th Street");
		pause(2);
		inputTextThenClickTab(city, "Miami");
		pause(2);
		clickElement(selectState);
		clickElement(florida);
		pause(2);
		inputText(zipCode, "33130");
		pause(2);
		//waitThenClick(driver, checkBoxOfMailingAddess);
		//pause(2);
		waitThenClick(driver, notUSCitizenCheckBox);
		pause(2);
		clickElement(countryOfCitizenship);
		clickElement(Bangladesh);
		pause(2);
		inputText(ssnSelect, "989-12-1234");
		pause(2);
		inputTextThenClickTab(dateOfBirth, "09/13/2000");
		pause(2);
		clickElement(yearInSchool);
		clickElement(select18);
		pause(2);
		clickElement(maritalStatus);
		clickElement(married);
		pause(2);
		waitThenClick(driver, dependenciesNo);
		pause(2);
		waitThenClick(driver, leaderOfficerCheckBox);
		pause(2);
		waitThenClick(driver, consentCheckBox);
		pause(2);
		clickElement(saveAndContinue);
		pause(2);
		
		
		
	}

}