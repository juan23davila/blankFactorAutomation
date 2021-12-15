package com.blankfactor.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage {

    WebDriver driver;

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLinkOfArticle() {
        return driver.getCurrentUrl();
    }

    public String getTittleText() {
        return driver.findElement(By.tagName("h1")).getText();
    }
}
