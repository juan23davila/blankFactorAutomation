package com.blankfactor.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractComponent {

    WebElement sectionElement;

    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.sectionElement = driver.findElement(sectionElement);
    }

    public WebElement findElement(By elementBy){
        return sectionElement.findElement(elementBy);
    }
}
