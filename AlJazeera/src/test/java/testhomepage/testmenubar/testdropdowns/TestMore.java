package testhomepage.testmenubar.testdropdowns;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import databases.ExcelData;
import homepage.menubar.dropdowns.More;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMore extends CommonAPI {
   More newMore;
   ConnectToSqlDB conn = new ConnectToSqlDB();
   ExcelData excl = new ExcelData();
   String excelPath = "../AlJazeera/src/test/resources/newsdropdown.xlsx";

   @BeforeMethod
   public void init() {
      newMore = PageFactory.initElements(driver, More.class);
   }

   @Test
   public void clickOnMore() {
      newMore.clickMore();
   }

   @Test
   public void checkIfDropdownIsVisible() {
      newMore.hoverOverMore(driver);
      Assert.assertTrue(newMore.isDropdownVisible());
   }

   @Test
   public void checkEachDropdownLink() {
      newMore.hoverOverMore(driver);
      for (String s : newMore.getListOfDropdownWebElem(driver)) {
         newMore.hoverOverEachDropdownLink(driver, s);
      }
   }

   @Test
   public void clickOnEachDropdownLink() throws InterruptedException {
      newMore.hoverOverMore(driver);

      for (String s : newMore.getListOfDropdownWebElem(driver)) {
         newMore.clickOnLink(driver, s);
         // After each click, the drop down will go away. Need to hover again.
         newMore.hoverOverMore(driver);
      }
   }
}
