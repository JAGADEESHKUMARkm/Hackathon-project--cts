package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class page2 extends basePage {
	WebDriver driver;
	
	public page2(WebDriver driver) {	
		 super(driver);
	    }

	    @FindBy(xpath=("//input[@placeholder='What do you want to learn?']"))
	    WebElement srcclk;
	    @FindBy(xpath="//input[@placeholder='What do you want to learn?']")
	    WebElement sndlang;
	    @FindBy(xpath="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']//*[name()='svg']")
	    WebElement srclk1;
	    @FindBy(xpath="//button[@aria-label='Show more Language options']")
	    WebElement lngclk;
	    @FindBy(xpath="/html/body/div[7]/div[3]/div/div/div[2]/div[3]/button[1]/span")
	    WebElement clsclk;
	     
	    public void search1() {
	    	srcclk.click();
	    }
	   public WebElement sndklang() {
		return sndklang();  
	   }    
	   public void srchclk() {
		   srclk1.click();
	   }
	   
	   public void langclk() {
		   lngclk.click();
	   }
	  
	   public void closeclk() {
		   clsclk.click();
	   }

	   public void sendKeys(String input1) {
			sndlang.sendKeys(input1);					
		}
}
