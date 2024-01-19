package pageObject;

import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Util.TestUtil;
import io.cucumber.java.After;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	protected ExtentReports extent;
	protected ExtentTest test;
	
	
	
	public TestBase(){
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(fis);	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
		//return driver;
	}
	

}
