package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpageAndRegister {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='username']")
	WebElement LoginUserName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement LoginPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement Loginbutton;

	@FindBy(xpath = "//input[@id='reg_username']")
	WebElement Regusername;

	@FindBy(xpath = "//input[@id='reg_email']")
	WebElement Regemail;

	@FindBy(xpath = "//input[@id='reg_password']")
	WebElement Regpassword;

	@FindBy(xpath = "//button[@name='register']")
	WebElement Regbutton;


	public loginpageAndRegister(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void registration(String uname,String mail,String pass)
	{
		Regusername.sendKeys(uname);
		Regemail.sendKeys(mail);
		Regpassword.sendKeys(pass);
		Regbutton.click();
		if (driver.findElement(By.xpath("//strong")).isDisplayed()) {
			login(uname, pass);
		}
	}

	public void login(String uname, String pass)
	{
		LoginUserName.clear();
		LoginUserName.sendKeys(uname);
		LoginPassword.clear();
		LoginPassword.sendKeys(pass);
		Loginbutton.click();
	}
}
