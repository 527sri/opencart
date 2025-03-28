package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
public WebDriver driver;
public Logger logger;
public Properties p;

@BeforeClass(groups= {"regression","sanity","master"})
@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException
	{
	logger=LogManager.getLogger(this.getClass());
	FileReader file=new FileReader(".//src/test/resources/config.properties");
	p=new Properties();
	p.load(file);
	switch(br.toLowerCase())
	{
	case "chrome":driver=new ChromeDriver();break;
	case "firefox" : driver=new FirefoxDriver();break;
	default: System.out.println("No Matching browser");
	return;
	}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url=p.getProperty("appURL");
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"regression","sanity","master"})
	public void tearDown()
	{
		driver.quit();
	}
	public String randomName()
	{
		return RandomStringUtils.randomAlphabetic(5);
	}
	public String randomeNumber()
	{
	String generatedString=RandomStringUtils.randomNumeric(10);
	return generatedString;
}

public String randomAlphaNumeric()
{
	String str=RandomStringUtils.randomAlphabetic(3);
	String num=RandomStringUtils.randomNumeric(3);
	
	return (str+"@"+num);
}
public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
		
	return targetFilePath;

}
}
