package controllers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Author Gladson Antony
 * @Date 08-Feb-2017
 */

public class BrowserFactory extends InitMethod
{
	@SuppressWarnings("deprecation")
	static WebDriver createDriver(String browser, String url) throws Exception
	{
		WebDriver driver;

		DesiredCapabilities capabilities;
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			break;

		case  "firefox":
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			break;

		case  "ie":
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver = new InternetExplorerDriver(ieCapabilities);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(url);
			break;	

		case  "edge":
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			break;

		case  "unit":
			driver = new HtmlUnitDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			break;

		case  "opera":
			capabilities = DesiredCapabilities.opera();
			ChromeOptions optionsOpera = new ChromeOptions();
			optionsOpera.setBinary("C:/Program Files/Opera/launcher.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY, optionsOpera);
			driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			break;
			
		case "ghost":
		case "phantom":
			driver = new PhantomJSDriver();
			driver.get(url);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.urlContains(url));
			break;

		default:
			throw new Exception("Please Provide a Valid Browser");
		}
		return driver;		
	}
}
