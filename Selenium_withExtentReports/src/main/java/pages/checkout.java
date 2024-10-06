package pages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class checkout {
	WebDriver driver;
	WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(20));
	@FindBy(xpath = "//input[@name='street[0]']")
	WebElement address1;
	@FindBy(xpath = "//input[@name='city']")
	WebElement City;
	@FindBy(xpath = "//*[@id='shipping-new-address-form']/div[5]/div/select")
	WebElement State;
	@FindBy(xpath = "//input[@name='postcode']")
	WebElement PostCode;
	@FindBy(xpath = "//*[@id='shipping-new-address-form']/div[8]/div/select")
	WebElement Country;
	@FindBy(xpath = "//input[@name='telephone']")
	WebElement PhNo;
	@FindBy(xpath = "//input[@value='flatrate_flatrate']")
	WebElement FixedShipping;
	@FindBy(xpath = "//td[text()='Fixed']")
	WebElement fixedtest;
	@FindBy(xpath = "//button[@data-role='opc-continue']")
	WebElement clicknext;
	@FindBy(xpath = "//span[@id='block-discount-heading']")
	WebElement clickApplyVoucher;
	@FindBy(id = "discount-code")
	WebElement dstcode;
	@FindBy(xpath = "//*[@id=\"discount-form\"]/div[2]/div/button/span/span")
	WebElement applyDiscount;
	@FindBy(xpath = "//*[@id=\"co-payment-form\"]/fieldset/div[3]/div[2]/div/div/div")
	WebElement errormsg;
	@FindBy(xpath = "//span[text()='Place Order']")
	WebElement placeOrder;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]")
	WebElement orderDetails;
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
	WebElement topOptions;
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")
	WebElement myAccount;
	@FindBy(xpath = "//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")
	WebElement myOrders;
	@FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody/tr/td[6]/a[1]/span")
	WebElement viewOrder;
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
	WebElement signOutButton;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
	WebElement signOutMessage1;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/p")
	WebElement signOutMessage2;
	@FindBy(xpath = "//input[@id='billing-address-same-as-shipping-checkmo']")
	WebElement checkAddressBox;
	@FindBy(xpath = "//strong[normalize-space()='Grand Total']")
	WebElement viewordertotal;
	@FindBy(xpath = "//span[@class='base']")
	WebElement ThankYouForYourPurchase;
	public void checkornot() {
		if (!checkAddressBox.isSelected())
			checkAddressBox.click();
	}
	public String finalSignOut() {
		topOptions.click();
		signOutButton.click();
		return (signOutMessage1.getText() + " " + signOutMessage2.getText());
	}
	public void goToOrderSteps() {
		topOptions.click();
		myAccount.click();
		myOrders.click();
		viewOrder.click();
		new Actions(driver).moveToElement(viewordertotal).perform();
	}
	public String getOrderFromViewOrder() {
		return ThankYouForYourPurchase.getText();
	}
	public String getdetails() {
		return orderDetails.getText();
	}
	public void clickPlaceOrder() {
		placeOrder.click();
		wt.until(ExpectedConditions.visibilityOf(ThankYouForYourPurchase));
	}
	public String clickapplydiscoutncode(String cde) {
		wt.until(ExpectedConditions.elementToBeClickable(clickApplyVoucher));
		clickApplyVoucher.click();
		dstcode.sendKeys(cde);
		applyDiscount.click();
		return errormsg.getText();
	}
	public void nextClick() {
		clicknext.click();
	}
	public String selectshipmethod() {
		FixedShipping.click();
		return fixedtest.getText();
	}
	public void phnoenter(String no) {
		PhNo.sendKeys(no);
	}
	public void zipenter(String pincode) {
		PostCode.sendKeys(pincode);
	}

	public void Stateselect(String ste) {
		Select opt = new Select(State);
		opt.selectByVisibleText(ste);
	}
	public void countryselect(String ctry) {
		new Actions(driver).moveToElement(Country).perform();
		Select opt = new Select(Country);
		opt.selectByVisibleText(ctry);
	}
	public void cityenter(String cty) {
		City.sendKeys(cty);
	}
	public void enterAddress(String addres) {
		address1.sendKeys(addres);
	}
	public checkout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
