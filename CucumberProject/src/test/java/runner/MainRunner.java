package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
	features = {"./src/main/resources/tags.feature"},
	glue = {"stepDefinitionFiles"},
	monochrome = true,
	plugin = {"pretty", "html:target/cucumber", 
			"json:target/cucumber.json", 
			"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"
	},
	dryRun=false,
	strict=false,
	tags={"@SanityTest"} // execute only Sanity Tests
	//tags={"@SanityTest, @RegressionTest"} // execute only scenarios which are comes under sanity OR regression
	//tags={"@RegressionTest","@End2End"} //execute scenarios comes under both Regressions and End2End
	//tags={"@SanityTest","@End2End"} //execute scenarios comes under both Sanity and End2End
	//tags={"~@End2End"}   // This will ignore End2End scenarios
	//tags={"~@End2End","~@SanityTest"} // This will ignore Sanity & End2End
)

public class MainRunner {
}
