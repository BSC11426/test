package com.sps.preprod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.sps.preprodbase.*;
import com.sps.preprod.utilities.*;

public class SpsSetuptest extends AppUtil  {
	
	@Test
	public void beforeClass()
	{
		
		/*String user = CONFIG.getProperty("user_id");
	    String pwd = CONFIG.getProperty("pwd_id");*/
		
	   // System.out.println(user+ pwd);
		AppUtil.login("pnimje","sps_dc4");
		
		
	}
	
	/*@DataProvider
	public object[][]
			{
		
			}*/

}
