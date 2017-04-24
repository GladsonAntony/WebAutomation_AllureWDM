/**
 * 
 */
package controllers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.automation.remarks.video.enums.RecorderType;
import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;

/**
 * @Author Gladson Antony
 * @Date 08-Feb-2017
 */
public class WebDriverFactory extends BrowserFactory
{
	public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();
	public static String browser;
	public static String url;

	@Parameters({ "browser" , "url" })
	@BeforeTest(alwaysRun=true)
	public void suiteSetup(String browser, String url) throws Exception
	{
		WebDriverFactory.browser = browser;
		WebDriverFactory.url=url;
		switch(browser.toLowerCase())
		{
		case "chrome":
			ChromeDriverManager.getInstance().setup();
			break;

		case  "firefox":
			FirefoxDriverManager.getInstance().setup();
			break;

		case  "ie":
			InternetExplorerDriverManager.getInstance().setup();
			break;	

		case  "edge":
			EdgeDriverManager.getInstance().setup();
			break;

		case  "opera":
			ChromeDriverManager.getInstance().setup();
			break;

		case "ghost":
		case "phantom":
			PhantomJsDriverManager.getInstance().setup();
			break;

		default:
			throw new Exception("Please Provide a Valid Browser");
		}
	}

	@BeforeMethod
	public void beforeMethod() throws Exception
	{		
		InitMethod.Browser=browser;
		InitMethod.WebsiteURL=url;
		System.out.println("Browser: "+browser);
		System.out.println("WebsiteURL: "+url);
		new WebDriverFactory();
		WebDriver driver = WebDriverFactory.createDriver(browser,url);
		setWebDriver(driver);

		VideoRecorder.conf()
		.withVideoFolder("./src/test/resources/Videos")         				// Default is ${user.dir}/video.
		.videoEnabled(true)                       										// Disabled video globally
		.withVideoSaveMode(VideoSaveMode.FAILED_ONLY)     		// Save videos for passed and failed tests
		.withRecorderType(RecorderType.MONTE)    						// Monte is Default recorder
		.withRecordMode(RecordingMode.ALL)  ;								// Record video only for tests with @Video
	}

	public void setWebDriver(WebDriver driver) 
	{
		wd.set(driver);
	}

	public static WebDriver getWebDriver() 
	{
		return wd.get();
	}

	@AfterMethod(alwaysRun=true,enabled=true)
	public void afterMethod() throws Exception
	{
		Thread.sleep(2000);
		getWebDriver().quit();	
	}
}
