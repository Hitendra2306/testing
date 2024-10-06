package pages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class homepage {
	WebDriver driver;
	public void waitfunction(WebElement wb, int time) {
		new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(wb));
	}
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[1]/button")
	WebElement custmrLoginbutton;
	@FindBy(xpath = "//select[@id='userSelect']")
	WebElement selectnameDropDown;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/strong/span")
	WebElement welcome;
	@FindBy(xpath = "//button [text()='Login']")
	WebElement loginbutton;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/strong")
	WebElement welcomemsg;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[1]")
	WebElement AccNumber;
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong [2]")
	WebElement AccBal;
	@FindBy(xpath = "//button[@ng-click='deposit()']")
	WebElement DepositTab;
	@FindBy(xpath = "//input[@ng-model='amount']")
	WebElement amount;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath = "//span[@class='error ng-binding']")
	WebElement depositmsg;
	@FindBy(xpath = "//button[@ng-click='withdrawl()']")
	WebElement withdrawtab;
	@FindBy(xpath = "//button[@ng-click='transactions()']")
	WebElement transactions;
	@FindBy(xpath = "//button[@ng-click='byebye()']")
	WebElement logout;
	@FindBy(xpath = "//button[@ng-click='home()']")
	WebElement home;
	@FindBy(xpath = "//button[@ng-click='manager()']")
	WebElement managerlogin;
	@FindBy(xpath = "//button[@ng-click='addCust()']")
	WebElement addcustomer;
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement LastName;
	@FindBy(xpath = "//input[@placeholder='Post Code']")
	WebElement postcode;
	@FindBy(xpath = "//button[@ng-click='openAccount()']")
	WebElement openaccount;
	@FindBy(id = "currency")
	WebElement selectcurrency;
	@FindBy(xpath = "//button[@ng-click='showCust()']")
	WebElement customers;
	@FindBy(tagName = "input")
	WebElement searchbox;
	@FindBy(xpath = "//input[@ng-model='searchCustomer']")
	WebElement searchfield;
	@FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
	WebElement deletecustomer;
	@FindBy(xpath = "//tr[@class='ng-scope']//td [1]")
	WebElement firstdata;
	@FindBy(xpath = "//table")
	WebElement datatable;
	// ---------------------------------Login—------------------------------------------------------------//
	public void clickcustomerlogin() {
		waitfunction(custmrLoginbutton, 20);
		custmrLoginbutton.click();
	}
	public void selectname() {
		waitfunction(selectnameDropDown, 10);
		Select option = new Select(selectnameDropDown);
		option.selectByVisibleText("Hermoine Granger");
	}
	public void clkloginbutton() {
		loginbutton.click();
	}
	public String getwelcomemsg() {
		waitfunction(welcomemsg, 20);

		return welcomemsg.getText().replace(welcome.getText(), "");
	}
	// ------------------------------------------------------Depositandwithdraw—------------------------------------------------------------//
	public void clickDepositTab() {
		waitfunction(DepositTab, 28);
		DepositTab.click();
	}
	public void clickSubmitbutton() {
		waitfunction(submit, 20);
		submit.click();
	}
	public void entermount(String amt) {
		waitfunction(amount, 10);
		amount.sendKeys(amt);
	}
	public String getDepositMsg() {
		try {
			waitfunction(depositmsg, 5);
			return depositmsg.getText();
		} catch (Exception e) {
			return null;
		}
	}
	public void clickWithdrawTab() {
		waitfunction(withdrawtab, 10);
		withdrawtab.click();
	}
	// --------------------------------------------------------------transactions------------------------------------------------//
	public void transactionTabClk() {
		waitfunction(transactions, 10);
		transactions.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.urlMatches("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx"));
	}
	// ---------------------------------------------------logout-------------------------------------------------------------------//
	public void logoutclk() {
		waitfunction(logout, 10);
		logout.click();
	}
	public void homeButtonClk() {
		waitfunction(home, 10);
		home.click();
	}
	public void managerLoginClk() {
		waitfunction(managerlogin, 10);
		managerlogin.click();
		new WebDriverWait(driver, Duration.ofSeconds(18)).until(ExpectedConditions
				.urlMatches("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager"));
	}
	// -----------------------------------------------------------addcustomer------------------------------------------------------------//
	public void addCustomerClk() {
		waitfunction(addcustomer, 10);
		addcustomer.click();
	}
	public void EnterCustomerDetails(String fname, String Iname, String pcode) {
		waitfunction(firstName, 10);
		firstName.sendKeys(fname);
		LastName.sendKeys(Iname);
		postcode.sendKeys(pcode);
	}
	public String alerthandling() {
		String txt = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return txt;
	}
	// ------------------------------------------------------openaccount------------------------------------------//
	public void openAccountClk() {
		waitfunction(openaccount, 10);
		openaccount.click();
	}
	public void selectNameForManager(String name) {
		waitfunction(selectnameDropDown, 18);
		Select option = new Select(selectnameDropDown);
		option.selectByVisibleText(name);
	}
	public void currencySelect(String currency) {
		Select opt=new Select(selectcurrency);
		opt.selectByVisibleText(currency);

	}
	// ------------------------------------------customers-------------------------------------------------------//
	public void customersClk() {
		customers.click();
	}
	public boolean validateTable() {
		waitfunction(datatable, 10);
		if (datatable.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean validateSearchbox() {
		if (searchbox.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	// --------------------------------------------------------------delete------------------------------------------------------------------//
	public void Entersearchbox(String name) {
		waitfunction(searchbox, 10);
		System.out.println(name);
		searchbox.clear();
		searchbox.sendKeys(name);
	}
	public void clickdelete() {
		waitfunction(deletecustomer, 10);
		deletecustomer.click();
	}
	public boolean elementpresent() {
		try {
			waitfunction(firstdata, 10);
			firstdata.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
