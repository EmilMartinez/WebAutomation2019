package homepage.menubar;

import databases.ConnectToSqlDB;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchBar {
   @FindBy(css = ".row div.col-sm-3.search-live-block.article-live-block div.search-btn-section.watchLive-pad ul:nth-child(1) li.search-btn-top > a.article-button-search-top-main")
   private WebElement link_searchButton;

   @FindBy(xpath = "//div[@id='article-main-header']//div//div//div//input[@id='searchText-main-header']")
   private WebElement input_searchBar;

   ConnectToSqlDB conn = new ConnectToSqlDB();
   String filepath = "../AlJazeera/src/test/resources/secret.properties";

   public void clickOnSearchButton() {
      link_searchButton.click();
   }

   public void search(String s) {
      input_searchBar.sendKeys(s);
   }

   public void clearSearch() {
      input_searchBar.clear();
   }

   private boolean isSearchBarVisible() {
      if (input_searchBar.isDisplayed())
         return true;
      return false;
   }

   public void revealSearchbar() {
      if(!isSearchBarVisible())
         link_searchButton.click();
   }

   public List<String> getAllSearchValuesFromSqlDB() throws Exception {
      return conn.readDataBase("search_values","SearchValues",filepath);
   }

   public String getSearchValue() {
      return input_searchBar.getAttribute("value");
   }

   public void searchAndEnter(String value) {
      input_searchBar.sendKeys(value, Keys.ENTER);
   }
}
