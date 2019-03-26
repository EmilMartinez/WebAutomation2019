package testhomepage.testmenubar.testdropdowns;

import base.CommonAPI;
import homepage.menubar.dropdowns.Documentaries;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

import java.util.List;

public class TestDocumentaries extends CommonAPI {
   Documentaries newDocs;

   @BeforeMethod
   public void init() {
      newDocs = PageFactory.initElements(driver, Documentaries.class);
   }

   @Test(priority = 1, description = "Test #29")
   public void clickOnDocs() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newDocs.clickDocs();
   }

   @Test(priority = 2, description = "Test #30")
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newDocs.hoverOverDocs();
      Assert.assertTrue(newDocs.isDropdownVisible());
   }

   @Test(priority = 3, description = "Test #31")
   public void checkEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newDocs.hoverOverDocs();
      for (WebElement w : newDocs.getListOfDropdownWebElem()) {
         newDocs.hoverOverEachDropdownLink(w);
      }
   }

   @Test(priority = 4, description = "Test #32")
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newDocs.getListOfDropdownWebElem()) {
         newDocs.hoverOverDocs();
         w.click();
      }
   }

   @Test(priority = 5, description = "Test #33 - Uses SQL DB")
   public void checkEachLinkText() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newDocs.getListOfDropdownWebElem();
      List<String> listOfDDActualText = newDocs.getListOfDropDownTextFromDB();

      for (int i = 0; i < listOfDDActualText.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newDocs.hoverOverDocs();
         String expectedTitle = listOfDDActualText.get(i);
         listOfDDWebElem.get(i).click();

         Assert.assertEquals(expectedTitle, CommonAPI.driver.getCurrentUrl());
      }
   }
}
