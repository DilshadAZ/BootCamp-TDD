package baseUtil;

import static utils.IConstant.BROWSER;
import static utils.IConstant.CHROME;
import static utils.IConstant.EXPLICITLY_WAIT;
import static utils.IConstant.FIREFOX;
import static utils.IConstant.IMPLICITLY_WAIT;
import static utils.IConstant.PAGELOAD_WAIT;
import static utils.IConstant.URL;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import common.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ForgetUserIdandPassword;
import pages.HomePage;
import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.Configuration;

public class BaseClass {
	public WebDriver driver;
	public HomePage homePage;
	public ForgetUserIdandPassword forgetUserIdandPassword;
	Configuration configuration;
	public Dimension dimension;
	public Dimension dimension2;
	public Actions actions;
	public JavascriptExecutor js;
	public Select select;
	public WebDriverWait wait;
	ExtentReports report;
	ExtentTest extentTest;

	@BeforeSuite
	public void initialReporting() {
		report = ExtentManager.initialReports();
	}

	@BeforeMethod
	public void initialTest(Method method) {
		extentTest = ExtentTestManager.createTest(report, method.getName());
		extentTest.assignCategory(method.getDeclaringClass().getName());
	}

	@AfterSuite
	public void publishReport() {
		report.flush();
	}

	@BeforeMethod
	public void setUp() {
		configuration = new Configuration();
		initDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(configuration.getProperties(URL));
		long pageLoadWait = Long.parseLong(configuration.getProperties(PAGELOAD_WAIT));
		long implicitlyWait = Long.parseLong(configuration.getProperties(IMPLICITLY_WAIT));
		long explicitlywait = Long.parseLong(configuration.getProperties(EXPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		wait = new WebDriverWait(driver, Duration.ofSeconds(explicitlywait));
		initClass();
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;

	}

	public void initDriver() {
		String browerName = configuration.getProperties(BROWSER); // "browser"
		switch (browerName) {

		case CHROME:
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
	}

	public void initClass() {
		homePage = new HomePage(driver);
		forgetUserIdandPassword = new ForgetUserIdandPassword(driver);
	}

	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for(String group: result.getMethod().getGroups()) {
			extentTest.assignCategory(group);
		}
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test PASSED");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			//extentTest.addScreenCaptureFromPath(CommonActions.getSreenShot(method.getName(), driver));
			extentTest.log(Status.FAIL, "Test FAILED");
		}else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test SKIPPED");
		}
	}

	@AfterMethod
	// aftermethod TestNG annotation
	public void tearUp() {
		driver.quit();
	}

}
