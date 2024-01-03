package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import selenium.functions;

public class Billing {
	WebDriver driver;

	@FindBy(id = "billing_first_name")
	WebElement billname;

	@FindBy(id = "billing_last_name")
	WebElement billlastname;

	@FindBy(xpath = "(//select)[1]")
	WebElement bilcountry;

	@FindBy(id = "billing_address_1")
	WebElement billaddress;

	@FindBy(id = "billing_city")
	WebElement billcity;

	@FindBy(id = "billing_state")
	WebElement billstate;

	@FindBy(id = "billing_postcode")
	WebElement postcode;

	@FindBy(id = "billing_phone")
	WebElement billphone;

	@FindBy(id = "billing_email")
	WebElement billemail;

	@FindBy(xpath = "//input[@name='terms']")
	WebElement termscheckbox;

	@FindBy(id = "place_order")
	WebElement placeorder;


	public Billing(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void billingdetails(String fname, String lname, String country, String Address, String town, String state,
			String pin, String phone, String mail)
	{
		billname.sendKeys(fname);
		billlastname.sendKeys(lname);
		Select l2 = new Select(bilcountry);
		l2.selectByVisibleText(country);
		billaddress.clear();
		billaddress.sendKeys(Address);
		billcity.clear();
		billcity.sendKeys(town);
		Select l = new Select(billstate);
		l.selectByVisibleText(state);
		postcode.clear();
		postcode.sendKeys(pin);
		billphone.sendKeys(phone);
		billemail.clear();
		billemail.sendKeys(mail);
		Actions actions = new Actions(driver);
		actions.moveToElement(termscheckbox).click().build().perform();
		functions.scroll(driver,-3);
		termscheckbox.click();
	}

	public void clickconfirmorder() {
		placeorder.click();
	}
}


