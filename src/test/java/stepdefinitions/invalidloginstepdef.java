package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;

import Util.TestUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.LoginPage;
import pageObject.TestBase;

public class invalidloginstepdef extends TestBase {
	
	LoginPage login=new LoginPage();
	
	@And("I enter a invalid username & password from datasheet")
	public void i_enter_a_invalid_username_password_from_datasheet() {
	  
		Object[][] testData=TestUtil.getTestData("Sheet2");
		 
		for(Object[] data:testData)
		{
			String username=data[0].toString();
			String password=data[1].toString();
			
			login.usernameenter(username);
			login.passwordenter(password);
		}    
	   
	}

	@Then("I can see login incorrect message should be displayed")
	public void i_can_see_login_incorrect_message_should_be_displayed() {
	  
		assertEquals(login.errormsg(),"Login incorrect. Please try again");
	    
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
//		if(scenario.isFailed())
//		{
			final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
	//	}
	}
	
	@After
	public void setdown() {
		driver.quit();
		
	}

}
