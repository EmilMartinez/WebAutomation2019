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
   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) > a.dropdown-toggle")
   private WebElement link_docs;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) > ul.dropdown-menu.megamenu.row li.col-sm-4 > ul:nth-child(1)")
   private WebElement field_docsDropdown;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(1) > a:nth-child(1)")
   private WebElement link_featuredDocumentaries;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(2) > a:nth-child(1)")
   private WebElement link_witness;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(3) > a:nth-child(1)")
   private WebElement link_ajWorld;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(4) > a:nth-child(1)")
   private WebElement link_101East;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(5) > a:nth-child(1)")
   private WebElement link_peopleNPower;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(6) > a:nth-child(1)")
   private WebElement link_faultLines;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(7) > a:nth-child(1)")
   private WebElement link_radYouth;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(8) > a:nth-child(1)")
   private WebElement link_ajCorrespondent;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(9) > a:nth-child(1)")
   private WebElement link_thisIsEuro;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(10) > a:nth-child(1)")
   private WebElement link_ajSelects;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(11) > a:nth-child(1)")
   private WebElement link_rewind;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) ul.dropdown-menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(12) > a:nth-child(1)")
   private WebElement link_all;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private ExcelData excl = new ExcelData();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";
   private String excelPath = "../AlJazeera/src/test/resources/DocumentariesDropdownText.xlsx";

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

   public void hoverOverDropdownLink(WebElement w) {
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

      return conn.readDataBase("docs_dd", "PageTitle", filepath);
   }

   /**
    * Checks to see if Documentaries' dropdown is visible.
    *
    * @return Boolean value whether or not dropdown is visible.
    */
   public boolean isDropdownVisible() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if(field_docsDropdown.isDisplayed())
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
