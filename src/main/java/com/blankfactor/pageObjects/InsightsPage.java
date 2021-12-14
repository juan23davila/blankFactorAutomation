package com.blankfactor.pageObjects;

import com.blankfactor.GenericWebDriver.BrowserEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsightsPage {

    WebDriver driver;
    BrowserEvents browserEvents = new BrowserEvents();

    public InsightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBlogBtn() {
        WebElement blogBtn = driver.findElement(By.xpath("//a[text()=' Go to blog ']"));
        browserEvents.scrollUntilWebElement(driver, blogBtn);
        blogBtn.click();
    }
}
