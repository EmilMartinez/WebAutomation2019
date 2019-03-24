package testhomepage.testmenubar.testdropdowns;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import databases.ExcelData;
import homepage.menubar.dropdowns.Shows;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestShows extends CommonAPI {
   Shows newShow;
   ConnectToSqlDB conn = new ConnectToSqlDB();
   ExcelData excl = new ExcelData();
   String excelPath = "../AlJazeera/src/test/resources/newsdropdown.xlsx";

   @BeforeMethod
   public void init() {
      newShow = PageFactory.initElements(driver, Shows.class);
   }

   @Test
   public void clickOnShows() {
      newShow.clickShows();
   }

   @Test
   public void checkIfDropdownIsVisible() {
      newShow.hoverOverShows(driver);
      Assert.assertTrue(newShow.isDropdownVisible());
   }

   @Test
   public void checkEachDropdownLink() {
      newShow.hoverOverShows(driver);
      for (String s : newShow.getListOfDropdownWebElem(driver)) {
         newShow.hoverOverEachDropdownLink(driver, s);
      }
   }

   @Test
   public void clickOnEachDropdownLink() throws InterruptedException {
      newShow.hoverOverShows(driver);

      for (String s : newShow.getListOfDropdownWebElem(driver)) {
         newShow.clickOnLink(driver, s);
         // After each click, the drop down will go away. Need to hover again.
         newShow.hoverOverShows(driver);
      }
   }
}
