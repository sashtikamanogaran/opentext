package testcase;

import org.testng.annotations.*;
import org.testng.Assert;
import pageobjects.*;
import testbase.*;
public class TC_001_AccountRegistrationTest extends BaseClass {
  
  @Test(priority=1,groups= {"Regression","Master"})
  void test_account_registration()
  {
	  
	  logger.debug("Application logs------------------------------");
	  logger.info("*************TC1 - AccountRegistrationtest STARTED - *********************");
	  try
	  {
	 
	  HomePage hp = new HomePage(driver);
	  hp.clickMyAccount();
	  logger.info("CLiCKED ON MY ACCOUNT");
	  hp.clickRegister();
	  logger.info("Clicked on register button");
	  RegisterAccount ra=new RegisterAccount(driver);
	  logger.info("Providing user related details");
	  ra.setfirstNameinput("sash");
	  logger.info(" FiRST name entered successfullly");
	  ra.setlastNameinput("dhars");
	  logger.info("LAST name entered successfullly");
	  
	  String em=randomString();
	  ra.setEmailinput(em+"@gmail.com");
	  logger.info("EMAiL entered successfully");
	  ra.setPassordinput(alphanumberic());
	  logger.info("PASSWORD entered successfully");
	  ra.clickAgree();
	  ra.clickSubmit();
	  
	  Assert.assertEquals(ra.getSuccessmsg(),"Your Account Has Been Created!","Account is not created");
	  }
	  catch(Exception e)
	  {
		  logger.error("************************TC-1 Test failed***********************");
		  Assert.fail(); 
		  
	  }
	  
	  }
	  
	
	  
  }

