package pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {


	WebDriver driver;
	String searchword="DRESS";

	@FindBy(xpath = "//a[text()='My Account']")
	WebElement MyacButton;

	@FindBy(xpath = "//a[@class='noo-search']")
	WebElement SearchButton;

	@FindBy(xpath = "//input[@name='s']")
	WebElement SearchInput;

	@FindBy(xpath = "//div[@class='pull-right noo_woocommerce-catalog']//select[@class='noo-woo-filter' and @name='filter_style']")
	WebElement SearchInputList;

	@FindBy(xpath = "(//select[@name='orderby' and @aria-label='Shop order'])[1]")
	WebElement SearchInputSort;

	@FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/h3/a")
	WebElement FirstDress;

	@FindBy(id =  "tab-description")
	WebElement DressDescription;

	@FindBy(xpath = "(//select)[1]")
	WebElement colour;

	@FindBy(xpath = "(//select)[2]")
	WebElement size;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement AddToCartButton;

	@FindBy(xpath = "//i[@class='icon_bag_alt']")
	WebElement AddToCarttab;

	@FindBy(xpath = "//a[contains(text(),'Proceed')]")
	WebElement checkoutbutton;

	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void myaccclick()
	{
		MyacButton.click();
	}

	public void searchclick()
	{
		SearchButton.click();
	}

	public void searchinput() {

		SearchInput.sendKeys(searchword);
		SearchInput.sendKeys(Keys.ENTER);

	}

	public void selectlist() {
		Select list = new Select(SearchInputList);
		list.selectByVisibleText("List");


	}
	public void selectpricetolow() {
		Select list = new Select(SearchInputSort);
		list.selectByVisibleText("Sort by price: low to high");
	}

	public String selectfirstdress() throws InterruptedException {
		WebDriverWait hold=new WebDriverWait(driver, Duration.ofSeconds(50));

		hold.until(ExpectedConditions.elementToBeClickable(FirstDress));
		FirstDress.click();
		String para = DressDescription.getText();
		return para;
	}

	public void dressconfiguration() {
		Select type=new Select(colour);
		type.selectByVisibleText("Beige");
		type=new Select(size);
		type.selectByVisibleText("Large");
	}

	public void clickaddtocart() {
		AddToCartButton.click();
	}

	public void clickaddtocarttab() {
		AddToCarttab.click();
	}

	public void checkoutbuton() {
		checkoutbutton.click();
	}


}
