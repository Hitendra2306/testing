package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.openbrowser;
import utilities.screenshot;

public class baseclass {
	public WebDriver driver;

	protected homepage hpage;

	protected openbrowser openpage;

	protected screenshot shot;

	protected salesmenu sale;

	protected cart addcart;

	protected checkout bill;

	@BeforeSuite

	public void start() throws IOException {

		openpage= new openbrowser();

		driver =openpage.browseropening();

		hpage=new homepage(driver);
		sale=new salesmenu(driver);

		addcart=new cart(driver);
		bill=new checkout(driver);

		shot= new screenshot();



	}

	@AfterSuite

	public void close() {

		openpage.browserclose();

	}
}
