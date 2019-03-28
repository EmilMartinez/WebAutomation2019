package testhomepage.testmenubar;

import base.CommonAPI;
import homepage.menubar.Trending;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.StaleElementReferenceException;
import reporting.ApplicationLog;
import reporting.TestLogger;


import java.util.List;

public class TestTrending extends CommonAPI {
   Trending newTrend;

   @BeforeMethod
   public void init() {
      newTrend = PageFactory.initElements(driver, Trending.class);
   }

   @Test(description = "Test #16")
   public void testTrendingPageArticleTitle() throws StaleElementReferenceException {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (String s : newTrend.getStrAllWebElemTrendingXpath()) {
         String trendingName = newTrend.getTextFromTrendingLinkOnMainPage(s);
         CommonAPI.clickOnElem(s);

         String topicTitle = newTrend.getTrendingTopicTitle();
         Assert.assertTrue(topicTitle.toLowerCase().contains(trendingName.toLowerCase()));
      }
   }

   @Test(description = "Test #17 - Uses SQL DB")
   public void checkPageTitleOfTrendingLinks() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Creates a table with all the trending page's title.
      newTrend.addTrendingPageTitleToDB();

      // These two lists should be the same size.
      List<String> listOfTrendingXpathStr = newTrend.getStrAllWebElemTrendingXpath();
      List<String> listOfPageTitlesFromEachTrendingLink = newTrend.getListOfTrendingTitlesFromSql();

      // Going through each trending link to grab the title and make an assertion.
      for (int i = 0; i < listOfTrendingXpathStr.size(); i++) {
         String xpathStr = listOfTrendingXpathStr.get(i);
         CommonAPI.clickOnElem(xpathStr);

         Assert.assertEquals(listOfPageTitlesFromEachTrendingLink.get(i), driver.getTitle());
      }
   }

   @Test(description = "Test #18")
   public void testShowMoreButton() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<String> listOfTrendingXpathStr = newTrend.getStrAllWebElemTrendingXpath();

      for (String s : listOfTrendingXpathStr) {
         CommonAPI.clickOnElem(s);
         // Scrolling down the page.
         newTrend.scrollDownByPixel(2500);
         newTrend.clickOnShowMore();
      }
   }
}


