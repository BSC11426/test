package com.sps.preprodbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import org.sikuli.script.App;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen; 


public class SpsService {

	public static  WebDriver driver;
	public static Properties CONFIG = null;
	public static Properties LOC = null;
	
      @BeforeSuite
	  public static void Initialise() throws IOException {
    	 
   // 	    Screen s=new Screen();
       
		 
    	  System.out.println("inside intalise");
		  // Loading and Creating object of Config Property File 
		  if(driver == null)
		  {
			  //Change it to class path
		  File propfile = new File("C:/Users/vinay.korasika/workspace/spsAutomation/src/main/resources/com/sps/preprod/Config.properties");
		  
		  CONFIG = new Properties();
		  CONFIG.load(new FileInputStream(propfile));
		  
		  
		 // Loading and Creating object of Locators Property File
		  File locfile = new File("C:/Users/vinay.korasika/workspace/spsAutomation/src/main/resources/com/sps/preprod/locators.properties");
		  LOC= new Properties();
		  LOC.load(new FileInputStream(locfile));

		  System.out.println(driver);
		  // Initializating object of Firefox Driver 
		  
	System.out.println(CONFIG.getProperty("browser").equals("Firefox"));
	if (CONFIG.getProperty("browser").equals("Firefox")){
			  
		 System.out.println("vinay");
            
           //System.setProperty("webdriver.gecko.driver","C:\\Users\vinay.korasika\Downloads\Firefox Setup 46.0.exe");
		                                                 // C:/Users/vinay.korasika/Downloads/Firefox Setup 46.0.exe
		/*FirefoxProfile myprofile=new FirefoxProfile(new File("C:/Users/vinay.korasika/Downloads"));
	
	
	    String profileName="";
		 driver = new FirefoxDriver(myprofile);
            
		 
		 System.out.println(driver);*/
		 
		// FirefoxProfileManager profileManager = new FirefoxProfileManager();
		 //FirefoxProfile profile = profileManager.GetProfile(profileName);
		 driver = new FirefoxDriver();
			 
		
		  }
		  }
	 }
	
	public static WebElement getObjectbyId(String key) throws Exception
	  {
		   return driver.findElement(By.id(LOC.getProperty(key)));
	  }
	  
	  
	  public static WebElement getObjectbyname(String name) throws Exception
	  {
		   return driver.findElement(By.name(LOC.getProperty(name)));
	  }
	  
	  
	  public static WebElement getObjectbyxpath(String xpathkey) throws Exception
	  {
		   return driver.findElement(By.xpath(LOC.getProperty(xpathkey)));
	  }
	  
	  public static WebElement getObjectbyCss(String cssKey) throws Exception
	  {
		   return driver.findElement(By.cssSelector(LOC.getProperty(cssKey)));
	  }
	  
	  
	  public static WebElement getObjectbyLink(String linkname) throws Exception
	  {
		   return driver.findElement(By.linkText(LOC.getProperty(linkname)));
	  }
	  
	  public static WebElement getObjectbyClassName(String classname) throws Exception
	  {
		   return driver.findElement(By.className(LOC.getProperty(classname)));
	  }
	  public static void mouseover(WebElement ex)
	  {
	  Actions action = new Actions(driver);
	 // WebElement we = webdriver.findElement(By.xpath("//html/body/div[13]/ul/li[4]/a"));
	  action.moveToElement(ex).build().perform();
	  }

	  @AfterSuite
	  public void close() throws Exception {
		  driver.quit();
		  
		  
		 // AppUtil.logout();

		 
	  }

}
