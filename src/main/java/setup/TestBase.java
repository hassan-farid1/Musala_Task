package setup;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;



public class TestBase {

	public static WebDriver driver;
	protected  Properties pro;

	@BeforeTest
	
	public void readConfig() throws Exception
	{
		FileConfig pConf = new FileConfig();
		pro = pConf.loadProperites();
	}
	
	@BeforeClass
	public void startDriver() {
		
		String browser = pro.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
		//	WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");  
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")){	
		//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
 
		}
		driver.manage().window().maximize();
		driver.get( pro.getProperty("url"));
		
	}
	
    public static WebDriver getDriverInstance()
    {
    	
		return driver;
    	
    }

	@AfterTest
	public void stopDriver() {
		driver.quit();
	}
	


}
