package extendReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import identifyCourses.baseDriver;
import identifyCourses.main;
  
public class report extends baseDriver implements ITestListener{
	public static String path;
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent;//populate common info on the report
	public ExtentTest test;//creating test case entries in the report and update status of the test methods

	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\myReport.html");//location
		sparkReporter.config().setDocumentTitle("Identify course Report");//title
		sparkReporter.config().setReportName("Coursera Testing");//name
		sparkReporter.config().setTheme(Theme.STANDARD);//theme
																					
		extent=new ExtentReports();//common info
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QEA");
		extent.setSystemInfo("Tester Name","Jagadeeskumar");
		extent.setSystemInfo("OS","Windows11");
		extent.setSystemInfo("Browser Name","Chrome Browser");
	}

	public void onTestSuccess(ITestResult result) {
		String path=main.path;
		test=extent.createTest(result.getName()).addScreenCaptureFromPath(path,result.getName());
		test.log(Status.PASS, "Test Case Passed is: "+result.getName());
		logger.info("passed " + result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
		test.log(Status.FAIL, "Test Case Failed cause is: "+result.getThrowable());//returns the error msg
		logger.info("Failed"+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped is: "+result.getName());	
	}
	
	public void onFinish(ITestContext context) {
		extent.flush(); //at last it will write all the details into the file
	}	
}