package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import static common.CommonActions.*;
import constants.Attribute;

public class ForgetUserIdandPassword {
WebDriver driver;
public ForgetUserIdandPassword(WebDriver driver) {
	
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(linkText = "Forgot ID/Password?")
	WebElement forgetIDPassword;
	@FindBy(id="skip-to-h1")
	WebElement header1;
	
	@FindBy(id ="introText")
	WebElement subHeader;
	
	@FindBy(xpath="//label[@for='acctNumber']")
	WebElement requiredCardOrAccountNumberMessage;
	
	@FindBy(id="acctNumber")
	WebElement accountNumber;
	
	@FindBy (xpath="//div[text()='Enter the last 6 digits of your Card or account number (only numbers).']")
	WebElement erroraccountNumberErrorMessage;
	
	@FindBy(id= "ssNumber") //input[@name='ssNumberField']")
	WebElement ssnNumber ;
	
	@FindBy(xpath ="//label[@for='ssNumber']")
	WebElement  requiredSSNOrTaxIdNumberMessage;
	
	
	@FindBy(id="ssNumber_errorMessage")
	WebElement ssnErrormessage;
	@FindBy(id="verifyCustomerAccount")
	WebElement continueUserID;
	

	public void directingToForgetUserIDandPassword() {
		pause(4);
		buttonEnabled(forgetIDPassword);
		verifyTextOfTheWebElement(forgetIDPassword, "Forgot ID/Password?");
		clickElement(forgetIDPassword);
		currentUrl(driver);
		verifyTitle(driver, "Bank of America | Online Banking | Forgot User ID & Password");
		validationOfHeader(header1, "Forgot User ID & Password");
		validationOfSubHeader(subHeader, "Please provide some basic information and we'll help with your User ID or Password.");
		
		//Please provide some basic information and we'll help with your User ID or Password.
	}
	public void accountNumberSSnNumberContinue( ) {
		
		verifyLengthOfTheFieldContent(accountNumber, "6");
		inputTextThenClickTab(accountNumber, "12345a");
		pause(3);
		verifyErrorMsgUnderTheField(erroraccountNumberErrorMessage, "Enter the last 6 digits of your Card or account number (only numbers).");
		inputTextThenClickTab(ssnNumber, "8000");
		pause(3);
		verifyErrorMsgUnderTheField(ssnErrormessage, "Enter exactly 9 numbers in the format ###-##-####.");
		pause(3);
		clickElement(continueUserID);
		pause(3);
		//verifyErrorMsgUnderTheField(ssnErrormessage, "Enter exactly 9 numbers in the format ###-##-####.");
		//pause(3);
		
		
	}
	
	
	
}
	


