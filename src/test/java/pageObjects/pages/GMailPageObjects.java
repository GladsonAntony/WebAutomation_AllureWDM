package pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;

/**
 * @Author Gladson Antony
 * @Date 2021-08-09T00:48:22.442Z
 */
public class GMailPageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//input[@type='email']")
	private WebElement emailIDTextBox;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	private WebElement nextButton;

	@Step("To Enter Email ID and Click Next Button")
	public GMailPageObjects enterEmailID(String emailID) 
	{
		emailIDTextBox.sendKeys(emailID);	
		nextButton.click();
		return this;
	}

	@Step("Verify the Page Title of the GMail Page")
	public GMailPageObjects verifyPageTitle() {
		Assert.assertEquals(getWebDriver().getTitle(), "Google");
		return this;
	}
	
	
	
}
