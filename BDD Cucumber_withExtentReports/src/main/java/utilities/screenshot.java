package utilities;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class screenshot {
	String time = new SimpleDateFormat("yyyy-MMM-dd-HH-mm-ss").format(new Date());
	String path;
	public screenshot() throws IOException {
		path = "/Users/H120450452/eclipse-workspace/UseCasel/test-output/screenshots/lumaScreenshots-" + time;
		File f = new File(path);
		f.mkdir();
		// check if the directory can be created // using the specified path name
		if (f.mkdir() == true) {
			FileWriter writ = new FileWriter("/Users/HI20458452/eclipse-workspace/UseCasel/target/pathname.txt");
			writ.write(path);
			writ.close();
		}
		// System.out.println("Directory has been created successfully");
		else { // System.out.println("Directory cannot be created");
		}
	}
	public void savescreenshot(WebDriver driver, String Heading) throws IOException {
		File fl = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fl, new File(path + "/" + Heading + ".jpg"));
	}
}
