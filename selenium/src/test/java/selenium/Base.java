package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.Billing;
import pages.Homepage;
import pages.loginpageAndRegister;
import pages.myAccount;

public class Base {
	public WebDriver driver;
	protected Homepage homepage;
	protected loginpageAndRegister loginpage;
	protected myAccount myaccountpage;
	protected Billing billingpage;

	protected Base()
	{
		driver=new ChromeDriver();
		homepage=new Homepage(driver);
		billingpage=new Billing(driver);
		loginpage=new loginpageAndRegister(driver);
		myaccountpage=new myAccount(driver);

	}

	@BeforeTest
	public void start()
	{
		driver.get("https://shop.demoqa.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void end()
	{
		//driver.quit();
	}
}
