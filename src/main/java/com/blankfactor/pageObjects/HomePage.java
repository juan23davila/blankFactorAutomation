package com.blankfactor.pageObjects;

import com.blankfactor.pageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By navSection = By.className("navbar__nav");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver, navSection);
    }
}
