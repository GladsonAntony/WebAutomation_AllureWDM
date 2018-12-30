package controllers;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @Author Gladson Antony
 * @Date 31-DEC-2018
 */

public class BrowserFactory extends InitMethod
{
	static WebDriver driver;		
	static DesiredCapabilities capabilities;


	static WebDriver createDriver() throws Exception
	{

		switch(Browser.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "chrome_headless":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");  
			chromeOptions.addArguments("--disable-gpu");  
			driver = new ChromeDriver(chromeOptions);
			break;

		case  "firefox":
			driver = new FirefoxDriver();
			break;

		case "firefox_headless":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");
			driver =new FirefoxDriver(firefoxOptions);
			break;

		case  "ie":
		case "internet explorer":
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			break;	

		case  "edge":
			driver = new EdgeDriver();
			break;

		case  "opera":
			OperaOptions operaOptions = new OperaOptions();
			operaOptions.setBinary("C:\\Program Files\\Opera\\57.0.3098.106\\opera.exe");
			driver = new OperaDriver(operaOptions);
			break;

		case "ghost":
		case "phantom":
			driver = new PhantomJSDriver();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.urlContains(WebsiteURL));
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		default:
			throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
		}
		if(ImplicitlyWait > 0)
		{
			implicitlyWait(ImplicitlyWait);
		}

		if(MaxPageLoadTime > 0)
		{
			setMaxPageLoadTime(MaxPageLoadTime);
		}
		driver.get(WebsiteURL);
		if( !Browser.toLowerCase().contains("ghost") || !Browser.toLowerCase().contains("phantom"))
		{
			driver.manage().window().maximize();
		}
		return driver;		
	}

	public static void implicitlyWait(int timeInSeconds) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	public static void setMaxPageLoadTime(int timeInSeconds) throws Exception
	{
		driver.manage().timeouts().pageLoadTimeout(timeInSeconds, TimeUnit.SECONDS);
	}
}
