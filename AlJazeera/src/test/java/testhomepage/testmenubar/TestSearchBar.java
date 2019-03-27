package testhomepage.testmenubar;

import base.CommonAPI;
import homepage.menubar.SearchBar;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

public class TestSearchBar extends CommonAPI {
   SearchBar newSearch;

   @BeforeMethod
   public void init() {
      newSearch = PageFactory.initElements(driver, SearchBar.class);
   }

   @Test(priority = 10)
   public void testClickOnSearchButton() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.clickOnSearchButton();
   }

   /**
    * Checks to see if search-bar is visible after clicking on the search button.
    */
   @Test(priority = 11)
   public void checkIfSearchBarIsVisibleAfterButtonClick() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.clickOnSearchButton();
      Assert.assertTrue(newSearch.isSearchBarVisible());
   }

   /**
    * Checks to see if the search-bar goes away when we click anywhere else in the page.
    */
   @Test(priority = 12)
   public void clickAwayFromSearchBar() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.revealSearchbar();
      newSearch.clickAwayFromSearchBar();
      Assert.assertFalse(newSearch.isSearchBarVisible());
   }

   /**
    * Checks to see if the search-bar goes away when we double click on the search button.
    */
   @Test(priority = 13)
   public void testSearchBarAfterDoubleClickOnSearchButton() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.doubleClickOnSearchButton();

      Assert.assertFalse(newSearch.isSearchBarVisible());
   }

   /**
    * Grabs search values from MySQL db and inputs them in the search bar.
    *
    * @throws Exception If db table does not exist.
    */
   @Test(priority = 14, description = "Uses SQL DB")
   public void testSearch() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // If search bar is not visible, reveal it.
      newSearch.revealSearchbar();

      for (String s : newSearch.getAllSearchValuesFromSqlDB()) {
         newSearch.clearSearch();
         newSearch.search(s);

         // Checking to see if the value of search-bar is the same as we had inputted.
         Assert.assertEquals(newSearch.getSearchValue(), s);
      }
   }

   @Test(priority = 15, description = "Uses SQL DB")
   public void testSearchAndEnter() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

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
