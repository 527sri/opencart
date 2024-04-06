package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath ="//span[normalize-space()='My Account']") 
	WebElement lnkMyaccount;
	
	//@FindBy(xpath="//a[normalize-space()='Register']") 
	@FindBy(xpath="//a[text()='Continue']")
	WebElement lnkRegister;

    
    public void clickMyAccount()
    {
    	lnkMyaccount.click();
    }
    
    public void clickRegister()
    {
    	//lnkRegister.click();
    	//JavascriptExecutor js=(JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].click();", lnkRegister);
    	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	mywait.until(ExpectedConditions.elementToBeClickable(lnkRegister)).click();
    	
    }
}
