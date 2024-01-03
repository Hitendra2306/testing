package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='reg_username']")
	WebElement MyAccUserName;

	@FindBy(xpath = "//input[@id='reg_email']")
	WebElement MyAccEmail;

	@FindBy(xpath = "//input[@id='reg_password']")
	WebElement MyAccPassword;

	@FindBy(xpath = "//button[@name='register']")
	WebElement registerbutton;

	@FindBy(xpath = "//a[contains(text(),'Orders')]")
	WebElement orderstab;

	@FindBy(xpath = "//a[contains(text(),'Log')]")
	WebElement logout;

	public myAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickorders() {
		orderstab.click();
	}

	public void clicklogout()
	{
		logout.click();
	}
}
