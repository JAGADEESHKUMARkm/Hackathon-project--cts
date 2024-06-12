package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.And;
import pageObjects.page3;
import utilities.Excel_utility;

public class Validation2 {
		public WebDriver driver = BaseClass.getDriver();
		public page3 pg3;
	    public Excel_utility excel = new Excel_utility("C:\\Users\\2303984\\eclipse-workspace\\HackathonProject\\src\\test\\java\\utilities\\ExcelData.xlsx");
	
	
	@And("home page")
	public void home_page() throws InterruptedException {
	
		pg3 = new page3(driver);
		
		//pg3.homepg();
		driver.navigate().refresh();
		Thread.sleep(6000);
		WebElement scrlst = driver.findElement(By.xpath("//*[@id='rendered-content']/div/div[1]/footer/div/div/div/div[5]/p"));
		JavascriptExecutor js3=(JavascriptExecutor) driver;
		js3.executeScript("arguments[0].scrollIntoView();", scrlst);
		Thread.sleep(3000);
		
		pg3.entrprise();
	
		pg3.solutionclk();
		Thread.sleep(3000);
		
		pg3.courseraclk();
		
		WebElement frmscr = driver.findElement(By.xpath("//*[@id='rendered-content']/div/div/main/div/div[7]/div/div[2]/div/div/div/div/div/div[2]/div[3]"));
		JavascriptExecutor js4=(JavascriptExecutor) driver;
		js4.executeScript("arguments[0].scrollIntoView();", frmscr);
		Thread.sleep(6000);
		
		
	}

	@And("Filling the form")
	public void filling_the_form() throws InterruptedException, FileNotFoundException, IOException {

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
		pg3.errormsg();
		
		System.out.println("Error msg :"+pg3.errormsg());
		
		

	}

	
	
	
	
	
	
	
}
