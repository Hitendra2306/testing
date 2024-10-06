package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class openbrowser {

	public WebDriver browseropening(WebDriver driver) throws IOException {

		FileInputStream fl=new FileInputStream("D://Hitendra//codesAutomation//usecase2//config.properties");
		Properties pr=new Properties();
		pr.load(fl);
		String url=pr.getProperty("url");
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("start-fullscreen");
		driver= new ChromeDriver(opt);
		driver.get(url);
		return driver;
	}

	public WebDriver browserclose(WebDriver driver) {
		driver.quit();
		return driver;
	}
}
