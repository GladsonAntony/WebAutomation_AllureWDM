package tests;

import controllers.ExcelDataProvider;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;


public class Test1 extends PageFactoryInitializer
{
	@Description("To verify the working of GMail link from Google Home Page using JavaScript Executor")
	@Test(dataProvider="excelSheetNameAsMethodName",dataProviderClass=ExcelDataProvider.class)
	public void testGoogle(String testCaseID,String emailID,String password) throws Exception
	{
		googleHomePage()
		.verifyPageTitle()
		.clickonGmailLink()
		.gmailPage()
		.enterEmailID(emailID);
	}
}
