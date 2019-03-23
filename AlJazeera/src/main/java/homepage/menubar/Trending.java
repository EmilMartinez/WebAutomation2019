package homepage.menubar;

import databases.ConnectToSqlDB;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class will handle all of the trending topics in the navigation bar. They are
 * presented right under the Menu links.
 */
public class Trending {
   @FindBy (xpath = "//nav[@class='nav-homepage-topics nav-wide']//ul")
   WebElement uls_trendingTopics;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";

   /**
    * Creates the proper xPath string of each trending topic, adding it to a list and returning it.
    *
    * @return This is returning a String list of the xPath for each trending topic.
    */
   public List<String> getStrAllWebElemTrendingXpath() {
      List<String> xpath = new ArrayList<String>();
      List<WebElement> listOfTrendingLinks = uls_trendingTopics.findElements(By.tagName("li"));

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
    * @param driver This is the driver.
    * @return Returns a string of the topic.
    */
   public String getTextFromTrendingLinkOnMainPage(String path, WebDriver driver) {
      return driver.findElement(By.xpath(path)).getText();
   }

   /**
    * Finds the article title after you click on a trending link.
    *
    * @param driver This is the driver working on the current session.
    * @return Returns a string of the article title.
    */
   public String getTrendingTopicTitle(WebDriver driver) {
      WebElement checkTopicTitle = driver.findElement(By.xpath("//a[@class='topics-title']"));

      return checkTopicTitle.getText();
   }

   /**
    * Creates a list of each trending topic's titles, creates and adds the list to a table in the SQL db.
    *
    * @param driver This is the driver working on the current session.
    */
   public void addTrendingPageTitleToDB(WebDriver driver) {
      List<String> listOfTrendingXPath = new ArrayList<String>();

      // Traversing through each trending topic.
      for (String s : getStrAllWebElemTrendingXpath()) {
         driver.findElement(By.xpath(s)).click();
         // adding the title to the array list.
         listOfTrendingXPath.add(driver.getTitle());
      }
      // inserting the list of titles into a database.
      conn.insertDataFromArrayListToSqlTable(filepath, listOfTrendingXPath, "trending_titles", "PageTitle");
   }

   public List<String> getListOfTrendingTitlesFromSql() throws Exception {
      return conn.readDataBase("trending_titles", "PageTitle", filepath);
   }

   public void findElemAndClick(WebDriver driver, String locStr) {
      try {
         driver.findElement(By.cssSelector(locStr)).click();
      } catch (Exception ex1) {
         try {
            driver.findElement(By.id(locStr)).click();
         } catch (Exception ex2) {
            try {
               driver.findElement(By.xpath(locStr)).click();
            } catch (Exception ex3) {
               driver.findElement(By.name(locStr)).click();
            }
         }
      } finally {
         driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
      }
   }

   /**
    * Scrolls down the page by specified pixels.
    *
    * @param pixels This is the number of pixels to scroll down.
    * @param driver This is the driver working on the current session.
    */
   public void scrollDownByPixel(int pixels, WebDriver driver) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0," + pixels + ")");
   }

}
