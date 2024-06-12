package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class page3 extends basePage {
	WebDriver driver;
	
	 public page3(WebDriver driver) {
		 super(driver);
	    }

	    @FindBy(xpath="//div[@class='css-19qryfx']//img[@alt='Coursera']")
	    WebElement hmpg;
	    @FindBy(xpath="//*[@id='rendered-content']/div/div[1]/footer/div/div/div/div[5]/ul/li[10]/a")
	    WebElement entp;
	    @FindBy(xpath="//*[@id='rendered-content']/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[2]/a")
	    WebElement sln;
	    @FindBy(xpath="//p[normalize-space()='Coursera for Campus']")
	    WebElement crsera;
	    @FindBy(xpath="//*[@id='FirstName']")
	    WebElement frmname;
	    @FindBy(xpath="//input[@id='LastName']")
	    WebElement frmlname;
	    @FindBy(xpath="//input[@id='Email']")
	    WebElement mail;
	    @FindBy(xpath="//input[@id='Phone']")
	    WebElement no;
	    @FindBy(xpath=("//*[@id='Institution_Type__c']"))
	    WebElement institu;
	    @FindBy(xpath="//*[@id='Company']")
	    WebElement uni;
	    @FindBy(xpath="//*[@id='Title']")
	    WebElement job;
	    @FindBy(xpath="//*[@id='Department']")
	    WebElement depart;
	    @FindBy(xpath="//*[@id='What_the_lead_asked_for_on_the_website__c']")
	    WebElement descrip;
	    @FindBy(xpath="//*[@id='Country']")
	    WebElement cntry;
	    @FindBy(xpath="//select[@id='State']")
	    WebElement stat;
	    @FindBy(xpath="//*[@id='mktoForm_1512']/div[50]/span")
	    WebElement sumit;
	    @FindBy(xpath="//*[@id='ValidMsgEmail']")
	    WebElement errmsg;
	    
	  
	    public void homepg() {
	 	   hmpg.click();
	    }
	    public void entrprise() {
	 	   entp.click();
	    }
	     public void solutionclk() {
	     	sln.click();
	     }
	     public void courseraclk() {
	     	crsera.click();
	     }	     
	     public WebElement formname() {
			return frmname;
	     }
	     public WebElement lastname() {
			return frmlname;
	     }
	     
	     public WebElement email() {
			return mail;
	     }
	     public WebElement phno() {
			return no;
	     }
	     public void drpinst () {
	     	Select dropdown = new Select(institu);  
	 		dropdown.selectByIndex(5);  
	     }
	     public WebElement sendkunivers() {
			return uni;
	     }
	     public void drpjob() {
	     	Select dropdown2 = new Select(job);  
	 		dropdown2.selectByIndex(12);  
	     }
	     public void dept() {
	     	Select dropdown3 = new Select(depart);  
	 		dropdown3.selectByIndex(10);
	     }
	     public void drpcountry() {
	     	Select dropdown5 = new Select(cntry);  
	 		dropdown5.selectByValue("India");
	     }
	     public void drpstate() {
	    	 Select dropdown6 = new Select(stat);
	    	 dropdown6.selectByValue("Tamil Nadu");
	     }
	     public void submit() {
	     	sumit.click();
	     }	    
	     public String errormsg() {
	     	return errmsg.getText();
	     }    
	 }

