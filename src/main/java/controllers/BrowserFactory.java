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
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

/**Ō
 * @Author Gladson Antony
 * @Date 2021-08-09T00:16:38.728Z
 */

public class BrowserFactory extends InitMethod {
    static WebDriver driver;
    static DesiredCapabilities capabilities;


    static WebDriver createDriver() {

        switch (Browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "chrome_headless":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "firefox_headless":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "ie":
            case "internet explorer":
                driver = new InternetExplorerDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "opera":
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.setBinary("C:\\Program Files\\Opera\\77.0.4054.277\\opera.exe");
                driver = new OperaDriver(operaOptions);
                break;

            default:
                throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
        }
        if (ImplicitlyWait > 0) {
            implicitlyWait(ImplicitlyWait);
        }

        if (MaxPageLoadTime > 0) {
            setMaxPageLoadTime(MaxPageLoadTime);
        }
        driver.get(WebsiteURL);
        if (!Browser.toLowerCase().contains("ghost") || !Browser.toLowerCase().contains("phantom")) {
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void implicitlyWait(int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    public static void setMaxPageLoadTime(int timeInSeconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeInSeconds));
    }
}
