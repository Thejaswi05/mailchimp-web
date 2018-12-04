package webapp.mailchimp.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import webapp.mailchimp.testbase.BaseTest;
import webapp.mailchimp.utils.WaitHelper;

public class MailChimpHomePage extends BaseTest {

	public MailChimpHomePage(WebDriver driver) throws IOException {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Our Story")
	public WebElement ourStoryLink;

	@FindBy(linkText = "Log In")
	public WebElement loginLink;

	//navigates to about page(our story page) from home page
	public void navigateToStoryPage() throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(ourStoryLink).click().build().perform();
		Thread.sleep(3000);
		WaitHelper.waitForVisibilityOfElement(driver, ourStoryLink);
		ourStoryLink.click();
		Reporter.addStepLog("Clicked on Our Story Link");
	}

}
