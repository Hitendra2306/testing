package pages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class homepage {
	WebDriver driver;
	WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	WebElement createAccount;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
	WebElement loginerror;
	@FindBy(id = "firstname")
	WebElement firstName;
	@FindBy(id = "lastname")
	WebElement lastname;
	@FindBy(id = "email_address")
	WebElement email;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "password-confirmation")
	WebElement confirmPwd;
	@FindBy(xpath = "//button[@title='Create an Account']")
	WebElement submitcreateAc;
	@FindBy(xpath = "//button[@type='button']")
	WebElement dropdown;
	@FindBy(xpath = "//li[@class='authorization-link']/a")
	WebElement signout;
	@FindBy(xpath = "//li[@class='authorization-link']/a")
	WebElement signin;
	@FindBy(name = "login[username]")
	WebElement enterEmail;
	@FindBy(name = "login[password]")
	WebElement enterPass;
	@FindBy(xpath = "//button[@class='action login primary']")
	WebElement Login;
	@FindBy(xpath = "//span[contains(text(), 'Welcome')]")
	WebElement greettxt;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div/text()")
	WebElement Loginflag;
	public boolean loginerror() {
		return loginerror.isDisplayed();
	}
	public void clickCreateAccount() {
		createAccount.click();
	}
	public void enterFirstName(String fName) {
		firstName.click();
		firstName.sendKeys(fName);
	}
	public void enterLastname(String lstname) {
		lastname.click();
		lastname.sendKeys(lstname);
	}
	public void clickEmail(String mail) {
		email.click();
		email.sendKeys(mail);
	}
	public void clickPassword(String pswd) {
		password.click();
		password.sendKeys(pswd);
	}
	public void clickConfirmPwd(String cPswd) {
		confirmPwd.click();
		confirmPwd.sendKeys(cPswd);
	}
	public void clickSubmitcreateAc() {
		submitcreateAc.click();
	}
	public void dropDown() {
		dropdown.click();
	}
	public void clickSignout() {
		signout.click();
	}
	public void clickSignin() {
		signin.click();
	}
	public void loginmodule(String logem, String logpass) {
		wt.until(ExpectedConditions.elementToBeClickable(signin));
		//new Actions(driver).moveToElement(signin).perform();
		signin.click();
		enterEmail.sendKeys(logem);
		enterPass.sendKeys(logpass);
		Login.click();
	}
	public boolean errorcode() {
		return Loginflag.isDisplayed();
	}
	public boolean gettext() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return greettxt.isDisplayed();
	}
	public homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
