

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {

	public WebDriver driver;

	@FindBy(className = "logo")
	private WebElement logo;

	@FindBy(partialLinkText = "Home")
	private WebElement homeBtn;

	@FindBy(className = "nav")
	private WebElement nav;

	@FindBy(id = "slider")
	private WebElement slider;

	@FindBy(id = "footer")
	private WebElement footer;

	@FindBy(partialLinkText = "Signup / Login")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Products')]")
	private WebElement productsBtn;
	@FindBy(partialLinkText = "Contacts")
	private WebElement contactsBtn;
	@FindBy(partialLinkText = "Cart")
	private WebElement cartBtn;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getNav() {
		return nav;
	}

	public WebElement getSlider() {
		return slider;
	}

	public WebElement getFooter() {
		return footer;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getProductsBtn() {
		return productsBtn;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public WebElement getContactsBtn() {
		return contactsBtn;
	}

	public HomePage clickHome() {
		getHomeBtn().click();
		return new HomePage(driver);
	}


	public static HomePage open(WebDriver driver) {
		driver.get(Config.HOME_PAGE_URL);
		return new HomePage(driver);
	}

}
