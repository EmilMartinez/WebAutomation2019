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

   @Test(description = "Test #24")
   // @Test(priority = 24)
   public void clickOnMore() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newMore.clickMore();
   }

   @Test(description = "Test #25")
   // @Test(priority = 25)
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newMore.hoverOverMore();
      Assert.assertTrue(newMore.isDropdownVisible());
   }

   @Test(description = "Test #26")
   // @Test(priority = 26)
   public void checkEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newMore.hoverOverMore();
      for (WebElement w : newMore.getListOfDropdownWebElem()) {
         newMore.hoverOverEachDropdownLink(w);
      }
   }

   @Test(description = "Test #27")
   // @Test(priority = 27)
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newMore.getListOfDropdownWebElem()) {
         newMore.hoverOverMore();
         newMore.clickOnElem(w);
      }
   }

   @Test(description = "Test #28 - Uses SQL DB")
   // @Test(priority = 28, description = "Uses SQL DB")
   public void getListOfDropDownTitleFromDB() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newMore.getListOfDropdownWebElem();
      List<String> listOfDDActualText = newMore.getListOfDropDownTitleFromDB();

      for (int i = 0; i < listOfDDActualText.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newMore.hoverOverMore();
         String expectedTitle = listOfDDActualText.get(i);
         newMore.clickOnElem(listOfDDWebElem.get(i));

         Assert.assertEquals(expectedTitle, CommonAPI.driver.getTitle());
      }
   }
}

