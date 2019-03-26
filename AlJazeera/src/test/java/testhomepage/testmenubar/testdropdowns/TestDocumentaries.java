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

   @Test(priority = 6, description = "Test #19")
//   @Test(priority = 19, description = "Test #19")
   public void clickOnDocs() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newDocs.clickDocs();
   }

   @Test(priority = 7, description = "Test #29")
//   @Test(priority = 20, description = "Test #20")
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newDocs.hoverOverDocs();
      Assert.assertTrue(newDocs.isDropdownVisible());
   }

   @Test(priority = 8, description = "Test #29")
//   @Test(priority = 21, description = "Test #21")
   public void hoverEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newDocs.hoverOverDocs();
      for (WebElement w : newDocs.getListOfDropdownWebElem()) {
         newDocs.hoverOverDropdownLink(w);
      }
   }

   @Test(priority = 9, description = "Test #29")
//   @Test(priority = 22, description = "Test #22")
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newDocs.getListOfDropdownWebElem()) {
         newDocs.hoverOverDocs();
         newDocs.clickOnElem(w);
         driver.navigate().back();
         CommonAPI.waitForPageLoad();
      }
   }

   @Test(priority = 10, description = "Test #29")
//   @Test(priority = 23, description = "Test #23 - Uses SQL DB")
   public void checkEachLinkTitle() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newDocs.getListOfDropdownWebElem();
      List<String> listOfDDActualText = newDocs.getListOfDropDownTitleFromDB();

      for (int i = 0; i < listOfDDActualText.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newDocs.hoverOverDocs();
         String expectedTitle = listOfDDActualText.get(i);
         newDocs.clickOnElem(listOfDDWebElem.get(i));
         CommonAPI.waitForPageLoad();

         Assert.assertEquals(expectedTitle, CommonAPI.driver.getTitle());
         driver.navigate().back();
      }
   }
}
