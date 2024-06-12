package identifyCourses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseDriver {

	public WebDriver driver;
	public static Logger logger;
	
	@BeforeClass(groups = { "regression","smoke" })
	@Parameters({"browser"})
	public void driver(String browser) {
		logger = LogManager.getLogger(this.getClass()); 
		//it lomanger is a class which contains the data Getlogger is a method. this line used to invoke the logManger class
	
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else {
			driver  = new EdgeDriver();
		}
		driver.get("https://www.coursera.org/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups = { "regression","smoke" })
	public void close() {
		driver.quit();
	}
	
	public static String screenShot(String filename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir") + "\\Screenshots\\" + filename + ".png");
		FileUtils.copyFile(src, trg);
		return trg.getAbsolutePath();//returning the path
		
		
		
		
		
		
	}

	
}
