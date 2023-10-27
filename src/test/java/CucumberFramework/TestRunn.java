package CucumberFramework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/CucumberFramework",glue="StepDefinition",
monochrome=true,tags="@error",plugin= {"html:target/cucumbers.html"})
public class TestRunn extends AbstractTestNGCucumberTests{
	
	

}
