package com.blankfactor.pageObjects;

import com.blankfactor.GenericWebDriver.BrowserEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BlogPage {
    WebDriver driver;
    BrowserEvents browserEvents = new BrowserEvents();
    WebDriverWait wait;
    WebElement quantityResults;

    public BlogPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int getQuantityOfAllArticles(){
        By quantityResultsLocator = By.cssSelector("div.results");
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityResultsLocator));
        quantityResults = driver.findElement(quantityResultsLocator);
        browserEvents.scrollUntilWebElement(driver, quantityResults);
        String result = quantityResults.getText();
        int a = result.indexOf('(');
        int b = result.indexOf(')');
        return Integer.parseInt(result.substring(a+1,b));
    }

    public int getQuantityOfArticlesDisplayed() {
        return driver.findElements(By.cssSelector("div.posts-list article")).size();
    }

    public void clickLoadMore(int quantityArts) {
        By loadMoreLocator = By.xpath("//span[text()='Load more']/parent::button");
        WebElement loadMoreBtn = driver.findElement(loadMoreLocator);
        browserEvents.scrollUntilWebElement(driver, loadMoreBtn);
        wait.until(ExpectedConditions.elementToBeClickable(loadMoreLocator));
        loadMoreBtn.click();
        wait.until(ExpectedConditions.textToBePresentInElement(quantityResults, "Showing 1-"+quantityArts+" (19) results"));
    }

    public boolean isArticleVisible(String articleToSearch){
        return !driver.findElements(By.linkText(articleToSearch)).isEmpty();
    }

    public void openArticle(String articleToSearch) {
        WebElement articleToOpen = driver.findElement(By.linkText(articleToSearch));
        browserEvents.scrollUntilWebElement(driver, articleToOpen);
        articleToOpen.click();
    }

    public void PrintListOfTitlesWithRelatedLinks() {
        List<WebElement> articles = driver.findElements(By.cssSelector("div.posts-list article"));
        String articleTittle;
        for (int i = 0; i < articles.size(); i++){
            articleTittle = articles.get(i).findElement(By.cssSelector("h2 a")).getText();
            System.out.println( (i+1)+") "+articleTittle );
        }
    }
}
