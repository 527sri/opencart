package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	@Test(groups= {"sanity","master"})
	void test_LoginTest()
	{
		try
		{
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		hp.clickMyAccount();
		//String emails=p.getProperty("email");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		 MyAccountPage macc=new MyAccountPage(driver);
		 boolean targetPage=macc.isMyAccountPageExists();
			
			Assert.assertEquals(targetPage, true,"Login failed");

	}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	
	

}
