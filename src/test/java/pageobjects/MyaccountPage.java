package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyaccountPage extends BasePage{
   
	public MyaccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	// Elements
	
	@FindBy(xpath="//a[text()='Account']")WebElement Account_btn;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")WebElement logOut_btn;
	
	//actionMethod
	
	public boolean account_Verify()
	{
		try
		{
		return Account_btn.isDisplayed();
		}
		catch (Exception e)
		{
			return (false);
		}
	   
	}
	public void logout_Click()
	{
		logOut_btn.click();
	}
	
}
