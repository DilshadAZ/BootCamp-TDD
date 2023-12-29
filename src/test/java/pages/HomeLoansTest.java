package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class HomeLoansTest extends BaseClass {
	@Test(enabled = true)
	public void homeLoanValidationTest() {
		homeLoans.homeLoanValidation();
	}
}
