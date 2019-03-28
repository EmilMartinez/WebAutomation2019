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

import java.io.IOException;
import java.util.List;

public class TestShows extends CommonAPI {
   Shows newShow;

   @BeforeMethod
   public void init() {
      newShow = PageFactory.initElements(driver, Shows.class);
   }

   @Test(description = "Test #37")
   public void clickOnShows() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newShow.clickShows();
   }

   @Test(description = "Test #38")
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newShow.hoverOverShows();
      Assert.assertTrue(newShow.isDropdownVisible());
   }

   @Test(description = "Test #39")
   public void checkEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newShow.hoverOverShows();
      for (WebElement w : newShow.getListOfDropdownWebElem()) {
         newShow.hoverOverEachDropdownLink(w);
      }
   }

   @Test(description = "Test #40")
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newShow.getListOfDropdownWebElem()) {
         newShow.hoverOverShows();
         newShow.clickOnElem(w);
         if (CommonAPI.isThereMoreThanOneTabs())
            CommonAPI.handleTabs();
         else
            driver.navigate().back();
      }
   }

   @Test(description = "Test #41 - Uses SQL DB")
   public void checkEachLinkText() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newShow.getListOfDropdownWebElem();
      List<String> listOfDDActualText = newShow.getListOfDropDownTitleFromDB();

      for (int i = 0; i < listOfDDActualText.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newShow.hoverOverShows();
         String expectedTitle = listOfDDActualText.get(i);
         WebElement w = listOfDDWebElem.get(i);
         newShow.clickOnElem(w);
         CommonAPI.waitForPageLoad();

         Assert.assertEquals(expectedTitle, CommonAPI.driver.getTitle());
         if (CommonAPI.isThereMoreThanOneTabs())
            CommonAPI.handleTabs();
         else
            driver.navigate().back();
      }
   }

   @Test(description = "Test #42 - Uses Excel Reader")
   public void checkDropdownText() throws IOException {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newShow.getListOfDropdownWebElem();
      String[] listOfActualDDTexts = newShow.getNewsTitleFromExcelFile();

      for (int i = 0; i < listOfDDWebElem.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newShow.hoverOverShows();
         String expectedText = listOfActualDDTexts[i];
         String actualText = listOfDDWebElem.get(i).getText();

         Assert.assertEquals(expectedText, actualText);
      }
   }
}
