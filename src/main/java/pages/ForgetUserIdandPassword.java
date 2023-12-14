package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static common.CommonActions.*;

public class ForgetUserIdandPassword {
WebDriver driver;
public ForgetUserIdandPassword(WebDriver driver) {
	
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(linkText = "Forgot ID/Password?")
	WebElement forgetIDPassword;
	@FindBy(id="acctNumber")
	WebElement accountNumber;
	@FindBy(xpath ="//input[@name='ssNumberField']")
	WebElement ssnNumber;
	@FindBy(id="verifyCustomerAccount")
	WebElement continueUserID;
	

	public void directingToForgetUserIDandPassword() {
		pause(4);
		//buttonEnabled(forgetIDPassword);
		verifyTextOfTheWebElement(forgetIDPassword, "Forgot ID/Password?");
		clickElement(forgetIDPassword);
	}
	public void accountNumberSSnNumberContinue( ) {
		inputText(accountNumber, "123666");
		pause(3);
		inputText(ssnNumber, "2345");
		pause(3);
		clickElement(continueUserID);
		pause(3);
		
		
	}
	
	
	
}
	


