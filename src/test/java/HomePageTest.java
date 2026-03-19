
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

	@Test
	void test() {
		
		localTest.get().info("Starting to run this");
		HomePage home = HomePage.open(localWebDriver.get());
		home.getSlider();
		localTest.get().warning("Ended running this");

	}

	@Test
	void isLogoVisible() {

		HomePage home = HomePage.open(localWebDriver.get());
		home.getLogo();

	}

	@Test
	void isSliderVisible() {

		HomePage home = HomePage.open(localWebDriver.get());
		home.getSlider();

	}

	@Test
	void isNavVisible() {

		HomePage home = HomePage.open(localWebDriver.get());
		home.getNav();

	}

	@Test
	void isFooterVisible() {

		HomePage home = HomePage.open(localWebDriver.get());
		home.getFooter();

	}

}
