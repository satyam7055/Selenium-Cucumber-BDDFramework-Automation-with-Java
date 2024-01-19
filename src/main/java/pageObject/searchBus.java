package pageObject;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class searchBus extends TestBase {
	
	Actions action=new Actions(driver);
	
	@FindBy(css="input[id='fromPlaceName']")
	WebElement leave;
	
	@FindBy(xpath ="//ul[contains(@class,'ui-autocomplete')]//li")
	List<WebElement> drop_down;
	
	
	@FindBy(css ="input[id='toPlaceName']")
	WebElement going_to;
	
	@FindBy(xpath="//ul[@id='ui-id-2'] //li")
	List<WebElement> going_dropdown;
	
	@FindBy(xpath = "//ul[@id='ui-id-2'] //a[contains(text(),'BELGAUM')]")
	WebElement goingcity;
	
	@FindBy(xpath = "//input[@value='Date Of Departure']")
	WebElement date_of_dept;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar'] //tr[5] //td[2]")
	WebElement select_date_of_dept;
	
	@FindBy(xpath = "//input[@value='Date Of Return']")
	WebElement date_of_arrive;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar'] //tr[5] //td[3]")
	WebElement select_date_of_arrive;
	
	@FindBy(xpath = "//button[contains(text(),'Search for Bus')]")
	WebElement search;
	
	
	
	public searchBus()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void leavefrom(String name)
	{
		action.moveToElement(leave).perform();
		leave.sendKeys(name);
		//Sign_in.click();
		
	}
	
	public void goingto(String name) {
		going_to.sendKeys(name);
		
	}
	
	public void dropdownselect(String name)
	{
		//System.out.print(name);
		
		for(WebElement ele:drop_down)
		{
			String curroption=ele.getText();
			//System.out.print(curroption);
			
			if(curroption.contains(name))
			{
				ele.click();
				break;
			}
		}
	}
	
	public void goingcityselect() {
		goingcity.click();
		
	}
	public void goingdropdown(String name) {
		
		for(WebElement ele:going_dropdown)
		{
			String curroption=ele.getText();
			

			if(curroption.contains(name))
			{ 
				//new WebDriverWait(driver, Duration.ofSeconds(10000)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(ele));
			       ele.click();
					break;
			        
			}
		}
		
	}
	
	public void dateofdeptclick() {
		
		date_of_dept.click();
		
	}
	
	public void selectdateofdept() {
		select_date_of_dept.click();
		
	}
	
     public void dateofarriveclick() {
		
		date_of_arrive.click();
		
	}
	
	public void selectdateofarrive() {


		select_date_of_arrive.click();;
		
	}  
	
	public void clicksearch() {
		search.click();
		
	}
	

}
