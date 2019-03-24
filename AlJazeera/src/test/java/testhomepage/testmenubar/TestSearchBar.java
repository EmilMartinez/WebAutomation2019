package testhomepage.testmenubar;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import homepage.menubar.SearchBar;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSearchBar extends CommonAPI {
   SearchBar newSearch;
   ConnectToSqlDB conn = new ConnectToSqlDB();

   @BeforeMethod
   public void init() {
      newSearch = PageFactory.initElements(driver, SearchBar.class);
   }

   @Test
   public void testClickOnSearchButton() {
      newSearch.clickOnSearchButton();
   }

   @Test
   public void testSearch() throws Exception {
      // If search bar is not visible, reveal it.
      newSearch.revealSearchbar();

      for (String s : newSearch.getAllSearchValuesFromSqlDB()) {
         newSearch.clearSearch();
         newSearch.search(s);

         // Checking to see if the value of searchbar is the same as we had inputted.
         Assert.assertEquals(newSearch.getSearchValue(), s);
      }
   }

   @Test(description = "Test #24")
   public void testSearchAndEnter() throws Exception {
      // If search bar is not visible, reveal it.
      newSearch.revealSearchbar();

      for (String s : newSearch.getAllSearchValuesFromSqlDB()) {
         newSearch.clearSearch();
         newSearch.searchAndEnter(s);
         // After hitting enter, menu's search bar is not visible.
         // Must reveal it again to do the next search.
         newSearch.revealSearchbar();
      }
   }

}
