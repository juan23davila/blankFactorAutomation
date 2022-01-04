package com.blankfactor;

import com.blankfactor.pageObjects.ArticlePage;
import com.blankfactor.pageObjects.BlogPage;
import com.blankfactor.pageObjects.HomePage;
import com.blankfactor.pageObjects.InsightsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for blankfactor.com page.
 */
public class BlankFactorTest
{
    WebDriver driver;

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

    @Test
    public void selectArticle() {
        BlogPage blogPage = new BlogPage(driver);
        int totalArticles = blogPage.getQuantityOfAllArticles();
        int quantityArticles = blogPage.getQuantityOfArticlesDisplayed();
        String articleToSearch = "Why Fintech in Latin America Is Having a Boom";

        while (quantityArticles <= totalArticles) {
            if(blogPage.isArticleVisible(articleToSearch)){
                blogPage.openArticle(articleToSearch);
                break;
            }else {
                blogPage.clickLoadMore(quantityArticles, totalArticles);
                quantityArticles += 3;
            }
        }
    }

    @Test
    public void validateIsOnCorrectPage(){
        String linkOfArticle = "https://blankfactor.com/insights/blog/fintech-in-latin-america/";
        String textInTittle = "Fintech in Latin America";
        ArticlePage articlePage = new ArticlePage(driver);
        //testNG assertion
        Assert.assertEquals(articlePage.getLinkOfArticle(), linkOfArticle);
        //jUnit assertion
        org.junit.Assert.assertTrue("Tittle is the expected", articlePage.getTittleText().contains(textInTittle));
    }

    @Test
    public void subscribeToTheNewsletter(){
        ArticlePage articlePage = new ArticlePage(driver);
        String email = "jua27davila@gmail.com";
        String responseOfSubscription = articlePage.subscribeToTheNewsletter(email);
        Assert.assertEquals(responseOfSubscription, "Thank you for subscribing! Stay tuned.");
    }

    @Test
    public void PrintListOfTitlesWithRelatedLinks(){
        driver.navigate().back();
        BlogPage blogPage = new BlogPage(driver);
        int totalArticles = blogPage.getQuantityOfAllArticles();
        int quantityArticles = blogPage.getQuantityOfArticlesDisplayed();

        while (quantityArticles < (totalArticles - 2) ) {
            blogPage.clickLoadMore(quantityArticles, totalArticles);
            quantityArticles += 3;
        }

        blogPage.PrintListOfTitlesWithRelatedLinks();
    }
}
