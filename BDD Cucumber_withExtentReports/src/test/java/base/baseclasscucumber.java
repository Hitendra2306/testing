package base;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import utilities.openbrowser;
public class baseclasscucumber {
	protected static WebDriver driver;
	openbrowser open = new openbrowser();
	public WebDriver navigateTo() throws IOException {
		return open.browseropening(driver);
	}

}
