package homepage.menubar.dropdowns;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import databases.ExcelData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class News extends CommonAPI {
   @FindBy(css = "div.animated.article-main-header:nth-child(5) div.container div.row div.col-sm-9.navigation-block div.navigation div.navbar.navbar-default div.container div.navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(3) > a.dropdown-toggle")
   private WebElement link_news;

   @FindBy(css = "div.site-sticky.article-main-header.sticky-float.slideDown:nth-child(2) div.container div.row div.col-sm-9.navigation-block div.navigation div.navbar.navbar-default div.container div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(3) > ul.dropdown-menu.megamenu.row")
   private WebElement field_newsDropdown;

   @FindBy(xpath = "//div[@id='sticky-header']//li[2]//ul[1]//li[1]//ul[1]//li[2]")
   private WebElement link_africa;

   @FindBy(xpath = "//div[@id='sticky-header']//li[2]//ul[1]//li[1]//ul[1]//li[3]")
   private WebElement link_asia;

   @FindBy(xpath = "//div[@id='sticky-header']//li[2]//ul[1]//li[1]//ul[1]//li[4]")
   private WebElement link_usAndCanada;

   @FindBy(xpath = "//div[@id='sticky-header']//li[2]//ul[1]//li[1]//ul[1]//li[5]")
   private WebElement link_latinAmerica;

   @FindBy(xpath = "//div[@id='sticky-header']//li[2]//ul[1]//li[1]//ul[1]//li[6]")
   private WebElement link_europe;

   @FindBy(xpath = "//div[@id='sticky-header']//li[2]//ul[1]//li[1]//ul[1]//li[7]")
   private WebElement link_asiaPacific;

   @FindBy(xpath = "//div[@id='sticky-header']//li[2]//ul[1]//li[1]//ul[1]//li[8]")
   private WebElement link_all;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private ExcelData excl = new ExcelData();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";
   private String excelPath = "../AlJazeera/src/test/resources/newsdropdown.xlsx";

   public List<WebElement> getListOfDropdownWebElem() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> list = new ArrayList<WebElement>();
      list.add(link_africa);
      list.add(link_asia);
      list.add(link_usAndCanada);
      list.add(link_latinAmerica);
      list.add(link_europe);
      list.add(link_asiaPacific);
      list.add(link_all);

      return list;
   }

   public void hoverOverNews() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(link_news).perform();
   }

   public void hoverOverEachDropdownLink(WebElement w) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + w.getText() + ")");

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(w).perform();
   }

   public void clickNews() throws NullPointerException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_news.click();
   }

   public List<String> getListOfDropDownTextFromDB() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return conn.readDataBase("news_dd", "LinkTitle", filepath);
   }

   public boolean isDropdownVisible() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if (field_newsDropdown.isDisplayed())
         return true;
      return false;
   }

   /**
    * @param featureName
    * @throws IOException
    * @throws InterruptedException
    */
   public void selectFrom(String featureName) throws IOException, InterruptedException {
      switch (featureName) {
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
