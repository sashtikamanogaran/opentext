package testcase;


import org.testng.Assert;
import org.testng.annotations.*;

import pageobjects.*;
import testbase.BaseClass;

public class TC_002_AccountLoginTest extends BaseClass 
{
  
	@Test(priority=1,groups= {"Sanity","Master"})
	public void Login_test()
	{
	try 
	{
		logger.info("*****************Login test started*************************");
		HomePage hp1=new HomePage(driver);
		hp1.clickLogin();
		logger.info("Login button clicked from homepage");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail("S123@gmail.com");
		logger.info("Email value passed");
		lp.setPassword("1234");
		logger.info("Password value passed");
		lp.clickLoginbtn();
		logger.info("Login button clicked");
		
		MyaccountPage ap=new MyaccountPage(driver);
		boolean bol=ap.account_Verify();
		Assert.assertEquals(bol,true,"Account is not Logged in");
		logger.info("Login option working for given testdata");
		
	}
	catch(Exception e)
	{
		e.getMessage();
		logger.info("Login option failed for given testdata");
	}
	logger.info("****************************Login test Completed**************************");
	}
	

}
