package homepage.menubar.dropdowns;

import databases.ConnectToSqlDB;
import databases.ExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class News {
   @FindBy (css = "div.animated.article-main-header:nth-child(5) div.container div.row div.col-sm-9.navigation-block div.navigation div.navbar.navbar-default div.container div.navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav > li.dropdown.menu-large:nth-child(3)")
   private WebElement link_news;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";
   ExcelData excl = new ExcelData();
   String excelPath = "../AlJazeera/src/test/resources/newsdropdown.xlsx";

   public List<String> getListOfDropdownWebElem(WebDriver driver) {
      String xpath = "//div[@id='article-main-header']//li[2]//ul[1]//li[1]//ul[1]";
      WebElement w = driver.findElement(By.xpath(xpath));
      int total = w.findElements(By.tagName("li")).size();
      List <String> list = new ArrayList<String>();
      int counter = 0;

      while(counter < total) {
         list.add(xpath + "//li[" + (counter + 1) + "]");
      }

      return list;
   }

   public void hoverOverNews(WebDriver driver) {
      Actions builder = new Actions(driver);
      builder.moveToElement(link_news).perform();
   }
   
   public void hoverOverEachDropdownLink(WebDriver driver, String text) {
      Actions builder = new Actions(driver);
      WebElement w = driver.findElement(By.xpath(text));
      builder.moveToElement(w).perform();
   }

   public void clickNews() throws InterruptedException, NullPointerException {
      link_news.click();
      Thread.sleep(2000);
   }

   public List<String> getListOfNewsLinkNames() throws Exception {
      return conn.readDataBase("news_dd", "LinkTitle", filepath);
   }

   public String getLinkName(WebElement w) {
      return w.getText();
   }

   /**
    *
    * @param featureName
    * @param driver
    * @throws IOException
    * @throws InterruptedException
    */
   public void selectFrom(String featureName, WebDriver driver) throws IOException, InterruptedException{
      switch(featureName){
         case "Go Live":
            break;
         case "Send Investigation":
            break;
         case "Send Tip":
            break;
         case "Scroll Down":
            break;
         default:
            break;
      }
   }
}
