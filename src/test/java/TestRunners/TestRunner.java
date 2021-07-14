package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/massmutual/features"},
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty"}
		)
public class TestRunner {

}
