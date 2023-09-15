package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccount extends BasePage{
	
	public RegisterAccount(WebDriver driver)
	{
		super(driver);
	}
  
  //Elements
	
	@FindBy(xpath="//input[@name='firstname']") WebElement firstname_input;
	@FindBy(xpath="//input[@name='lastname']")WebElement lastname_input;
	@FindBy(xpath="//input[@name='email']")WebElement email_input;
	@FindBy(xpath="//input[@name='password']")WebElement password_input;
	@FindBy(xpath="//input[@name='agree']")WebElement agree_btn ;
	@FindBy(xpath="//button[@type='submit']")WebElement submit_btn;
	@FindBy(xpath="//h1")WebElement successmsg;
	
	//ActionMethods
	public void setfirstNameinput(String fn)
	{
		firstname_input.sendKeys(fn);
	}
	public void setlastNameinput(String ln)
	{
		lastname_input.sendKeys(ln);
	}
	public void setEmailinput(String em)
	{
		email_input.sendKeys(em);
	}
	public void setPassordinput(String pw)
	{
		password_input.sendKeys(pw);
	}
	public void clickAgree()
	{
		agree_btn.click();
	}
	public void clickSubmit()
	{
		submit_btn.click();
	}
	public String getSuccessmsg()
	{
		try
		{
			return (successmsg.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	
	
	
			
}
