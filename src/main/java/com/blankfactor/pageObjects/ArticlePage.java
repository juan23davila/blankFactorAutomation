package com.blankfactor.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class ArticlePage {

    WebDriver driver;
    WebDriverWait wait;

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getLinkOfArticle() {
        return driver.getCurrentUrl();
    }

    public String getTittleText() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    public String subscribeToTheNewsletter(String emailToSubscribe) {
        driver.findElement(By.name("email")).sendKeys(emailToSubscribe);
        driver.findElement(By.id("form-newsletter-submit-btn")).click();
        By resultSubscriptionLocator = By.className("mc4wp-response");

        Pattern p = Pattern.compile(".");
        wait.until(ExpectedConditions.textMatches(resultSubscriptionLocator, p));
        String subsResponse = driver.findElement(resultSubscriptionLocator).getText();
        return subsResponse;
    }
}
