package webapp.mailchimp.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "/webapp/src/test/java/webapp/mailchimp/feature/"
,glue= {"webapp.mailchimp.steps"},
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true
)

//junit runner class, generates extent reports in html format
public class Runner {
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("/webapp/src/test/resources/report_config/reportconfig.xml"));
    
    }
}