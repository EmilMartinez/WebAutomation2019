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

public class Documentaries extends CommonAPI {
   @FindBy(css = "div.site-sticky.article-main-header.sticky-float.slideDown:nth-child(2) div.container div.row div.col-sm-9.navigation-block div.navigation div.navbar.navbar-default div.container div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) > a.dropdown-toggle")
   private WebElement link_docs;

   @FindBy(css = "div.site-sticky.article-main-header.sticky-float.slideDown:nth-child(2) div.container div.row div.col-sm-9.navigation-block div.navigation div.navbar.navbar-default div.container div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) > ul.dropdown-menu.megamenu.row")
   private WebElement field_docsDropdown;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[1]")
   private WebElement link_featuredDocumentaries;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[2]")
   private WebElement link_witness;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[3]")
   private WebElement link_ajWorld;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[4]")
   private WebElement link_101East;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[5]")
   private WebElement link_peopleNPower;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[6]")
   private WebElement link_faultLines;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[7]")
   private WebElement link_radYouth;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[8]")
   private WebElement link_ajCorrespondent;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[9]")
   private WebElement link_thisIsEuro;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[10]")
   private WebElement link_ajSelects;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[11]")
   private WebElement link_rewind;

   @FindBy(xpath = "//div[@id='sticky-header']//li[4]//ul[1]//li[1]//ul[1]//li[12]")
   private WebElement link_all;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private ExcelData excl = new ExcelData();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";
   private String excelPath = "../AlJazeera/src/test/resources/newsdropdown.xlsx";

   public List<WebElement> getListOfDropdownWebElem() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> list = new ArrayList<WebElement>();
      list.add(link_featuredDocumentaries);
      list.add(link_witness);
      list.add(link_ajWorld);
      list.add(link_101East);
      list.add(link_peopleNPower);
      list.add(link_faultLines);
      list.add(link_radYouth);
      list.add(link_ajCorrespondent);
      list.add(link_thisIsEuro);
      list.add(link_ajSelects);
      list.add(link_rewind);
      list.add(link_all);

      return list;
   }

   public void hoverOverDocs() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(link_docs).perform();
   }

   public void hoverOverEachDropdownLink(WebElement w) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + w.getText() + ")");

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(w).perform();
   }

   public void clickDocs() throws NullPointerException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_docs.click();
   }

   public List<String> getListOfDropDownTextFromDB() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return conn.readDataBase("docs_dd", "LinkTitle", filepath);
   }

   public boolean isDropdownVisible() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if(field_docsDropdown.isDisplayed())
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
