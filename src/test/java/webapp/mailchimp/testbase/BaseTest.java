package webapp.mailchimp.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static String path = System.getProperty("user.dir");

	//generic configuration page for automation project
	public BaseTest() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(path + "/src/test/resources/general.conf");
		prop.load(ip);
	}

	// initializing the web driver
	public static void browserInitialize() {
		String browserName = prop.getProperty("Browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("fireFox")) {
			System.setProperty("webdriver.gecko.driver", path + "/src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", path + "/src/test/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		// BrowserSetup:
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//Deletes existing csv file and creates a new csv file
	public static FileWriter createCSVFile(String fileName) throws IOException {
		File createFile = new File(fileName);
		if(createFile.exists()){
			createFile.delete();
			try {
				createFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		
		}
		FileWriter fw = new FileWriter(createFile); 
		return fw;
	}
	
	
	//close file
	public static void closeCSVFile(FileWriter fw) throws IOException {
		fw.close();
	}
}
