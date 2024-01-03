package selenium;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class functions   {
	public static void screenShot(WebDriver driver,String filename, String location) throws IOException, InterruptedException {
		// Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		// ImageIO.write(screenshot.getImage(),"jpg",new File("/Users/HI20450452/eclipse-workspace/Selenium_Hands_On/ss/" + filename+".png"));
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(location +"\\" + filename+ ".png"));
	}

	public static void deletion(String path1) {
		// try {
		//	     Files.deleteIfExists(Paths.get("/Users/HI20450452/eclipse-workspace/Selenium_Hands_On/ss/"));
		// } catch (IOException e) {
		//	     e.printStackTrace();
		// }
		//D:\\Hitendra\\codesAutomation\\selenium\\shots
		File path = new File(path1);
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
	public static void scroll(WebDriver driver,int pix) {
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
}
