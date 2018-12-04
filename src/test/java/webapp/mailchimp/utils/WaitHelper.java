package webapp.mailchimp.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.Reporter;
public class WaitHelper {
	static ExtentTest test;
	static ExtentReports report;
	
	//waits for visibity of an element
	public static void waitForVisibilityOfElement(WebDriver driver, WebElement element) throws Exception {
		try {
	
			Reporter.addStepLog( "Waiting for the element to be present");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Reporter.addStepLog("Exception in Class Utils | Method waitForElement");
			Reporter.addStepLog("Issue in waiting for the element");
			throw e;
		}
	}
}
