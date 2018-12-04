package webapp.mailchimp.steps;

import java.io.IOException;

import com.cucumber.listener.Reporter;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webapp.mailchimp.pages.MailChimpAboutPage;
import webapp.mailchimp.pages.MailChimpHomePage;
import webapp.mailchimp.testbase.BaseTest;

public class LearnLeaderShipTeamSteps extends BaseTest {

	MailChimpHomePage MailChimpHomePage;
	MailChimpAboutPage MailChimpAboutPage;
	public LearnLeaderShipTeamSteps() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("^I launch browser$")
	public void i_launch_browser() throws Throwable {
		browserInitialize();
	}

	@Then("^I open MailChimp WebPage$")
	public void i_open_MailChimp_WebPage() throws Throwable {
		driver.get(prop.getProperty("URL"));
		Reporter.addStepLog("Opened Mailchimp homepage!");
	}

	@Then("^I navigate to About Page$")
	public void i_navigate_to_About_Page() throws Exception {
		MailChimpHomePage = new MailChimpHomePage(driver);
		MailChimpHomePage.navigateToStoryPage();
	}
	
	@Then("^I click on learnmore leadership team link$")
	public void i_click_on_learnmore_leadership_team_link() throws Exception {
	  MailChimpAboutPage = new MailChimpAboutPage(driver);
	  MailChimpAboutPage.clickLearnMoreLeaderShip();
	}
	
	@Then("^I save leadership team info to a csv file$")
	public void i_save_leadership_team_info_to_a_csv_file() throws Exception {
		  MailChimpAboutPage = new MailChimpAboutPage(driver);
		  MailChimpAboutPage.saveLeaderShipInformation();
	}

	
}
