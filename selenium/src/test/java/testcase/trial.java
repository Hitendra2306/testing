package testcase;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenium.Base;
import selenium.functions;

public class trial extends Base {

	String uname="hk2001",mail="kk2001@gmail.com",pass="@kk123kk#";

	String path = "D:\\Hitendra\\codesAutomation\\selenium\\pomscreenshots";

	String fname="hietk",  lname="k",  country="India",  Address="2/48",
			town="kelambakkam",
			state="Tamil Nadu",
			pin="603103",  phone="7397416644",  billmail="hk2--@gmail.com";

	public void waiting() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	@Test
	public void testcase() throws IOException, InterruptedException
	{
		functions.deletion(path);
		functions.screenShot(driver,"01_pom opening", path);
		Boolean Display = driver.findElement(By.xpath("//a[text()='Dismiss']")).isDisplayed();
		if (Display) {
			driver.findElement(By.xpath("//a[text()='Dismiss']")).click();
		}
		homepage.myaccclick();
		functions.screenShot(driver,"02_pom myacc", path);
		loginpage.registration(uname, mail, pass);
		functions.screenShot(driver,"03-pom registartion", path);
		homepage.searchclick();
		functions.screenShot(driver,"04-pom searchtab", path);
		homepage.searchinput();
		waiting();
		functions.screenShot(driver,"05-pom searchinput", path);
		homepage.selectlist();
		functions.screenShot(driver,"06-pom selectlist", path);
		homepage.selectpricetolow();
		functions.screenShot(driver,"07-pom sorthigh", path);

		String para=homepage.selectfirstdress();
		functions.filecreation("flatfile", para);
		homepage.dressconfiguration();
		functions.screenShot(driver,"08-pom color&size", path);
		functions.filecreation("file1", para);
		homepage.clickaddtocart();
		functions.screenShot(driver, "09-pom addedtocart", path);
		homepage.clickaddtocarttab();
		homepage.checkoutbuton();
		billingpage.billingdetails(fname,lname,country,Address,
				town,state,pin,phone,billmail);
		billingpage.clickconfirmorder();
		functions.screenShot(driver, "10-pom orderplaced", path);
		homepage.clickaddtocarttab();
		functions.screenShot(driver, "11-pom clickaddtocart", path);
		homepage.myaccclick();
		functions.screenShot(driver, "12-pom myacctab", path);
		myaccountpage.clickorders();
		functions.screenShot(driver, "13-pom orders", path);
		myaccountpage.clicklogout();
		functions.screenShot(driver, "14-pom loggedout", path);








	}



}
