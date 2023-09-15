package testbase;

import java.time.Duration;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import java.util.*;
//import java.util.ResourceBundle;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
    public static WebDriver driver;
    public Logger logger; // declare logger
   // public ResourceBundle rb;
    @BeforeClass(groups= {"Master","Sanity","Regression"})
    @Parameters({"browser"})
	public void setup(String br) {
    	
    	logger=LogManager.getLogger(this.getClass()); 
    	// rb=ResourceBundle.getBundle("config");// intialize logger
    	if (br.equals("chrome"))
    	{
    	ChromeOptions op=new ChromeOptions();
    	op.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		 driver= new ChromeDriver(op);
    	}
    	else if(br.equals("edge"))
    	{
    	EdgeOptions eo=new EdgeOptions();
    	eo.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		  driver= new EdgeDriver(eo);
    	}  
    	else
    	{
    		driver=new FirefoxDriver();
        }
		  
    	driver.manage().deleteAllCookies();
		  driver.get("https://demo.opencart.com/index.php?route=common/home&language=en-gb");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
    
    @AfterClass(groups= {"Regression","Sanity","Master"})
	public void closeapp()
	{
		driver.close();
	}
    
    public String randomString()
    {
    	String gs1=RandomStringUtils.randomAlphabetic(5);
    	return gs1;
    }
    public String randomNumber()
    {
    	String gs2=RandomStringUtils.randomNumeric(10);
    	return gs2;
    }
    public String alphanumberic()
    {
    	String gs3=RandomStringUtils.randomAlphabetic(2);
    	String gs4=RandomStringUtils.randomNumeric(2);
    	return(gs3+"@"+gs4);
    }
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
}
