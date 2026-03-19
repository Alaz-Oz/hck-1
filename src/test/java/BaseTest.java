import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public static ExtentReports extent;
	
	protected static ThreadLocal<ExtentTest> localTest = new ThreadLocal<>();
	protected static ThreadLocal<WebDriver> localWebDriver = new ThreadLocal<>();

	@BeforeSuite
	protected void setup() {
		ExtentSparkReporter spark = new ExtentSparkReporter(Config.SPARK_REPORT_FILE);
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@BeforeMethod
	protected void createWebDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT_TIME);
		localWebDriver.set(driver);
	}
	
	@BeforeMethod
	protected void createTest(Method method) {
		ExtentTest test = extent.createTest(method.getName());
		localTest.set(test);
	}

	@AfterMethod
	public void endTest(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			localTest.get().fail(result.getThrowable());

			
		}else localTest.get().pass("pass");
	}

	@AfterMethod
	public void closeWebDriver() {
		logScreenshot(localWebDriver.get(), localTest.get());
		logScreenshot(localWebDriver.get(), localTest.get());
		localWebDriver.get().quit();
	}

	@AfterSuite
	public void teatDown() {
		extent.flush();
	}
	
	protected void logScreenshot(WebDriver driver, ExtentTest test) {
		String base = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(base);
	}
}
