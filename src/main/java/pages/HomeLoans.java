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
	@FindBy(id = "phoneNumber_errorMessage")
	WebElement phoneErrorMessage;

	@FindBy(id = "phoneType")
	WebElement selectPhoneType;
//	@FindBy(xpath = "//option[text()='Mobile']")
//	WebElement mobile;
	@FindBy(id = "email")
	WebElement eMail;

	@FindBy(id = "locationField")
	WebElement locationFieldElement;
	@FindBy(id = "streetNumber")
	WebElement streetNumber;
	@FindBy(id = "locationField_errorMessage")
	WebElement locationErrorMessage;

	@FindBy(id = "addressLineOne")
	WebElement addressLine1;
	@FindBy(id = "city")
	WebElement city;
	@FindBy(id = "selectState")
	WebElement selectState;
	@FindBy(xpath = "//option[text()='Florida']//parent::select[@id='selectState']")
	WebElement florida;
	@FindBy(id = "zipcode")
	WebElement zipCode;

	@FindBy(id = "differentPrimaryAndMailingAddress")
	WebElement checkBoxOfMailingAddess;
	@FindBy(xpath = "//input[@id='USCitizen']")
	WebElement usCitizenCheckBox;
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
	@FindBy (id="countryOfResidence")
	WebElement residenceCountry;

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
		// pause(3);
		elementDisplayed(applyNoow);
		clickElement(applyNoow);
		// verifyTextOfTheWebElement(applyNoow, "Apply now");

		currentUrl(driver);
		// pause(3);
		elementDisplayed(iWantToBuyHome);
		clickElement(iWantToBuyHome);

		// verifyTextOfTheWebElement(iWantToBuyHome, null);
		// pause(3);
		currentUrl(driver);

		clickElement(iAmReadyToApply);
		pause(3);
		clickElement(no);
		// waitThenClick(driver,no);
		// pause(3);
		clickElement(continueButton);
		currentUrl(driver);

		// validationOfSubHeader(yourInformation, "Your information");
		elementDisplayed(yourInformation);
		// pause(3);
	}

	public void firstNameValidation() {
		// pause(2);
		verifyLengthOfTheFieldContent(firstNamee, "32");
		// inputTextThenClickTab(firstNamee, "-/-/");
		// verifyErrorMsgUnderTheField(firstNameErrorMessage, "Please enter your first
		// name using only letters, apostrophes or hyphens.");

		clearTextFromTheField(firstNamee);
		// pause(2);
		inputTextThenClickTab(firstNamee, "Dilshad");
		// pause(2);
		inputTextThenClickTab(middleNamee, "DAZ");
		// pause(3);
		inputTextThenClickTab(lastNamee, "Zannat");
		// pause(3);
		clickElement(select);
		clickElement(selectSr);
		// pause(2);
		// clickElement(phoneNumberr);
		inputText(phoneNumberr, "743090789");
		// verifyErrorMsgUnderTheField(phoneErrorMessage, "Please enter a valid phone
		// number.");
//		clickElement(selectPhoneType);
//		clickElement(mobile);
		selectByVal(selectPhoneType, "CellularPhone");
		// pause(3);
		inputTextThenClickTab(eMail, "shshsh@gmail.com");
		// pause(2);
		inputText(locationFieldElement, "45 Southwest 9th Street");
		keyPress("down", locationFieldElement);
		keyPress("enter", locationFieldElement);
		pause(3);
		
		selectByVal(residenceCountry, "US");

		inputText(ssnSelect, "989121234");

		inputTextThenClickTab(dateOfBirth, "09132000");

		selectByVal(yearInSchool, "12");
		selectByVal(maritalStatus, "Married");

		clickElement(dependenciesNo);
		pause(3);
		clickElement(leaderOfficerCheckBox);
		clickElement(consentCheckBox);
		clickElement(saveAndContinue);
		System.out.println("*************************");
	}

}