package pageObjects.initializePageObjects;

import controllers.BaseMethod;
import org.openqa.selenium.support.PageFactory;
import pageObjects.pages.GMailPageObjects;
import pageObjects.pages.GoogleHomePageObjects;

/**
 * @Author Gladson Antony
 * @Date 2021-08-09T00:47:31.266Z
 */

public class PageFactoryInitializer extends BaseMethod {
    public GoogleHomePageObjects googleHomePage() {
        return PageFactory.initElements(getWebDriver(), GoogleHomePageObjects.class);
    }

    public GMailPageObjects gmailPage() {
        return PageFactory.initElements(getWebDriver(), GMailPageObjects.class);
    }


}
