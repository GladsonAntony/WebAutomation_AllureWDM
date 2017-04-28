/**
 * 
 */
package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.AllureAttachments;
import utils.FluentWaiting;
import utils.RandomGenerator;

/**
 * @author ${Gladson Antony}
 * @date Sep 17, 2016
 * 
 */
public class GoogleHomePageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//a[text()='Gmail']")
	private WebElement GmailLink;

	@FindBy(id="lst-ib")
	private WebElement SearchBox;

	@Step("Click On Gmail Link in the Google Home Page")
	public GoogleHomePageObjects clickonGmailLink() throws Exception
	{
		FluentWaiting.waitUntillElementToBeClickable(5, 500, GmailLink);
		AllureAttachments.saveWebElement(getWebDriver(), GmailLink);
		/*Screenshot screenshot = new AShot().takeScreenshot(getWebDriver(), GmailLink);
		ImageIO.write(screenshot.getImage(), "PNG", new File(TestData + "div_element.png"));	*/
		click(GmailLink);	
		AllureAttachments.attachFileType_XLSX(ExcelFiles + "TestData.xlsx");
		return this;		
	}

	@Step("Enter text into the Search Box")
	public GoogleHomePageObjects enterTextToSearchBox() 
	{
		SearchBox.sendKeys(RandomGenerator.GenerateRandomEMAILIDs("google.com"));
		return this;	
	}

	@Step("Verify the Page Title of the Google Home Page")
	public GoogleHomePageObjects verifyPageTitle() throws Exception 
	{
		FluentWaiting.waitForTitleToBe(5, 500, "Google");
		return this;
	}

}
