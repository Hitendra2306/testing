package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "D://Hitendra//codesAutomation//usecase3//features", glue = "stepdef", plugin = {"pretty", "html:reports_petstore/hooksrpt.html",
		"json:reports_petstore/hooksrpt.json",
"junit:reports_petstore/hooksrpt.xml"})
public class runnerclass extends AbstractTestNGCucumberTests {
}
//, tags = "@step3"