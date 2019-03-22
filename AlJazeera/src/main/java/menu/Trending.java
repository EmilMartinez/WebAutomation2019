package menu;

import databases.ConnectToSqlDB;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Trending {
   @FindBy (xpath = "//nav[@class='nav-homepage-topics nav-wide']//ul")
   WebElement uls_trendingTopics;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";

   public List<String> getStrAllWebElemTrendingXpath() {
      List<String> xpath = new ArrayList<String>();
      List<WebElement> listOfTrendingLinks = uls_trendingTopics.findElements(By.tagName("li"));

      // Ignoring first element because it is "TRENDING: " and not a link.
      listOfTrendingLinks.remove(0);
      int counter = 0;
      while (counter < listOfTrendingLinks.size()) {
         xpath.add("//nav[@class=\'nav-homepage-topics nav-wide\']//li[" + (counter + 2) + "]");
         counter++;
      }

      return xpath;
   }

   public String getTextFromTrendingLinkOnMainPage(String path, WebDriver driver) {
      return driver.findElement(By.xpath(path)).getText();
   }

   public String getTrendingTopicTitle(WebDriver driver) {
      WebElement checkTopicTitle = driver.findElement(By.xpath("//a[@class='topics-title']"));

      return checkTopicTitle.getText();
   }

   public void addTrendingNameAndPageTitleToDB(WebDriver driver) {
      List<String> listOfTrendingXPath = new ArrayList<String>();
      for (String s : getStrAllWebElemTrendingXpath()) {
         driver.findElement(By.xpath(s)).click();
         listOfTrendingXPath.add(driver.getTitle());
      }

      conn.insertDataFromArrayListToSqlTable(filepath, listOfTrendingXPath, "trending_titles", "PageTitle");
   }

   public List<String> getListOfElementsFromSql() throws Exception {
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

   public void scrollDownByPixel(int pixels, WebDriver driver) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0," + pixels + ")");
   }

}
