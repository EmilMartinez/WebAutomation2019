package testhomepage.testmenubar;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import homepage.menubar.Trending;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.StaleElementReferenceException;


import java.util.List;

public class TestTrending extends CommonAPI {
   Trending newTrend;
   ConnectToSqlDB conn = new ConnectToSqlDB();

   @BeforeMethod
   public void init() {
      newTrend = PageFactory.initElements(driver, Trending.class);
   }

   @Test(priority = 1, description = "Test #18-22")
   public void testTrendingPageArticleTitle() throws StaleElementReferenceException {
      for (String s : newTrend.getStrAllWebElemTrendingXpath()) {
         String trendingName = newTrend.getTextFromTrendingLinkOnMainPage(s, driver);
         newTrend.findElemAndClick(driver, s);

         String topicTitle = newTrend.getTrendingTopicTitle(driver);
         Assert.assertTrue(topicTitle.toLowerCase().contains(trendingName.toLowerCase()));
      }
   }

   @Test(priority = 2, description = "Test #23-27")
   public void checkPageTitleOfTrendingLinks() throws Exception {
      // Creates a table with all the trending page's title.
      newTrend.addTrendingPageTitleToDB(driver);

      // These two lists should be the same size.
      List<String> listOfTrendingXpathStr = newTrend.getStrAllWebElemTrendingXpath();
      List<String> listOfPageTitlesFromEachTrendingLink = newTrend.getListOfTrendingTitlesFromSql();

      // Going through each trending link to grab the title and make an assertion.
      for (int i = 0; i < listOfTrendingXpathStr.size(); i++) {
         String xpathStr = listOfTrendingXpathStr.get(i);
         newTrend.findElemAndClick(driver, xpathStr);

         Assert.assertEquals(listOfPageTitlesFromEachTrendingLink.get(i), driver.getTitle());
      }
   }

   @Test(priority = 3, description = "Test #28-32")
   public void testShowMoreButton() throws InterruptedException {
      List<String> listOfTrendingXpathStr = newTrend.getStrAllWebElemTrendingXpath();

      for (String s : listOfTrendingXpathStr) {
         newTrend.findElemAndClick(driver, s);
         // Scrolling down the page.
         newTrend.scrollDownByPixel(2500, driver);
         // finding and clicking on the 'SHOW MORE' button.
         newTrend.findElemAndClick(driver, "#btn_showmore_b1_418");
         CommonAPI.sleepForTwoSec();
      }
   }
}


