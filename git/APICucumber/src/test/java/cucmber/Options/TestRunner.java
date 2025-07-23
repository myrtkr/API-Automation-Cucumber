package cucmber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java",glue= "stepDefinition",tags= ("@AddPlace"),
plugin= {"json:target/jsonReports/cucumber-report.json", "json:target/cucumber-logs/log.txt"})
public class TestRunner {
	
	
	
}


