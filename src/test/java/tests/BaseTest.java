package tests;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Config;

public class BaseTest {

	public static ExtentReports extent;

	protected static ThreadLocal<ExtentTest> localTest = new ThreadLocal<>();
	protected static ThreadLocal<WebDriver> localWebDriver = new ThreadLocal<>();
	protected static ThreadLocal<WebDriverWait> localWait = new ThreadLocal<>();

	@BeforeSuite
	protected static void setup() {
		ExtentSparkReporter spark = new ExtentSparkReporter(Config.SPARK_REPORT_FILE);
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@BeforeClass
	protected void createWebDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT_TIME);
		localWebDriver.set(driver);
		
		localWait.set(new WebDriverWait(driver, Config.WAIT_TIME));

	}
	

	@BeforeMethod
	protected void createTest(Method method) {
		ExtentTest test = extent.createTest(method.getName());
		localTest.set(test);
	}

	@AfterMethod
	public void endTest(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			getTest().fail(result.getThrowable());

			logScreenshot("Last Screen");

		} else
			getTest().pass("pass");

	}

	@AfterClass
	public void closeWebDriver() {
		getDriver().quit();
	}

	@AfterSuite
	public void teatDown() {
		extent.flush();
	}

	protected WebDriver getDriver() {
		return localWebDriver.get();
	}

	protected ExtentTest getTest() {
		return localTest.get();
	}
	
	protected WebDriverWait getWait() {
		return localWait.get();
	}

	protected void logScreenshot(String name) {
		String base = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
		getTest().addScreenCaptureFromBase64String(base, name);
	}
}
