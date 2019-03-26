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

public class Shows extends CommonAPI {
   @FindBy(css = "div.site-sticky.article-main-header.sticky-float.slideDown:nth-child(2) div.container div.row div.col-sm-9.navigation-block div.navigation div.navbar.navbar-default div.container div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(6) > a.dropdown-toggle")
   private WebElement link_shows;

   @FindBy(css = "div.site-sticky.article-main-header.sticky-float.slideDown:nth-child(2) div.container div.row div.col-sm-9.navigation-block div.navigation div.navbar.navbar-default div.container div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(6) > ul.dropdown-menu.megamenu.row")
   private WebElement field_showsDropdown;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[1]")
   private WebElement link_insideStory;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[2]")
   private WebElement link_theStream;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[3]")
   private WebElement link_listeningPost;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[4]")
   private WebElement link_talkToAJ;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[5]")
   private WebElement link_bigPicture;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[6]")
   private WebElement link_head;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[7]")
   private WebElement link_countingTheCost;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[8]")
   private WebElement link_upFront;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[9]")
   private WebElement link_earthrise;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[10]")
   private WebElement link_empire;

   @FindBy(xpath = "//div[@id='sticky-header']//li[5]//ul[1]//li[1]//ul[1]//li[11]")
   private WebElement link_all;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   ExcelData excl = new ExcelData();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";
   String excelPath = "../AlJazeera/src/test/resources/newsdropdown.xlsx";

   public List<WebElement> getListOfDropdownWebElem() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> list = new ArrayList<WebElement>();

      list.add(link_insideStory);
      list.add(link_theStream);
      list.add(link_listeningPost);
      list.add(link_talkToAJ);
      list.add(link_bigPicture);
      list.add(link_head);
      list.add(link_countingTheCost);
      list.add(link_upFront);
      list.add(link_earthrise);
      list.add(link_empire);
      list.add(link_all);

      return list;
   }

   public void hoverOverShows() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(link_shows).perform();
   }

   public void hoverOverEachDropdownLink(WebElement w) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + w.getText() + ")");

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(w).perform();
   }

   public void clickShows() throws NullPointerException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_shows.click();
   }

   public List<String> getListOfDropDownTextFromDB() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return conn.readDataBase("shows_dd", "LinkTitle", filepath);
   }

   public boolean isDropdownVisible() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if(field_showsDropdown.isDisplayed())
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
