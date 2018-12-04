package webapp.mailchimp.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import webapp.mailchimp.testbase.BaseTest;
import webapp.mailchimp.utils.WaitHelper;

public class MailChimpAboutPage extends BaseTest {
	public MailChimpAboutPage(WebDriver driver) throws IOException {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Learn more about our leadership team")
	public WebElement learnMoreLeaderShipLink;

	@FindBy(tagName = "article")
	List<WebElement> leadersList;

	By leaderName = By.tagName("h5");
	By leaderPositionAndDescription = By.className("copy");

	
	//clicks on learn more leadership link in about page
	public void clickLearnMoreLeaderShip() throws Exception {
		WaitHelper.waitForVisibilityOfElement(driver, learnMoreLeaderShipLink);
		learnMoreLeaderShipLink.click();
		Reporter.addStepLog("Clicked on Learn More LeaderShip Link");
	}

	//saves leadership info to csv file
	public void saveLeaderShipInformation() throws IOException {
		Iterator<WebElement> leadersListIter = leadersList.iterator();
		FileWriter fw = createCSVFile("leaders_info.csv");
		fw.write("Leader_Name, Leader_Position, Leader_Description" + " \n");
		
		while (leadersListIter.hasNext()) {
			WebElement leadersArticleIterator = leadersListIter.next();

			String leaderNameText = leadersArticleIterator.findElement(leaderName).getText();
			fw.write(String.format("\"%s\" ", leaderNameText));
			List<WebElement> eachLeaderSpeicificInfo = leadersArticleIterator
					.findElements(leaderPositionAndDescription);
			for (WebElement e : eachLeaderSpeicificInfo) {
				fw.write(", ");
				fw.write(String.format("\"%s\" ", e.getText()));
			}
			fw.write(" \n");

		}
		Reporter.addStepLog("MailChimp Leadership information is saved to csv file!");
		closeCSVFile(fw);
	}

}
