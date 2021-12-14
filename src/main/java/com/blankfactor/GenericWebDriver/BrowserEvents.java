package com.blankfactor.GenericWebDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserEvents {

    /**
     * In charge of moving the mouse over an WebElement
     * @param driver
     * @param webElement
     */
    public void mouseOver(WebDriver driver, WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
    }

    /**
     * In charge of scroll until WebElement
     * @param driver
     * @param webElement
     */
    public void scrollUntilWebElement(WebDriver driver, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", webElement);
    }
}
