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

import java.io.IOException;
import java.util.List;

public class TestMore extends CommonAPI {
   More newMore;

   @BeforeMethod
   public void init() {
      newMore = PageFactory.initElements(driver, More.class);
   }

   @Test(alwaysRun = true, description = "Test #25")
   public void clickOnMore() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newMore.clickMore();
   }

   @Test(alwaysRun = true, description = "Test #26")
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newMore.hoverOverMore();
      Assert.assertTrue(newMore.isDropdownVisible());
   }

   @Test(alwaysRun = true, description = "Test #27")
   public void checkEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newMore.hoverOverMore();
      for (WebElement w : newMore.getListOfDropdownWebElem()) {
         newMore.hoverOverEachDropdownLink(w);
      }
   }

   @Test(alwaysRun = true, description = "Test #28")
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newMore.getListOfDropdownWebElem()) {
         newMore.hoverOverMore();
         newMore.clickOnElem(w);
      }
   }

   @Test(alwaysRun = true, description = "Test #29 - Uses SQL DB")
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

   @Test(alwaysRun = true, description = "Test #30 - Uses Excel Reader")
   public void checkDropdownText() throws IOException {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newMore.getListOfDropdownWebElem();
      String[] listOfActualDDTexts = newMore.getNewsTitleFromExcelFile();

      for (int i = 0; i < listOfDDWebElem.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newMore.hoverOverMore();
         String expectedText = listOfActualDDTexts[i];
         String actualText = listOfDDWebElem.get(i).getText();

         Assert.assertEquals(expectedText, actualText);
      }
   }
}

