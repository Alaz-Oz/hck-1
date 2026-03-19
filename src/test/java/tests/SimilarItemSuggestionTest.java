package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LipstickPage;

public class SimilarItemSuggestionTest extends BaseTest {

	@Test
	void moveToLipstickPage() {
		HomePage home = HomePage.getPage(getDriver());
		home.hoverWomenBtn();
		home.clickLipstickLink();

		getWait().until(ExpectedConditions.urlToBe(LipstickPage.URL));
	}

	@Test(dependsOnMethods = "moveToLipstickPage")
	void checkViewSimilarModalStatus() {
		LipstickPage page = new LipstickPage(getDriver());
		String id = page.hoverFifthElement();
		page.hoverViewSimilarBtn(id);
		page.clickViewSimilarBtn(id);

		// Check if modal is active and focused

		WebElement modal = page.getModal();
		
		getWait().until(ExpectedConditions.visibilityOf(modal));
		WebElement focused = getDriver().switchTo().activeElement();
		
		assertEquals(modal, focused);
		
	}

	@Test(dependsOnMethods = "checkViewSimilarModalStatus")
	void verify50PercentSimilarity() {
		LipstickPage page = new LipstickPage(getDriver());
		List<String> similarItems = page.getSimilarItems();

		String brand = page.getFifthResult();

		getTest().info("Similar Item count : " + similarItems.size());

		int count = 0;
		for (String item : similarItems) {
			if (item.equals(brand))
				count++;
		}
		int percent = (count * 100) / similarItems.size();

		getTest().info("Matching % : " + percent);

		assertTrue(percent >= 50);
	}
	
	@Test(dependsOnMethods = "verify50PercentSimilarity")
	void verifyClosure() {
		LipstickPage page = new LipstickPage(getDriver());
		page.closeModal();
		
		boolean hidden = getWait().until(ExpectedConditions.invisibilityOfAllElements(page.getSimilarElements()));
		
		assertTrue(hidden);
	}
}
