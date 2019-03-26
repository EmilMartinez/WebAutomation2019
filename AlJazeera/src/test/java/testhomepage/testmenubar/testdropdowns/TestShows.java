package testhomepage.testmenubar.testdropdowns;

import base.CommonAPI;
import homepage.menubar.dropdowns.Shows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

import java.util.List;

public class TestShows extends CommonAPI {
   Shows newShow;

   @BeforeMethod
   public void init() {
      newShow = PageFactory.initElements(driver, Shows.class);
   }

   @Test(priority = 1, description = "Test #34")
   public void clickOnShows() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newShow.clickShows();
   }

   @Test(priority = 2, description = "Test #35")
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newShow.hoverOverShows();
      Assert.assertTrue(newShow.isDropdownVisible());
   }

   @Test(priority = 3, description = "Test #36")
   public void checkEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newShow.hoverOverShows();
      for (WebElement w : newShow.getListOfDropdownWebElem()) {
         newShow.hoverOverEachDropdownLink(w);
      }
   }

   @Test(priority = 4, description = "Test #37")
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newShow.getListOfDropdownWebElem()) {
         newShow.hoverOverShows();
         w.click();
      }
   }

   @Test(priority = 5, description = "Test #38 - Uses SQL DB")
   public void checkEachLinkText() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newShow.getListOfDropdownWebElem();
      List<String> listOfDDActualText = newShow.getListOfDropDownTextFromDB();

      for(int i = 0; i < listOfDDActualText.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newShow.hoverOverShows();
         String expectedTitle = listOfDDActualText.get(i);
         WebElement w = listOfDDWebElem.get(i);
         w.click();

         Assert.assertEquals(expectedTitle, CommonAPI.driver.getCurrentUrl());
      }
   }
}
