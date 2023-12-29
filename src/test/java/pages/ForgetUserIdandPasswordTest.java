package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class ForgetUserIdandPasswordTest extends BaseClass {
	@Test
	
	public void accountNumberSSnNumberContinue( ) {
		
		forgetUserIdandPassword.directingToForgetUserIDandPassword();
		forgetUserIdandPassword.accountNumberSSnNumberContinue();
	}

}
