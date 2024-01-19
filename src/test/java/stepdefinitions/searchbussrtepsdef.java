package stepdefinitions;





import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.TestBase;
import pageObject.searchBus;

public class searchbussrtepsdef extends TestBase{
	
	private searchBus searchbus;
	
	
	
	@When("I enter {string} in leaving from search bar")
	public void i_enter_in_leaving_from_search_bar(String string) {
	    // Write code here that turns the phrase above into concrete actions
		searchbus=new searchBus();
	    searchbus.leavefrom(string);
	    
	}
	
	@When("I select {string} from dropdown opend leave city")
	public void i_select_from_dropdown_opend_leave_city(String string) {
	    // Write code here that turns the phrase above into concrete actions
		searchbus.dropdownselect(string);
		
	}

	@Then("I enter {string} in going to search bar")
	public void i_enter_in_going_to_search_bar(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   searchbus.goingto(string);
	}
	
	@Then("I select {string} from dropdown opend for going city")
	public void i_select_from_dropdown_opend_for_going_city(String string) {
	    // Write code here that turns the phrase above into concrete actions
		//earchbus.goingdropdown(string);
		searchbus.goingcityselect();
	}
	
	@Then("I click on date of departure")
	public void i_click_on_date_of_departure() {
	    // Write code here that turns the phrase above into concrete actions
	    searchbus.dateofdeptclick();
	}

	@And("I select a specific date of departure")
	public void i_select_a_specific_date_of_departure() {
	    // Write code here that turns the phrase above into concrete actions
		searchbus.selectdateofdept();
	}

	@Then("I click on date of return")
	public void i_click_on_date_of_return() {
	    // Write code here that turns the phrase above into concrete actions
	    searchbus.dateofarriveclick();
	    
	}
	
	@And("I select a specific date of return")
	public void i_select_a_specific_date_of_return() {
	    // Write code here that turns the phrase above into concrete actions
	    searchbus.selectdateofarrive();
	}

	@When("I click on search for bus")
	public void i_click_on_search_for_bus() {
	    // Write code here that turns the phrase above into concrete actions
	    searchbus.clicksearch();
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
