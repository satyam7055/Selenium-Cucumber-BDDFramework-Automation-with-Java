package pageObject;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
	
	Actions action=new Actions(driver);

	@FindBy(xpath="//a[text()=' Sign In']")
	WebElement Sign_in;
	
	@FindBy(xpath="//input[@id='userName']")
	WebElement user_name;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pass_word;
	
	//@FindBy(xpath="//input[@type='checkbox']")
	//WebElement check_box;
	
	@FindBy(css="input[id='TermsConditions']")
	WebElement check_box;
	
	@FindBy(css="input[id='submitBtn']")
	WebElement submit_btn;
	
	@FindBy(css="div[id='errorMsg']")
	WebElement error_msg;
	
	@FindBy(css="span[class*='text-u']")
	WebElement user;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signinbutton()
	{
		Sign_in.click();
	}
	
	public void usernameenter(String username)
	{
		user_name.sendKeys(username);
	}
	public void passwordenter(String password)
	{
		pass_word.sendKeys(password);
	}
	
	public void checkbox()
	{
		
		action.moveToElement(pass_word).click().sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
		
		
	}
	public void submitbtn()
	{
		action.scrollToElement(submit_btn).perform();
		submit_btn.click();
	}
	
	public String errormsg()
	{
		String errmsg=error_msg.getText();
		return errmsg;
	}
	
	public String name() 
	{
		String username=user.getText();
		return username;
	}
	

}