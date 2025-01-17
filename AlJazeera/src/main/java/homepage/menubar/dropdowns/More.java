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

public class More extends CommonAPI {
   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) > a.dropdown-toggle")
   private WebElement link_more;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 > ul:nth-child(1)")
   private WebElement field_moreDropdown;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(1) > a:nth-child(1)")
   private WebElement link_features;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(4) > a:nth-child(1)")
   private WebElement link_interactive;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(5) > a:nth-child(1)")
   private WebElement link_interactiveDocs;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(6) > a:nth-child(1)")
   private WebElement link_ajShorts;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(7) > a:nth-child(1)")
   private WebElement link_podcasts;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(8) > a:nth-child(1)")
   private WebElement link_repNotebook;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(9) > a:nth-child(1)")
   private WebElement link_humanRights;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(10) > a:nth-child(1)")
   private WebElement link_sport;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(11) > a:nth-child(1)")
   private WebElement link_scienceNTech;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(10) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(12) > a:nth-child(1)")
   private WebElement link_weather;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private ExcelData excl = new ExcelData();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";
   private String excelPath = "../AlJazeera/src/test/resources/MoreDropdownText.xlsx";

   public List<WebElement> getListOfDropdownWebElem() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> list = new ArrayList<WebElement>();
      list.add(link_features);
      list.add(link_interactive);
      list.add(link_interactiveDocs);
      list.add(link_ajShorts);
      list.add(link_podcasts);
      list.add(link_repNotebook);
      list.add(link_humanRights);
      list.add(link_sport);
      list.add(link_scienceNTech);
      list.add(link_weather);

      return list;
   }

   public void hoverOverMore() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(link_more).perform();
   }

   public void hoverOverEachDropdownLink(WebElement w) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + w.getText() + ")");

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(w).perform();
   }

   public void clickMore() throws NullPointerException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_more.click();
   }

   /**
    * Grabs all the expected page title of each dropdown link, stores it in a list
    * and returns it.
    *
    * @return List of all the expected page title of each Doc's dropdown link.
    * @throws Exception DB could not be connected, docs_dd is not found.
    */
   public List<String> getListOfDropDownTitleFromDB() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return conn.readDataBase("more_dd", "PageTitle", filepath);
   }

   /**
    * Checks to see if More's dropdown is visible.
    *
    * @return Boolean value whether or not dropdown is visible.
    */
   public boolean isDropdownVisible() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if (field_moreDropdown.isDisplayed())
         return true;
      return false;
   }

   public void clickOnElem(WebElement w) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + w.getText() + ")");

      w.click();
   }

   /**
    * Grabs all the expected dropdown texts from an excel sheet. There must be a column title
    * in the sheet (row = 0) and the contents starting from row 1.
    *
    * @return One-dimensional String array of all the expected dropdown text.
    * @throws IOException If excelFile could not be found or read.
    */
   public String [] getNewsTitleFromExcelFile() throws IOException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      String [] arr = excl.fileReader2(excelPath, 0);

      return arr;
   }
}
