package tests;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.baseclass;
import utilities.excelcode;
public class test1 extends baseclass {
	String msg;
	String orderid;
	@Test(priority = 0, dataProvider = "dataset")
	public void login(String fname, String lstname, String mail, String pswd) throws IOException {
		hpage.loginmodule(mail, pswd);
		try {
			if (hpage.loginerror()) {
				hpage.clickCreateAccount();
				hpage.enterFirstName(fname);
				hpage.enterLastname(lstname);
				hpage.clickEmail(mail);
				hpage.clickPassword(pswd);
				hpage.clickConfirmPwd(pswd);
				hpage.clickSubmitcreateAc();
				// System.out.println("greeting"); // Assert.assertEquals(greeting,
				// hpage.gettext());
				Assert.assertTrue(hpage.gettext());
				shot.savescreenshot(driver, "welcome");
			} else {
				Assert.assertTrue(hpage.gettext());
				shot.savescreenshot(driver, "welcome");
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
	@DataProvider(name = "dataset")
	public Object[][] testData() throws Exception {
		excelcode re = new excelcode();
		Object[][] data = re.testdata(
				"D:/Hitendra/codesAutomation/usecase1/src/test/resources/datasheet.xlsx",
				"register");
		return data;
	}
	@Test(priority = 1,dependsOnMethods = "login")
	public void addingDress() throws IOException {
		sale.clicksalesmenu();
		shot.savescreenshot(driver, "sales");
		sale.teesclick();
		shot.savescreenshot(driver, "tees");
		sale.patternclick();
		shot.savescreenshot(driver, "pattern");
		sale.climateselect();
		shot.savescreenshot(driver, "climate");
		sale.materialselect();
		shot.savescreenshot(driver, "material");
		sale.sizeAndColorSelect();
		shot.savescreenshot(driver, "sizeAndColour");
		sale.addtocartselect();
		shot.savescreenshot(driver, "addedToCart");
		sale.cartclick();
		sale.viewcartclick();
		shot.savescreenshot(driver, "cart");
	}
	@Test(priority = 2,dependsOnMethods = "addingDress")
	public void addbottle() {
		addcart.clickreview();
		String des = addcart.getReviewText();
		// System.out.println(deg);
		Assert.assertEquals(addcart.getReviewText(), des);
		addcart.addbottletocartclick();
		addcart.cartclick();
		addcart.checkoutclick();
	}
	@DataProvider(name = "dataset1")
	public Object[][] testDatal() throws Exception {
		excelcode re = new excelcode();
		Object[][] data = re.testdata(
				"D:/Hitendra/codesAutomation/usecase1/src/test/resources/datasheet.xlsx",
				"billing");
		return data;
	}
	@Test(priority = 3, dataProvider = "dataset1",dependsOnMethods = "addbottle")
	public void checkoutpagetest(String address, String cntry, String state, String city, String pincde, String phno,
			String voucher) throws IOException {
		bill.enterAddress(address);
		bill.countryselect(cntry);
		bill.Stateselect(state);
		bill.cityenter(city);
		bill.zipenter(pincde);
		bill.phnoenter(phno);
		String shipmethod = bill.selectshipmethod();
		Assert.assertEquals(shipmethod, "Fixed");
		bill.nextClick();
		bill.checkornot();
		String msg = bill.clickapplydiscoutncode(voucher);
		// System.out.println(msg);
		Assert.assertEquals(msg, "The coupon code isn't valid. Verify the code and try again.");
		bill.clickPlaceOrder();
		FileWriter writ = new FileWriter("data.txt");
		orderid = bill.getdetails().replaceAll("[^0-9]", "").trim();
		shot.savescreenshot(driver, "orderPlaced");
		// System.out.println(orderid);
		writ.write(bill.getdetails());
		writ.close();
		// The coupon code isn't valid. Verify the code and try again.
	}
	@Test(priority = 4,dependsOnMethods = "checkoutpagetest")
	public void ValidateOrder() throws IOException {
		bill.goToOrderSteps();
		shot.savescreenshot(driver, "ViewOrder-details");
		String validateorderdetails = bill.getOrderFromViewOrder().replaceAll("[^0-9]", "").trim();
		// System.out.println(validateorderdetails):
		Assert.assertEquals(orderid, validateorderdetails);
		msg = bill.finalSignOut();
		Assert.assertEquals(msg, "You are signed out You have signed out and will go to our homepage in 5 seconds.");
		shot.savescreenshot(driver, "signedOut");
		// System.out.println(msg);
	}
}
