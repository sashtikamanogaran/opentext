package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	// elements
	
	// MYACCOUNT
	@FindBy(xpath="//span[text()='My Account']")WebElement myaccount_btn;
	
	// REGiSTER
	@FindBy(linkText="Register")WebElement register_btn;
	
	//LOGiN
	@FindBy(xpath="//a[text()='Login']")WebElement login_btn;
	
	//Action Methods
	public void clickMyAccount()
	{
		myaccount_btn.click();
	}
	
	public void clickRegister()
	{
       register_btn.click();
	}
	public void clickLogin()
	{
		login_btn.click();	}
}
