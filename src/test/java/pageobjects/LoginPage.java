package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
  //ELEMENTS
	@FindBy(xpath="//input[@name='email']")WebElement email_text;
	@FindBy(xpath="//input[@name='password']")WebElement password_text;
	@FindBy(xpath="//button[@type='submit']")WebElement login_btn;
	
	//Action methods
	
	public void setEmail(String em)
	{
		email_text.sendKeys(em);
	}
	public void setPassword(String pw)
	{
		password_text.sendKeys(pw);
	}
	public void clickLoginbtn()
	{
		login_btn.click();
	}
	
	
	
	
	
}
