package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass {

	@Test(enabled = false)

	public void homePageLandingTest() {
		homePage.homePageValidation();
	}

	@Test(enabled = false)

	public void aboutUsValidationTest() {
		homePage.aboutUsValidation();

	}

	@Test(enabled = false)

	public void wealthManagementValidationTest() {
		homePage.wealthManagementValidatoion();
	}

}