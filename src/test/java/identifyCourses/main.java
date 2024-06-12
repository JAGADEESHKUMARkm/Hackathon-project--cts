package identifyCourses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.page1;
import pageObjects.page2;
import pageObjects.page3;
import utilities.Excel_utility;

public class main extends baseDriver {

	public static String path;
	page1 pg1;
	page2 pg2;
	page3 pg3;
	public Excel_utility excel = new Excel_utility("C:\\Users\\2303984\\eclipse-workspace\\HackathonProject\\src\\test\\java\\utilities\\ExcelData.xlsx");
	
	@Test(priority = 1,groups = { "regression" })
	public void search() throws InterruptedException, FileNotFoundException, IOException {

		pg1 = new page1(driver);
		
		driver.navigate().refresh();
		Thread.sleep(6000);
		pg1.clk();

		//sending the input through excell row 0, column 0 
		String input = excel.getCellData("Sheet1", 0, 0);
		pg1.sendInput().sendKeys(input);

		pg1.searchbtn();

		path=baseDriver.screenShot("Search_1", driver);

	}

	@Test(priority = 2,groups = { "regression" })
	public void lang() throws InterruptedException, IOException {

		Thread.sleep(5000);
		// moving down to search language
		WebElement scrl = driver.findElement(By.xpath("//button[@aria-label='Show more Subject options']//span[@class='cds-button-label'][normalize-space()='Show more']"));
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView();", scrl);
		Thread.sleep(6000);

		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor jsw = (JavascriptExecutor)driver; 		
		WebElement langclk = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1rmmvio']//div[2]//div[1]//label[1]")));
		jsw.executeScript("arguments[0].click();", langclk);
		Thread.sleep(5000);
	}	
	@Test(priority = 3,groups = { "regression" })
	public void level() throws InterruptedException, IOException {
		//scroll down for level
		WebElement scdwn = driver.findElement(By.xpath("//div[@data-testid='Graduate Certificates-false']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView();", scdwn);
		Thread.sleep(6000);
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor jss = (JavascriptExecutor)driver; 
		WebElement lvlclk = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='Beginner-false'] label[class='cds-checkboxAndRadio-label']")));
		jss.executeScript("arguments[0].click();", lvlclk);
		Thread.sleep(5000);

		//scroll up
		WebElement scup = driver.findElement(By.xpath("//h3[normalize-space()='Filter by']"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", scup);
		Thread.sleep(6000);

		path=baseDriver.screenShot("WebDevelopment", driver);
	}

	@Test(priority=4,groups = { "regression" })
	public void course1() throws InterruptedException, IOException {
		// getting course details and printing in consloe as well as sheet
		WebElement courses1 = driver.findElement(By.xpath("(//h3[starts-with(@class,'cds-CommonCard')])[1]"));
		System.out.println("First course details :");
		System.out.println("course name :"+courses1.getText());
		excel.setCellData("Sheet2", 0, 0, courses1.getText() );

		WebElement duration = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[3]"));
		System.out.println("course duration :"+duration.getText());
		excel.setCellData("Sheet2", 1, 0, duration.getText() );

		WebElement rating = driver.findElement(By.xpath("(//p[starts-with(@class,'cds-119 css-11uuo4b ')])[1]"));
		System.out.println("course rating :"+rating.getText());
		excel.setCellData("Sheet2", 2, 0, rating.getText() );

		System.out.println('\n');

		path=baseDriver.screenShot("Course_1", driver);
		 
	}

	@Test(priority = 5,groups = { "regression" })
	public void course2() throws InterruptedException, IOException {			
		//course 2 details
		WebElement courses2 = driver.findElement(By.xpath("(//h3[starts-with(@class,'cds-CommonCard')])[2]"));
		System.out.println("Second course details :");

		System.out.println("course name :"+courses2.getText());
		excel.setCellData("Sheet3", 0, 0, courses2.getText() );

		WebElement duration1 = driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/main/div[2]/div/div/div/div/div[2]/ul[1]/li[2]/div/div/div/div/div/div[2]/div[3]/div[4]/p"));

		System.out.println("course duration :"+duration1.getText());
		excel.setCellData("Sheet3", 1, 0, duration1.getText() );

		WebElement rating1 = driver.findElement(By.xpath("(//p[starts-with(@class,'cds-119 css-11uuo4b ')])[2]"));
		System.out.println("course rating :"+rating1.getText());
		excel.setCellData("Sheet3", 2, 0, rating1.getText() );

		System.out.println('\n');

		path=baseDriver.screenShot("Course_2", driver);
		 
	}

	@Test(priority = 6,groups = { "regression" })
	public void langlearn() throws InterruptedException, FileNotFoundException, IOException {

		pg2 = new page2(driver);

		WebElement clearr = driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));

		//clicking search bx
		pg2.search1();

		Thread.sleep(3000);

		//action class is used to perform keyboard actions
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		clearr.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);

		String input1 = excel.getCellData("Sheet1", 1, 0);
		pg2.sendKeys(input1);
		pg2.srchclk();

		path=baseDriver.screenShot("Search_2", driver);
	}

	@Test(priority = 7,groups = { "regression" })
	public void langlist() throws InterruptedException, IOException {

		Thread.sleep(5000);
 
		pg2.langclk();
		Thread.sleep(5000);
		//declaring empty array list named langlist
		List<String> langlist = new ArrayList<String>();
		for (int i = 1; i <= 24; i++) {
			//getting all lang and iterating in loop i
			String lang = driver.findElement(By.xpath("//*[@id='checkbox-group']/div[" + i + "]")).getText();
			excel.setCellData("Sheet4", i, 0, lang);
			//printing in console and adding in arraylist
			System.out.println(lang);
			langlist.add(lang);
		}

		System.out.println("Total Language Count :" + langlist.size());
		Thread.sleep(5000);
		//clk close btn
		pg2.closeclk();
		Thread.sleep(2000);
		//sc dwn
		WebElement scrlvl = driver.findElement(By.xpath("//*[contains(text(), 'Level')]"));
		JavascriptExecutor js5=(JavascriptExecutor) driver;
		js5.executeScript("arguments[0].scrollIntoView();", scrlvl);
		Thread.sleep(3000);

		System.out.println('\n');

		path=baseDriver.screenShot("language_list", driver);
	}

	@Test(priority = 8,groups = { "regression" })
	public void levelist() throws InterruptedException, IOException {

		List<String> levelcount = new ArrayList<String>();
		Thread.sleep(6000);

		for (int i = 1; i <= 4; i++) {
			String levelsep = driver.findElement(By.xpath("//div[@data-testid='search-filter-group-Level']//div[@class='css-nsxeb5']["+i+"]")).getText();
			excel.setCellData("Sheet5", i, 0, levelsep);
			System.out.println(levelsep);
			levelcount.add(levelsep);
		}

		System.out.println("Total Level Count :" + levelcount.size());
		Thread.sleep(7000);

		System.out.println('\n');

		path=baseDriver.screenShot("level_list", driver);
	}

	@Test(priority = 9,groups = { "regression" })

	public void homepage() throws InterruptedException, IOException {

		pg3 = new page3(driver);
		//clk home page
		pg3.homepg();
		//scroll last
		WebElement scrlst = driver.findElement(By.xpath("//*[@id='rendered-content']/div/div[1]/footer/div/div/div/div[5]/p"));
		JavascriptExecutor js3=(JavascriptExecutor) driver;
		js3.executeScript("arguments[0].scrollIntoView();", scrlst);
		Thread.sleep(3000);
		
		pg3.entrprise();
		
		pg3.solutionclk();
		Thread.sleep(3000);
		
		pg3.courseraclk();
		//scrl dwn to frm 
		WebElement frmscr = driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/main/div/div[7]/div/div[2]/div/div/div/div/div/div[2]/div[3]"));
		JavascriptExecutor js4=(JavascriptExecutor) driver;
		js4.executeScript("arguments[0].scrollIntoView();", frmscr);
		Thread.sleep(6000);

		path=baseDriver.screenShot("Home", driver);
	}

	@Test(priority = 10,groups = { "regression" })
	public void form() throws InterruptedException, FileNotFoundException, IOException {

		//filling the form using excell 
		String input3  = excel.getCellData("Sheet1", 2, 0);
		pg3.formname().sendKeys(input3);

		String input4 = excel.getCellData("Sheet1", 3, 0);
		pg3.lastname().sendKeys(input4);

		String input5 = excel.getCellData("Sheet1", 4, 0);
		pg3.email().sendKeys(input5);

		String input6 = excel.getCellData("Sheet1", 5, 0);
		pg3.phno().sendKeys(input6);

		pg3.drpinst();

		String input7 = excel.getCellData("Sheet1", 6, 0);
		pg3.sendkunivers().sendKeys(input7);
		Thread.sleep(3000);

		//handling drp dwns using select class
		pg3.drpjob();

		pg3.dept();

		Thread.sleep(3000);
		Select drpdesc = new Select(
				driver.findElement(By.xpath("//*[@id='What_the_lead_asked_for_on_the_website__c']")));
		drpdesc.selectByVisibleText("Tech Support");
		Thread.sleep(4000);

		pg3.drpcountry();

		pg3.drpstate();

		pg3.submit();

		Thread.sleep(4000);

		//atlast prnting error msg

		pg3.errormsg();

		System.out.println("Error msg :"+pg3.errormsg());

		path=baseDriver.screenShot("Form", driver);

	}


}
