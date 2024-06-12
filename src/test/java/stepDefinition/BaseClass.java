package stepDefinition;

import java.io.FileReader;

import java.io.IOException;

import java.time.Duration;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;

public class BaseClass {
	static WebDriver driver;
	//public static Logger logger;
	static Properties p;

	//getting the value from config file and keeping in initializebrowser method for invoking the browser
	
	public static WebDriver initilizeBrowser() throws IOException
		{
		//from getproperties we passing the value and getproperty gets the value of from file in lower case
			switch(getProperties().getProperty("browser").toLowerCase())
			{
			//if the value is chrome in the config file it invokes chrome driver or other
			case "chrome":
				driver=new ChromeDriver();
				break;
			case "edge":
				driver=new EdgeDriver();
				break;
			
			default:
				System.out.println("No matching browser");
				driver=null;
			}
			
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException
	{		
		//gets the value from config file and stored in p
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		//location of the property fle
		p=new Properties();
		//initiating p to the properties has everything in config file with p keyword
		p.load(file);
		//it loads the properties into the p
		return p;
	}
}