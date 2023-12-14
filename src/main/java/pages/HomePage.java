package pages;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath ="//input[@name='onlineId1']")
	WebElement userId;
	
	@FindBy(xpath ="//input[@name='passcode1']")
	WebElement password;
	@FindBy(xpath ="//input[@name='saveOnlineId']")
	WebElement saveTheID;
	@FindBy(xpath ="//span[text()='Log In']")
	WebElement logInButton;

	public void inputUserIdAndPasswordthenClickLoginButton() {
		inputText(userId, "Dilshad");
		inputText(password, "12345");
		pause(3);
		clickElement(saveTheID);
		pause(3);
		clickElement(logInButton);
		pause(3);
		
		
		
	
	
	
	
	
	
	
	
}}