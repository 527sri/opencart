package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001RegistrationTest extends BaseClass {
	@Test(groups= {"regression","master"})
	void verify_Account_Registration()
	{	  logger.info("Starting TC_001 account registration");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		RegisterPage rp=new RegisterPage(driver);
		rp.setFirstname(randomName().toUpperCase());
		rp.setLastName(randomName().toUpperCase());
		rp.setEmail(randomName().toUpperCase()+"@gmail.com");
		rp.setTelephone(randomeNumber());
		String password=randomAlphaNumeric();
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		rp.setPrivacyPolicy();
		rp.clickContinue();
		String confmsg=rp.getConfirmationMsg();	
		logger.info("validating");
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
  catch(Exception e)
  {
	 
		Assert.fail();
	}
	}
	

}
