package com.blankfactor;

import com.blankfactor.pageObjects.HomePage;
import com.blankfactor.pageObjects.InsightsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for blankfactor.com page.
 */
public class BlankFactorTest
{
    WebDriver driver;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void futureAssertion()
    {
        assertTrue( true );
    }

    @Test
    public void openPageTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\juan.davila\\Documents\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://blankfactor.com");
    }

    @Test
    public void goBlogSectionTest() {
        HomePage homePage = new HomePage(driver);
        homePage.getNavigationBar().selectInsights();
        InsightsPage insightsPage = new InsightsPage(driver);
        insightsPage.selectBlogBtn();
    }
}
