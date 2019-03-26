package testhomepage.testmenubar.testdropdowns;

import base.CommonAPI;
import homepage.menubar.dropdowns.More;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

import java.util.List;

public class TestMore extends CommonAPI {
   More newMore;

   @BeforeMethod
   public void init() {
      newMore = PageFactory.initElements(driver, More.class);
   }

   @Test(priority = 1, description = "Test #24")
   public void clickOnMore() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newMore.clickMore();
   }

   @Test(priority = 2, description = "Test #25")
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newMore.hoverOverMore();
      Assert.assertTrue(newMore.isDropdownVisible());
   }

   @Test(priority = 3, description = "Test #26")
   public void checkEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newMore.hoverOverMore();
      for (WebElement w : newMore.getListOfDropdownWebElem()) {
         newMore.hoverOverEachDropdownLink(w);
      }
   }

   @Test(priority = 4, description = "Test #27")
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newMore.getListOfDropdownWebElem()) {
         newMore.hoverOverMore();
         w.click();
      }
   }

   @Test(priority = 5, description = "Test #28 - Uses SQL DB")
   public void checkEachLinkText() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newMore.getListOfDropdownWebElem();
      List<String> listOfDDActualText = newMore.getListOfDropDownTextFromDB();

      for (int i = 0; i < listOfDDActualText.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newMore.hoverOverMore();
         String expectedTitle = listOfDDActualText.get(i);
         listOfDDWebElem.get(i).click();

         Assert.assertEquals(expectedTitle, CommonAPI.driver.getCurrentUrl());
      }
   }
}

