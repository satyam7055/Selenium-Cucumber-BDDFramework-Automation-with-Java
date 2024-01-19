package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import pageObject.TestBase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;

import Util.TestUtil;


public class LoginStepDefinitions extends TestBase{
	
	private LoginPage login;
	
	
	
	@Given("Navigate to ksrts website")
	public void navigate_to_ksrts_website() {
		initialization();
	 
	}

	@When("I click on sign in button")
	public void i_click_on_sign_in_button() {
		
		login=new LoginPage();
		login.signinbutton();
		
	    
	}
	
	@When("I enter a username & password from datasheet")
	public void i_enter_a_username_password_from_datasheet() {
	    
		Object[][] testData=TestUtil.getTestData("Sheet1");
		 
		for(Object[] data:testData)
		{
			String username=data[0].toString();
			String password=data[1].toString();
			
			login.usernameenter(username);
			login.passwordenter(password);
		}    
	}

	@And("I check term & conditions check box")
	public void i_check_term_conditions_check_box() {
		
		login.checkbox();
	    
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		
		login.submitbtn();
	    
	}

	@Then("I can see user name available on header")
	public void i_can_see_user_name_available_on_header() {
	    //System.out.print(login.name());
		assertEquals(login.name(), "SATYAM KUMAR");
	   
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
