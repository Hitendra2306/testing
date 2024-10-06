package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class cart {
	WebDriver driver;
	@FindBy(xpath = "//ol[@class='products list items product-items']//li[3]//span[text()='Review']")
	WebElement reviewbutton;
	@FindBy(xpath = "//*[@id=\"customer-reviews\"]/div[2]/ol/li/div[3]")
	WebElement reviewDescription;
	@FindBy(xpath = "//button[@id='product-addtocart-button']")
	WebElement addBottleToCart;
	@FindBy(xpath = "//a[@class='action showcart']")
	WebElement clickCart;
	@FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]")
	WebElement checkout;
	public void clickreview() {
		reviewbutton.click();
	}
	public String getReviewText() {
		return reviewDescription.getText();
	}
	public void addbottletocartclick() {
		addBottleToCart.click();
	}
	public void cartclick() {
		new Actions(driver).moveToElement(clickCart).perform();
		clickCart.click();
	}
	public void checkoutclick() {
		checkout.click();
	}

	public cart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
