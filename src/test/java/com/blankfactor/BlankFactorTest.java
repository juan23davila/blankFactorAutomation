package com.blankfactor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for blankfactor.com page.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void futureAssertion()
    {
        assertTrue( true );
    }

    @Test
    public void openPage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\juan.davila\\Documents\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://blankfactor.com");
        driver.manage().window().maximize();
    }
}
