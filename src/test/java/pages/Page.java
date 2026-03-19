package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Config;

public class Page {

	protected WebDriver driver;

	protected Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}