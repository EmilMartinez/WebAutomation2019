package testmenu;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import menu.Trending;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.StaleElementReferenceException;


import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class TestTrending extends CommonAPI {
   Trending newTrend;
   ConnectToSqlDB conn = new ConnectToSqlDB();

   @BeforeMethod
   public void initialize() {
      newTrend = PageFactory.initElements(driver, Trending.class);
   }

   @Test(priority = 1, description = "Test#4 - Checking if trending links correspond to its page article's title.")
   public void testTrendingPageArticleTitle() throws StaleElementReferenceException {
      for (String s : newTrend.getStrAllWebElemTrendingXpath()) {
         String trendingName = newTrend.getTextFromTrendingLinkOnMainPage(s, driver);
         newTrend.findElemAndClick(driver, s);

         String topicTitle = newTrend.getTrendingTopicTitle(driver);
         Assert.assertTrue(topicTitle.toLowerCase().contains(trendingName.toLowerCase()));
      }
   }

   @Test(priority = 2, description = "Test #5 - Check if titles of trending topics are correct.")
   public void checkPageTitleOfTrendingLinks() throws Exception {
      newTrend.addTrendingNameAndPageTitleToDB(driver);

      // These two lists should be the same size.
      List<String> listOfTrendingXpathStr = newTrend.getStrAllWebElemTrendingXpath();
      List<String> listOfPageTitlesFromEachTrendingLink = newTrend.getListOfElementsFromSql();

      for (int i = 0; i < listOfTrendingXpathStr.size(); i++) {
         String xpathStr = listOfTrendingXpathStr.get(i);
         newTrend.findElemAndClick(driver, xpathStr);

         Assert.assertEquals(listOfPageTitlesFromEachTrendingLink.get(i), driver.getTitle());
      }
   }

   @Test(priority = 3, description = "Test #6 - Click 'SHOW MORE' button for all of the trending topics")
   public void testShowMoreButton() {
      List<String> listOfTrendingXpathStr = newTrend.getStrAllWebElemTrendingXpath();

      for (String s: listOfTrendingXpathStr) {
         newTrend.findElemAndClick(driver, s);
         // Scrolling down the page.
         newTrend.scrollDownByPixel(2500, driver);

         newTrend.findElemAndClick(driver, "#btn_showmore_b1_418");
      }
   }
}


