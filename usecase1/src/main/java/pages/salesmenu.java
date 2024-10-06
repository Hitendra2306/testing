package pages;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class salesmenu {
	WebDriver driver;
	WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
	@FindBy(xpath = "//a[@id='ui-id-8']")
	WebElement sale;
	@FindBy(xpath = "//*[@id='maincontent']/div[4]/div[2]/div/div/ul[2]/li[3]/a")
	WebElement tees;
	@FindBy(xpath = "//div[text()='Pattern']")
	WebElement pattern;
	@FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[9]/div[2]/ol/li/a")
	WebElement solid;
	@FindBy(xpath = "//div[text()='Climate']")
	WebElement climate;
	@FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[3]/div[2]/ol/li[1]/a")
	WebElement Indooroption;
	@FindBy(xpath = "//div[text()='Material']")
	WebElement material;
	@FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[6]/div[2]/ol/li[6]/a")
	WebElement rayon;
	@FindBy(id = "option-label-size-143-item-169")
	WebElement sizel;
	@FindBy(id = "option-label-color-93-item-50")
	WebElement clorblue;
	@FindBy(xpath = "//*[@id='maincontent']/div[3]/div[1]/div[3]/ol/li/div/div/div[4]/div/div[1]/form/button")
	WebElement addtocart;
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement addded;
	@FindBy(xpath = "//span[@class='counter-number']")
	WebElement clickcart;
	@FindBy(xpath = "//span[normalize-space()='View and Edit Cart']")
	WebElement viewEditCart;
	public void cartclick() {
		// wt.until(ExpectedConditions.visibilityof(addded));
		// new Actions(driver).moveToElement(clickcart).perform();
		// System.out.println(clickcart.getText());
		clickcart.click();
	}
	public void viewcartclick() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		viewEditCart.click();
	}
	public void addtocartselect() {
		new Actions(driver).sendKeys(Keys.ARROW_DOWN);
		addtocart.click();
		wt.until(ExpectedConditions.visibilityOf(addded));
	}
	public void sizeAndColorSelect() {
		sizel.click();
		clorblue.click();
	}
	public void materialselect() {
		material.click();
		rayon.click();
	}
	public void climateselect() {
		climate.click();
		Indooroption.click();
	}
	public void clicksalesmenu() {
		sale.click();
	}
	public void teesclick() {
		tees.click();
	}
	public void patternclick() {
		pattern.click();
		solid.click();
	}
	public salesmenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
