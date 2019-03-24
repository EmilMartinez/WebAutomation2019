package testhomepage.testmenubar;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import homepage.menubar.SearchBar;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

   /**
    * Checks to see if search-bar is still visible when you click away from it.
    */
   @Test
   public void testIfSearchBarIsVisibleAfterButtonClick() {
      newSearch.clickOnSearchButton();
      newSearch.clickAwayFromSearchBar(driver);
      Assert.assertFalse(newSearch.isSearchBarVisible());
   }

   /**
    * Checks to see if the search-bar goes away when we click anywhere else in the page.
    */
   @Test
   public void clickAwayFromSearchBar() {
      newSearch.revealSearchbar();
      Assert.assertFalse(newSearch.isSearchBarVisible());
   }

   /**
    * Checks to see if the search-bar goes away when we double click on the search button.
    */
   public void testSearchBarAfterDoubleClickOnSearchButton() {
      newSearch.clickOnSearchButton();
      newSearch.clickOnSearchButton();

      Assert.assertFalse(newSearch.isSearchBarVisible());
   }

   /**
    * Grabs search values from MySQL db and inputs them in the search bar.
    *
    * @throws Exception If db table does not exist.
    */
   @Test
   public void testSearch() throws Exception {
      // If search bar is not visible, reveal it.
      newSearch.revealSearchbar();

      for (String s : newSearch.getAllSearchValuesFromSqlDB()) {
         newSearch.clearSearch();
         newSearch.search(s);

         // Checking to see if the value of search-bar is the same as we had inputted.
         Assert.assertEquals(newSearch.getSearchValue(), s);
      }
   }

   @Test
   public void testSearchAndEnter() throws Exception {
      // If search bar is not visible, reveal it.
      newSearch.revealSearchbar();

      for (String s : newSearch.getAllSearchValuesFromSqlDB()) {
         newSearch.clearSearch();
         newSearch.searchAndEnter(s);
         // After hitting enter, menu's search bar is not visible. Must reveal it again to do the next search.
         newSearch.revealSearchbar();
      }
   }

}
