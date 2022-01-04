package com.blankfactor.pageObjects;

import com.blankfactor.GenericWebDriver.BrowserEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InsightsPage {

    WebDriver driver;
    BrowserEvents browserEvents = new BrowserEvents();
    WebDriverWait wait;

    public InsightsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectBlogBtn() {
        By goToBlogLocator = By.xpath("//a[contains(text(),'Go to blog')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Next slide']")));

        WebElement blogBtn = driver.findElement(goToBlogLocator);
        browserEvents.scrollUntilWebElement(driver, blogBtn);
        blogBtn.click();
    }
}
