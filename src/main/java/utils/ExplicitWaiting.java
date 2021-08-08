package utils;

import controllers.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * @Author Gladson Antony
 * @Date 2021-08-09T00:32:16.768Z
 */

public class ExplicitWaiting extends BaseMethod {

    /*Select using WebElements*/

    /**
     * To Wait Until Element to be Clickable
     */
    public static void explicitWaitElementToBeClickable(WebElement element, int time) {
        WebDriverWait clickableWait = new WebDriverWait(getWebDriver(), time);
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * To Wait Until Element to be Selectable
     */
    public static void explicitWaitElementToBeSelected(WebElement element, int time) {
        WebDriverWait selectableWait = new WebDriverWait(getWebDriver(), time);
        selectableWait.until(ExpectedConditions.elementToBeSelected(element));
    }


    /**
     * To Wait Until Element has the text
     */
    public static void explicitWaitTextToBePresentInElement(WebElement element, int time, String text) {
        WebDriverWait textToBePresent = new WebDriverWait(getWebDriver(), time);
        textToBePresent.until(ExpectedConditions.textToBePresentInElement(element, text));
    }


    /**
     * To Wait Until Title contains the text
     */
    public static void explicitWaitTitleContains(WebElement element, int time, String title) {
        WebDriverWait titleContains = new WebDriverWait(getWebDriver(), time);
        titleContains.until(ExpectedConditions.titleContains(title));
    }


    /**
     * To Wait Until Title is
     */
    public static void explicitWaitTitleIs(WebElement element, int time, String title) {
        WebDriverWait titleIs = new WebDriverWait(getWebDriver(), time);
        titleIs.until(ExpectedConditions.titleIs(title));
    }


    /**
     * To Wait Until Element to be Visible
     */
    public static void explicitWaitVisibilityOfElement(WebElement element, int time) {
        WebDriverWait elementToBeVisible = new WebDriverWait(getWebDriver(), time);
        elementToBeVisible.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * To Wait Until Element is Selected
     */
    public static void explicitWaitSelectionStateToBe(WebElement element, int time, boolean selected) {
        WebDriverWait elementIsSelected = new WebDriverWait(getWebDriver(), Duration.ofSeconds(time));
        elementIsSelected.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }


    /**
     * To Wait Until Elements to be Visible
     */
    public static void explicitWaitVisibilityOfElements(List<WebElement> element, int time) {
        WebDriverWait elementsToBeVisible = new WebDriverWait(getWebDriver(), time);
        elementsToBeVisible.until(ExpectedConditions.visibilityOfAllElements(element));
    }


    /*Select using By Method*/

    /**
     * To Wait Until Element to be Clickable
     */
    public static void explicitWaitElementToBeClickable(By element, int time) {
        WebDriverWait clickableWait = new WebDriverWait(getWebDriver(), time);
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * To Wait Until Element to be Selectable
     */
    public static void explicitWaitElementToBeSelected(By element, int time) {
        WebDriverWait selectableWait = new WebDriverWait(getWebDriver(), time);
        selectableWait.until(ExpectedConditions.elementToBeSelected(element));
    }


    /**
     * To Wait Until Title contains the text
     */
    public static void explicitWaitTitleContains(By element, int time, String title) {
        WebDriverWait titleContains = new WebDriverWait(getWebDriver(), time);
        titleContains.until(ExpectedConditions.titleContains(title));
    }


    /**
     * To Wait Until Title is
     */
    public static void explicitWaitTitleIs(By element, int time, String title) {
        WebDriverWait titleIs = new WebDriverWait(getWebDriver(), time);
        titleIs.until(ExpectedConditions.titleIs(title));
    }


    /**
     * To Wait Until Element to be Visible
     */
    public static void explicitWaitVisibilityOfElement(By element, int time) {
        WebDriverWait elementToBeVisible = new WebDriverWait(getWebDriver(), time);
        elementToBeVisible.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    /**
     * To Wait Until Element is Selected
     */
    public static void explicitWaitSelectionStateToBe(By element, int time, boolean selected) {
        WebDriverWait elementToBeVisible = new WebDriverWait(getWebDriver(), time);
        elementToBeVisible.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }


    /**
     * To Wait for the Alert
     */
    public static void explicitWaitForAlert(int time) {
        WebDriverWait waitForAlert = new WebDriverWait(getWebDriver(), time);
        waitForAlert.until(ExpectedConditions.alertIsPresent());
    }
}