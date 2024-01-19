package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features= {"src/test/java/resources/featuresfiles/"},
		glue= {"stepdefinitions"},  // Steps file package
		monochrome= true,
		tags = "",
		//plugin = {"pretty","html:target/htmlrepot.html", "json:target/jsonrepot.json"}
		
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
