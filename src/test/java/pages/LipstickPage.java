package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LipstickPage extends Page {
	public final static String URL = "https://www.myntra.com/lipstick";

	@FindBy(xpath = "//ul[@class='results-base']/li[5]//h3")
	WebElement fifthCardHeading;

	@FindBy(xpath = "//ul[@class='results-base']/li[5]")
	WebElement fifthCard;

	@FindBy(xpath = "//div[@class='halfcard-closeLeftCard']/span")
	WebElement similarItemCloseBtn;

	@FindBy(xpath = "//div[contains(@class,'halfcard-leftCard')]//li//h3[@class='product-brand']")
	List<WebElement> similarItems;
	
	@FindBy(xpath = "//div[@class='halfcard-actualContent halfcard-noFooterGap']")
	WebElement modal;

	public LipstickPage(WebDriver driver) {
		super(driver);
	}

	public String hoverFifthElement() {
		Actions act = new Actions(driver);

		act.moveToElement(fifthCard); // Hover 5th element; Includes ad cards too.

		act.perform();
		return fifthCard.getAttribute("id");
	}

	public void hoverViewSimilarBtn(String id) {
		WebElement similarIcon = driver.findElement(By.xpath("//li[@id='" + id + "']/div[4]"));
		Actions act = new Actions(driver);
		act.moveToElement(similarIcon);
		act.perform();
	}

	public void clickViewSimilarBtn(String id) {
		WebElement similarBtn = driver.findElement(By.xpath("//li[@id='" + id + "']/div[4]/span[2]"));

		similarBtn.click();
	}

	public List<String> getSimilarItems() {
		List<String> result = new ArrayList<String>();

		for (WebElement item : similarItems) {
			result.add(item.getText());
		}

		return result;
	}

	public List<WebElement> getSimilarElements() {
		return similarItems;
	}

	public String getFifthResult() {
		return fifthCardHeading.getText();
	}

	public WebElement getModal() {
		return modal;
	}
	
	public void closeModal() {
		similarItemCloseBtn.click();
	}
}
