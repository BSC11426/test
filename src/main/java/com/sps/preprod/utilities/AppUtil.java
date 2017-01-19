package com.sps.preprod.utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sps.preprodbase.SpsService;



public class AppUtil extends SpsService {
	
	public static String url = null;
	public static File configFile=null;
	//static File DestFile = new File("C://Users/xsat741/Desktop/screenshots");
	
	
	/*public void loadclass() 
	{

	   String Filepath="SetupData.xlsx";
	   ClassLoader classLoader = this.getClass().getClassLoader();
	   configFile=new File(classLoader.getResource(Filepath).getFile());
	
	}
*/	
	public static  void login(String username, String passwd) {

		try {

			url = CONFIG.getProperty("TTURL");
			String TT_Usrid=CONFIG.getProperty("TT_usrname");
			String TT_pswd=CONFIG.getProperty("TT_pwd");
			
			System.out.println(url);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			

			WebElement loginname = getObjectbyxpath("TTuser_id");
			WebElement pass = getObjectbyxpath("TTpwd_id");
			WebElement loginbutton = getObjectbyxpath("TTlogin_button");
			Thread.sleep(500);

			// Enter Login Name
			//loginname.click();
			loginname.sendKeys(TT_Usrid);

			// Enter Passwd
			//pass.click();
			pass.sendKeys(TT_pswd);

			// Click on Login Button
			loginbutton.click();

			Thread.sleep(1000);
			
			getObjectbyxpath("TTUtil").click();
			
			//Thread.sleep(10000);
			
			(new WebDriverWait(driver, 100000)) .until(ExpectedConditions.presenceOfElementLocated((By) getObjectbyxpath("TTCompanysname")));

			boolean t=getObjectbyxpath("TTCompanysname2").isDisplayed();
			System.out.println(t);
			Thread.sleep(1000);
			getObjectbyxpath("TTCompanysugesstion").click();
			
			
		    	//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	

}
