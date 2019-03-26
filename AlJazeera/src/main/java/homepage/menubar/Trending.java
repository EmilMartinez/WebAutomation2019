package homepage.menubar;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will handle all of the trending topics in the navigation bar. They are
 * presented right under the Menu links.
 */
public class Trending extends CommonAPI {
   @FindBy(xpath = "//nav[@class='nav-homepage-topics nav-wide']//ul")
   WebElement field_trendingTopics;

   @FindBy(xpath = "//button[contains(text(),'Show More')]")
   WebElement button_showMore;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";

   /**
    * Creates the proper xPath string of each trending topic, adding it to a list and returning it.
    *
    * @return This is returning a String list of the xPath for each trending topic.
    */
   public List<String> getStrAllWebElemTrendingXpath() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<String> xpath = new ArrayList<String>();
      List<WebElement> listOfTrendingLinks = field_trendingTopics.findElements(By.tagName("li"));

      // Ignoring first element because it is "TRENDING: " and not a link.
      listOfTrendingLinks.remove(0);
      int counter = 0;
      while (counter < listOfTrendingLinks.size()) {
         // Creating the proper xpath str and adding it to the list.
         xpath.add("//nav[@class='nav-homepage-topics nav-wide']//li[" + (counter + 2) + "]");
         counter++;
      }

      return xpath;
   }

   /**
    * Returns the text of the trending topic.
    *
    * @param path This is the xpath of the tropic.
    * @return Returns a string of the topic.
    */
   public String getTextFromTrendingLinkOnMainPage(String path) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return CommonAPI.driver.findElement(By.xpath(path)).getText();
   }

   /**
    * Finds the article title after you click on a trending link.
    *
    * @return Returns a string of the article title.
    */
   public String getTrendingTopicTitle() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      WebElement checkTopicTitle = CommonAPI.driver.findElement(By.xpath("//a[@class='topics-title']"));

      return checkTopicTitle.getText();
   }

   /**
    * Creates a list of each trending topic's titles, creates and adds the list to a table in the SQL db.
    */
   public void addTrendingPageTitleToDB() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<String> listOfTrendingXPath = new ArrayList<String>();

      // Traversing through each trending topic.
      for (String s : getStrAllWebElemTrendingXpath()) {
         CommonAPI.driver.findElement(By.xpath(s)).click();
         // adding the title to the array list.
         listOfTrendingXPath.add(CommonAPI.driver.getTitle());
      }
      // inserting the list of titles into a database.
      conn.insertDataFromArrayListToSqlTable(filepath, listOfTrendingXPath, "trending_titles", "PageTitle");
   }

   public List<String> getListOfTrendingTitlesFromSql() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return conn.readDataBase("trending_titles", "PageTitle", filepath);
   }

   /**
    * Scrolls down the page by specified pixels.
    *
    * @param pixels This is the number of pixels to scroll down.
    */
   public void scrollDownByPixel(int pixels) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      JavascriptExecutor js = (JavascriptExecutor) CommonAPI.driver;
      js.executeScript("window.scrollBy(0," + pixels + ")");
   }

   public void clickOnShowMore() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      button_showMore.click();
   }

   public void clickOnElem(WebElement w) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + w.getText() + ")");

      w.click();
   }
}
