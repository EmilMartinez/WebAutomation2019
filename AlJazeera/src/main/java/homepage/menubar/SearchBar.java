package homepage.menubar;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.List;

public class SearchBar extends CommonAPI {
   @FindBy(css = ".row div.col-sm-3.search-live-block.article-live-block div.search-btn-section.watchLive-pad ul:nth-child(1) li.search-btn-top > a.article-button-search-top-main")
   private WebElement link_searchButton;

   @FindBy(xpath = "//div[@id='article-main-header']//div//div//div//input[@id='searchText-main-header']")
   private WebElement input_searchBar;

   ConnectToSqlDB conn = new ConnectToSqlDB();
   String filepath = "../AlJazeera/src/test/resources/secret.properties";

   public void clickOnSearchButton() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_searchButton.click();
   }

   public void clickAwayFromSearchBar() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(input_searchBar, 0, 25).click().build().perform();
   }

   public void search(String s) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + s + ")");

      input_searchBar.sendKeys(s);
   }

   public void clearSearch() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      input_searchBar.clear();
   }

   public boolean isSearchBarVisible() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if (input_searchBar.isDisplayed())
         return true;
      return false;
   }

   public void revealSearchbar() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if (!isSearchBarVisible())
         link_searchButton.click();
   }

   public List<String> getAllSearchValuesFromSqlDB() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return conn.readDataBase("search_values", "SearchValues", filepath);
   }

   public String getSearchValue() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return input_searchBar.getAttribute("value");
   }

   public void searchAndEnter(String value) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + value + ")");

      input_searchBar.sendKeys(value, Keys.ENTER);
   }
}
