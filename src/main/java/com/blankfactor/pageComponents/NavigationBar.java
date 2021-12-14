package com.blankfactor.pageComponents;

import com.blankfactor.AbstractComponents.AbstractComponent;
import com.blankfactor.GenericWebDriver.BrowserEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {
    WebDriver driver;
    BrowserEvents browserEvents = new BrowserEvents();

    By insightsBtn = By.id("menu-item-4436");

    public NavigationBar(WebDriver driver, By navSection) {
        super(driver, navSection);
        this.driver = driver;
    }

    public void selectInsights(){
        findElement(insightsBtn).click();
    }

    public void mouseOverInsights(){
        browserEvents.mouseOver(driver, findElement(insightsBtn));
    }
}
