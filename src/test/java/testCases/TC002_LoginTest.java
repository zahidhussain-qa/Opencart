package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("*** Starting TC002 LoginTest ***");
		
		try {
		// Home Page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		// Login Page
		LoginPage lg=new LoginPage(driver);
		lg.setEmail(p.getProperty("email"));
		lg.setPassword(p.getProperty("password"));
		lg.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		 boolean targetPage=macc.isMyAccountPageExists();
		 
		 Assert.assertTrue(targetPage); //Assert.assertEquals(targetPage, true, "Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		 logger.info("*** Finished TC002 LoginTest ***");
	}

}
