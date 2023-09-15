package testcase;

import org.testng.Assert;
import org.testng.annotations.*;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyaccountPage;
import utilities.DataProviderUtility;

import testbase.BaseClass;

public class TC_003_loginDDT extends BaseClass {
  
	@Test(dataProvider="LoginData",dataProviderClass=DataProviderUtility.class)
    public void login_DataDriven(String email,String pw,String exp)
	{
		logger.info("*****************Login test started*************************");
		try
		{
		HomePage hp1=new HomePage(driver);
		hp1.clickLogin();
		logger.info("Login button clicked from homepage");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		logger.info("Email value passed");
		lp.setPassword(pw);
		logger.info("Password value passed");
		lp.clickLoginbtn();
		logger.info("Login button clicked");
		MyaccountPage ap=new MyaccountPage(driver);
		boolean bol=ap.account_Verify();
		
		if(exp.equals("valid") )
		{
			if(bol == true)
			{
				ap.logout_Click();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
		}
		if(exp.equals("invalid"))
		{
			if(bol == false)
			{
				Assert.assertTrue(true);
			}
			else
			{
				ap.logout_Click();
				Assert.fail();
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
	}
}
