package stepDefinition;

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

import identifyCourses.baseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.page1;
import pageObjects.page2;
import pageObjects.page3;
import utilities.Excel_utility;

public class Validation {
	public WebDriver driver = BaseClass.getDriver();
	page1 pg1;
    page2 pg2;
    public page3 pg3;
    public Excel_utility excel = new Excel_utility("C:\\Users\\2303984\\eclipse-workspace\\HackathonProject\\src\\test\\java\\utilities\\ExcelData.xlsx");

	@Given("search functionality")
	public void search_functionality() throws InterruptedException, FileNotFoundException, IOException {

		pg1 = new page1(driver);
		
		//stale exception the element in dom is no longer present so we refresh the page
		driver.navigate().refresh();
		Thread.sleep(6000);
		//clicking the search placeholder
		pg1.clk();

		//sending the input through excell row 0, column 0
		//class.methodname,row,column taking or getting data from sheet 
		String input = excel.getCellData("Sheet1", 0, 0);
		pg1.sendInput().sendKeys(input);

		//clicking search btn
		pg1.searchbtn();

		//takes screenshot path is declared up and basedriver which has screenshot code and screenShot method, name to img

	}

	@Then("filter functionality")
	public void filter_functionality() throws InterruptedException {

		Thread.sleep(5000);
		// moving down to search language
		WebElement scrl = driver.findElement(By.xpath("//button[@aria-label='Show more Subject options']//span[@class='cds-button-label'][normalize-space()='Show more']"));
		JavascriptExecutor js = (JavascriptExecutor) driver; //typecasting js to driver 
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView();", scrl);
		Thread.sleep(6000);

		//using javscript click and explicit wait here condition visibilty of element to click the checkbox
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor jsw = (JavascriptExecutor)driver; 
		
		WebElement langclk = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1rmmvio']//div[2]//div[1]//label[1]")));
		jsw.executeScript("arguments[0].click();", langclk);
		Thread.sleep(5000);
		//scroll down for level
		WebElement scdwn = driver.findElement(By.xpath("//div[@data-testid='Graduate Certificates-false']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView();", scdwn);
		Thread.sleep(6000);
		
		WebDriverWait mywwait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor jss = (JavascriptExecutor)driver; 
		WebElement lvlclk = mywwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='Beginner-false'] label[class='cds-checkboxAndRadio-label']")));
		jss.executeScript("arguments[0].click();", lvlclk);
		Thread.sleep(5000);

		//scroll up
		WebElement scup = driver.findElement(By.xpath("//h3[normalize-space()='Filter by']"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView();", scup);
		Thread.sleep(6000);

}

	@And("getting course one details")
	public void getting_course_one_details() throws InterruptedException, IOException {
/*
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement c1clk = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cds-react-aria-280-product-card-title']")));
		
		JavascriptExecutor jss = (JavascriptExecutor)driver; 
		jss.executeScript("arguments[0].click();", c1clk);
		
		Set<String> tab1 = driver.getWindowHandles();
		List<String> tab2 = new ArrayList<String>(tab1);
		String tab3 = tab2.get(1);
		driver.switchTo().window(tab3);
		Thread.sleep(4000);

		System.out.println("First course details :");
		
		// getting course details and printing in console as well as sheet
		System.out.println("Course Name :"+pg1.course1name());
		excel.setCellData("Sheet2", 0, 0, pg1.course1name() );

		System.out.println("Course Durtion :"+pg1.course1duration());
		excel.setCellData("Sheet2", 1, 0, pg1.course1duration() );

		System.out.println("Course Rating :"+pg1.course1rating()); 
		excel.setCellData("Sheet2", 2, 0, pg1.course1rating() );

		System.out.println('\n');

		driver.close();
		Thread.sleep(3000);
		Set<String> taab1 = driver.getWindowHandles();
		List<String> taab2 = new ArrayList<String>(taab1);
		String taab3 = taab2.get(0);
		driver.switchTo().window(taab3);
		path=baseDriver.screenShot("Course_1", driver);
*/

			
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

		 
	}

	@And("getting course two details")
	public void getting_course_two_details() throws IOException, InterruptedException {
/*
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor jss = (JavascriptExecutor)driver; 
		WebElement c2clk = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cds-react-aria-214-product-card-title']")));
		jss.executeScript("arguments[0].click();", c2clk);
		
		Set<String> tabb1 = driver.getWindowHandles();
		List<String> tabb2 = new ArrayList<String>(tabb1);
		String tabb3 = tabb2.get(1);
		driver.switchTo().window(tabb3);
		Thread.sleep(4000);

		System.out.println("Second course details :");

		System.out.println("Course Name :"+pg1.course2name());
		excel.setCellData("Sheet3", 0, 0,pg1.course2name());

		System.out.println("Course Durtion :"+ pg1.course2duration());
		excel.setCellData("Sheet3", 1, 0, pg1.course2duration() );

		System.out.println("Course Rating :"+pg1.course2rating()); 
		excel.setCellData("Sheet3", 2, 0,pg1.course2rating());

		System.out.println('\n');

		driver.close();

		Set<String> ttabb1 = driver.getWindowHandles();
		List<String> ttabb2 = new ArrayList<String>(ttabb1);
		String ttabb3 = ttabb2.get(0);
		driver.switchTo().window(ttabb3);
		Thread.sleep(4000);
		path=baseDriver.screenShot("Course_2", driver);
*/
			
		//course 2 details

		WebElement courses2 = driver.findElement(By.xpath("(//h3[starts-with(@class,'cds-CommonCard')])[2]"));

		System.out.println("Second course details :");

		System.out.println("course name :"+courses2.getText());
		excel.setCellData("Sheet3", 0, 0, courses2.getText() );

		WebElement duration1 = driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/main/div[2]/div/div/div/div/div[2]/ul[1]/li[2]/div/div/div/div/div/div[2]/div[3]/div[4]/p"));

		System.out.println("course duration :"+duration1.getText());
		excel.setCellData("Sheet3", 1, 0, duration1.getText() );

		WebElement rating1 = driver.findElement(By.xpath("(//p[starts-with(@class,'cds-119 css-11uuo4b ')])[2]"));
		System.out.println("course rating :"+rating1.getText());
		excel.setCellData("Sheet3", 2, 0, rating1.getText() );

		System.out.println('\n');

		 
	}

	@And("searching new course")
	public void searching_new_course() throws InterruptedException, FileNotFoundException, IOException {

		pg2 = new page2(driver);

		WebElement clearr = driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));

		//clicking search bx
		pg2.search1();

		Thread.sleep(3000);

		//action class is used to perform keyboard actions
		Actions actions = new Actions(driver);
		//keydown is clicking and holding the ctrl key and giving a key to select all in checkbx keyup keyctrl is used to release the key perform executes the action
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		//pressing backspace key
		clearr.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);

		//sending language learning word through sheet
		String input1 = excel.getCellData("Sheet1", 1, 0);
		pg2.sendKeys(input1);
		//clk search btn
		pg2.srchclk();
		
	}

	@And("printing language details")
	public void printing_language_details() throws InterruptedException, IOException {

		Thread.sleep(5000);

		//clk lang btn 
		pg2.langclk();
		Thread.sleep(5000);
		//declaring empty array list named langlist
		List<String> langlist = new ArrayList<String>();
		//it iterates the loop upto 24
		for (int i = 1; i <= 24; i++) {
			//getting all lang and iterating in loop i
			String lang = driver.findElement(By.xpath("//*[@id='checkbox-group']/div[" + i + "]")).getText();
			excel.setCellData("Sheet4", i, 0, lang);
			//printing in console and adding in arraylist
			System.out.println(lang);
			langlist.add(lang);
		}
		//size of lang is printed 
		System.out.println("Total Language Count :" + langlist.size());
		Thread.sleep(5000);
		//clk close btn
		pg2.closeclk();
		Thread.sleep(2000);
		//scroll down to getting the level details
		WebElement scrlvl = driver.findElement(By.xpath("//*[contains(text(), 'Level')]"));
		JavascriptExecutor js5=(JavascriptExecutor) driver;
		js5.executeScript("arguments[0].scrollIntoView();", scrlvl);
		Thread.sleep(3000);

		System.out.println('\n');

	}

	@And("printing the level details")
	public void printing_the_level_details() throws IOException, InterruptedException {

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

	}
}
