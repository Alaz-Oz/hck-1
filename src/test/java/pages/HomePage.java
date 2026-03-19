package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {
	public final static String URL = "https://myntra.com";

	@FindBy(xpath = "//a[@href='/shop/women']")
	WebElement womenBtn;
	
	@FindBy(xpath = "//a[@href='/lipstick']")
	WebElement lipstickBtn;

	protected HomePage(WebDriver driver) {
		super(driver);
	}

	public void goToLipstickPage() {
		Actions act = new Actions(driver);
		act.moveToElement(womenBtn);
		act.moveToElement(lipstickBtn);
		act.click(lipstickBtn);
		act.perform();
	}
	
	public void hoverWomenBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(womenBtn);
		act.perform();
	}
	
	public void clickLipstickLink() {
//		Actions act = new Actions(driver);
//		act.moveToElement(lipstickBtn);
//		act.click(lipstickBtn);
//		act.perform();
		lipstickBtn.click();
	}
	
	public static HomePage getPage(WebDriver driver) {
		driver.get(URL);
		return new HomePage(driver);
	}
}
