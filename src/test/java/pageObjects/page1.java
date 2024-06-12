package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class page1 extends basePage {
	WebDriver driver;
	// constructor
	public page1(WebDriver driver) {
		super(driver);
		// super keyword is used to access the data from the parent class which data means
	}

	// WebElement locator + identification
	@FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
	WebElement searching;
	@FindBy(xpath = "//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']//*[name()='svg']")
	WebElement searcbtn;
	
	@FindBy(xpath = "//body/div[@id='rendered-content']/div[@class='rc-MetatagsWrapper']/div[@class='rc-SearchApp']/main[@class='css-19l88ud']/div[@class='css-1oaiq8o']/div[@class='cds-1 css-1cxrrkn cds-2 cds-7']/div[@class='cds-9 css-1kspkkz cds-10']/div[@class='cds-9 css-0 cds-11 cds-grid-item cds-56']/div[@class='cds-9 css-1winmd cds-10']/div[@id='search-results-header-wrapper']/div[@class='cds-9 css-1761wsj']/div[@class='cds-9 css-1cs9i33']/div/div[@class='css-12o3uw8']/div[@role='group']/div[2]/div[1]/label[1]/span[1]/span[1]//*[name()='svg']")
	WebElement langclk;

	@FindBy(xpath = "//input[@id='cds-react-aria-77']")
	WebElement lvl;
	
	 @FindBy(xpath = "//body/div[@id='rendered-content']/div[@class='rc-MetatagsWrapper']/div[@class='rc-SearchApp']/main[@class='css-19l88ud']/div[@class='css-1oaiq8o']/div[@class='cds-1 css-1cxrrkn cds-2 cds-7']/div[@class='cds-9 css-1kspkkz cds-10']/div[@class='cds-9 css-0 cds-11 cds-grid-item cds-56']/div[@class='cds-9 css-1winmd cds-10']/div[@class='cds-9 css-0 cds-11 cds-grid-item cds-56 cds-81']/ul[@class='cds-9 css-5t8l4v cds-10']/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement crs1clk;
	@FindBy(xpath = "//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/h1")
	WebElement crs1n;
	@FindBy(xpath = "//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]")
	WebElement crs1D;
	@FindBy(xpath = "//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]")
	WebElement crs1r;
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement crs2clk;
	@FindBy(xpath = "//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/h1")
	WebElement crs2n;
	@FindBy(xpath = "//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]")
	WebElement crs2r;
	@FindBy(xpath = "//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]")
	WebElement crs2D;

	// Action
	public void clk(){
		searching.click();
	}
//	public void search() {
//		searching.click();	
//	}
	public void searchbtn() {
		searcbtn.click();
	}
	public void langclick() {
		langclk.click();
	}
	public void lvlclk() {
		lvl.click();
	}
	public void course1clk() {	
		crs1clk.click();
	}
	public String course1name() {
		return crs1n.getText();
	}
	public String course1duration() {
		return crs1D.getText();
	}
	public String course1rating() {
		return crs1r.getText();
	}
	public void course2clk() {
		crs2clk.click();
	}
	public String course2name() {
		return crs2n.getText();
	}
	public String course2rating() {
		return crs2r.getText();
	}
	public String course2duration() {
		return crs2D.getText();
	}
//	public void sendInput(String input) {
//		searching.sendKeys(input);	
//	}
	public WebElement sendInput() {
		return searching;
	}

}