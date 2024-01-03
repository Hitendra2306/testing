package withoutPageObjectModel;


import java.io.IOException;
import java.time.Duration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class testing extends testing1 {

	static String Path = "one\\";
	public static void search4(String word) throws IOException, InterruptedException {
		driver.findElement(By.xpath("//a[@class='noo-search']")).click();
		driver.findElement(By.xpath("//input[@name='s']")).sendKeys(word);
		screenShot("1-search", Path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@name='s']")).sendKeys(Keys.RETURN);
		// scroll(15);
		screenShot("2-searchitem", Path);
	}
	static String value = "";
	@BeforeClass
	public static void launch() {
		System.out.println("Beforeclass");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://shop.demoqa.com/");
		Boolean Display = driver.findElement(By.xpath("//a[text()='Dismiss']")).isDisplayed();
		if (Display) {
			driver.findElement(By.xpath("//a[text()='Dismiss']")).click();
		}
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		login();
	}
	@Before
	public void select() throws IOException, InterruptedException {
		System.out.println("before");
		search4("Sandals");
		driver.findElement(By.xpath("(//img[@loading ='lazy'])[1]")).click();
		driver.findElement(By.xpath("//i[@class='icon_plus']")).click();
		Select l1 = new Select(driver.findElement(By.xpath("//select[@id='pa_color']")));
		l1.selectByVisibleText("Red");
		Select l2 = new Select(driver.findElement(By.xpath("//select[@id='pa_size']")));
		l2.selectByVisibleText("36");
		screenShot("3-Selection", Path);
	}
	@Test
	public void execute() throws IOException, InterruptedException {
		System.out.println("test");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		driver.findElement(By.xpath("//i[@class='icon_bag_alt']")).click();
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("(//bdi)[1]"))).click().build().perform();
	}
	@After
	public void preclosing() throws IOException, InterruptedException {
		System.out.println("after");
		value = (driver.findElement(By.xpath("(//bdi)[1]")).getText());
		value = value.substring(1, value.length() - 3);
		filecreation("task4", value);
		int ans = Integer.parseInt(value);
		if (ans < 200) {
			System.out.println(value);
			driver.findElement(By.xpath("//a[contains(text(),'continue')]")).click();
		}
		System.out.println(value);
		screenShot("4-final", Path);
	}
	@AfterClass
	public static void closing() {
		System.out.println("afterclass");
		driver.quit();
	}
}
