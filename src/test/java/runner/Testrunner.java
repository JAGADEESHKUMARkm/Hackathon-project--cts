package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\2303984\\eclipse-workspace\\HackathonProject\\FeatureFile\\feature.feature" ,
		glue="stepDefinition",
		plugin = {"pretty", "html:Cucumber/myReport.html","rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,
         dryRun=false,
         monochrome=true,
         publish=true, 
         tags ="@smoke")
 
public class Testrunner {
 
} 