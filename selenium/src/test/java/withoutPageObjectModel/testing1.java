package withoutPageObjectModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class testing1 {
	static String path_file = "D:\\Hitendra\\codesAutomation\\selenium\\shots\\";

	public static WebDriver driver;
	//static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public static void search(String word) throws IOException, InterruptedException {
		driver.findElement(By.xpath("//a[@class='noo-search']")).click();
		driver.findElement(By.xpath("//input[@name='s']")).sendKeys(word);
		screenShot("4-search", path_file);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@name='s']")).sendKeys(Keys.RETURN);
		// scroll(15);
		screenShot("5-searchitem", path_file);
	}

	public static void scroll(int pix) {
		int n = 0;
		if(n>0)
		{
			while (n < pix) {
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				n++;
			}
		}
		if(n<0)
		{
			while(pix<n)
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				pix++;
			}
		}
	}
	public static void screenShot(String filename, String location) throws IOException, InterruptedException {
		// Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		// ImageIO.write(screenshot.getImage(),"jpg",new File("/Users/HI20450452/eclipse-workspace/Selenium_Hands_On/ss/" + filename+".png"));
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(location + filename + ".png"));
	}
	public static void deletion() {
		// try {
		//	     Files.deleteIfExists(Paths.get("/Users/HI20450452/eclipse-workspace/Selenium_Hands_On/ss/"));
		// } catch (IOException e) {
		//	     e.printStackTrace();
		// }
		File path = new File("D:\\Hitendra\\codesAutomation\\selenium\\shots");
		File[] files = path.listFiles();
		for (File file : files) {
			// System.out.println("Deleted filename :"+ file.getName());
			file.delete();
		}
	}
	public static void filecreation(String filename, String content) throws IOException {
		File file = new File("D:\\Hitendra\\codesAutomation\\selenium\\"
				+ filename + ".txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(content);
		pw.close();
	}
	public static void login() {
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hite23");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("hite2306@");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	public static void billing(String fname, String lname, String country, String Address, String town, String state,
			String pin, String phone, String mail)
	{
		driver.findElement(By.id("billing_first_name")).sendKeys(fname);
		driver.findElement(By.id("billing_last_name")).sendKeys(lname);
		Select l2 = new Select(driver.findElement(By.xpath("(//select)[1]")));
		l2.selectByVisibleText(country);
		driver.findElement(By.id("billing_address_1")).clear();
		driver.findElement(By.id("billing_address_1")).sendKeys(Address);
		driver.findElement(By.id("billing_city")).clear();
		driver.findElement(By.id("billing_city")).sendKeys(town);
		Select l = new Select(driver.findElement(By.id("billing_state")));
		l.selectByVisibleText(state);
		driver.findElement(By.id("billing_postcode")).clear();
		driver.findElement(By.id("billing_postcode")).sendKeys(pin);
		driver.findElement(By.id("billing_phone")).sendKeys(phone);
		driver.findElement(By.id("billing_email")).clear();
		driver.findElement(By.id("billing_email")).sendKeys(mail);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//input[@name='terms']"))).click().build().perform();
		scroll(-3);
		driver.findElement(By.xpath("//input[@name='terms']")).click();
	}
	public static void register(String UName, String mail, String pswd) throws IOException, InterruptedException {
		// Register
		driver.findElement(By.xpath("//input[@id='reg_username']")).sendKeys(UName);
		driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys(mail);
		driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys(pswd);
		driver.findElement(By.xpath("//button[@name='register']")).click();
		scroll(15);
		screenShot("3-SucessfulRegistered", path_file);
		if (driver.findElement(By.xpath("//strong")).isDisplayed()) {
			login();
		}
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		deletion();
		//WebDriverManager.chromedriver().setup();
		//ChromeOptions ops=new ChromeOptions();
		//ops.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver();
		String URL = "https://shop.demoqa.com/";
		System.out.println(URL);
		driver.manage().window().maximize();
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));
		driver.get(URL);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		screenShot("1-open", path_file);
		Boolean Display = driver.findElement(By.xpath("//a[text()='Dismiss']")).isDisplayed();
		if (Display) {
			driver.findElement(By.xpath("//a[text()='Dismiss']")).click();
		}
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		scroll(15);
		screenShot("2-MyAccount", path_file);
		register("hite23", "hitend2001@gmail.com", "hite2306@");
		// Search-------------------------------------------------------
		search("DRESS");
		Select list = new Select(driver.findElement(By.xpath(
				"//div[@class='pull-right noo_woocommerce-catalog']//select[@class='noo-woo-filter' and @name='filter_style']")));
		list.selectByVisibleText("List");
		scroll(12);
		screenShot("6-filterstyle", path_file);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select list1 = new Select(
				driver.findElement(By.xpath("(//select[@name='orderby' and @aria-label='Shop order'])[1]")));
		list1.selectByVisibleText("Sort by price: low to high");
		scroll(12);
		screenShot("7-pricelowtohigh", path_file);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/h3/a")));
		//first dress black one
		driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/h3/a")).click();
		String paratext1 = driver.findElement(By.id("tab-description")).getText();
		filecreation("flat1", paratext1);
		Select list3 = new Select(driver.findElement(By.xpath("(//select)[1]")));
		list3.selectByVisibleText("Beige");
		screenShot("8-color", path_file);
		Select list4 = new Select(driver.findElement(By.xpath("(//select)[2]")));
		list4.selectByVisibleText("Large");
		screenShot("9-size", path_file);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		screenShot("10-addedtocart", path_file);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//i[@class='icon_bag_alt']"))).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon_bag_alt']")));
		driver.findElement(By.xpath("//i[@class='icon_bag_alt']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
		/////billing*-------------------------------------
		billing("hite", "K", "India", "2/48", "kelambakkam", "Tamil Nadu", "603103", "7397416644", "hk2--@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();
		// driver.findElement(By.id("place_order")).click();
		screenShot("11-orderplaced", path_file);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon_bag_alt']")));
		String NoOfITEMS = driver.findElement(By.xpath("//i[@class='icon_bag_alt']")).getText();
		System.out.println(NoOfITEMS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//i[@class='icon_bag_alt']")).click();
		screenShot("12-addtocart1", path_file);
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		scroll(13);
		screenShot("13-myAccount1", path_file);
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		scroll(13);
		screenShot("14-orderpage", path_file);
		driver.findElement(By.xpath("//a[contains(text(),'Log')]")).click();
		screenShot("15-loggedout", path_file);
		driver.quit();
	}
}
