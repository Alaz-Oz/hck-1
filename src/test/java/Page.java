import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	protected WebDriver driver;
	public WebDriverWait wait;

	protected Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Config.WAIT_TIME);
		PageFactory.initElements(driver, this);
	}

	public WebElement waitForVisibility(WebElement element) {
		
		wait.until((WebDriver t) ->  {
				// TODO Auto-generated method stub
				return null;
			
		});
		
		
		
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

}