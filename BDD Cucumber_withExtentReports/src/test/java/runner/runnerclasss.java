package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features = "D://Hitendra//codesAutomation//usecase2//features",
glue = "stepdef",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class runnerclasss extends AbstractTestNGCucumberTests {
}
