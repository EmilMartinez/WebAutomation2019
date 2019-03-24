package testhomepage.testmenubar.testdropdowns;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import databases.ExcelData;
import homepage.menubar.dropdowns.Documentaries;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDocumentaries extends CommonAPI {
   Documentaries newDocs;
   ConnectToSqlDB conn = new ConnectToSqlDB();
   ExcelData excl = new ExcelData();
   String excelPath = "../AlJazeera/src/test/resources/newsdropdown.xlsx";

   @BeforeMethod
   public void init() {
      newDocs = PageFactory.initElements(driver, Documentaries.class);
   }

   @Test
   public void clickOnDocs() {
      newDocs.clickDocs();
   }

   @Test
   public void checkIfDropdownIsVisible() {
      newDocs.hoverOverDocs(driver);
      Assert.assertTrue(newDocs.isDropdownVisible());
   }

   @Test
   public void checkEachDropdownLink() {
      newDocs.hoverOverDocs(driver);
      for (String s : newDocs.getListOfDropdownWebElem(driver)) {
         newDocs.hoverOverEachDropdownLink(driver, s);
      }
   }

   @Test
   public void clickOnEachDropdownLink() throws InterruptedException{
      newDocs.hoverOverDocs(driver);

      for (String s : newDocs.getListOfDropdownWebElem(driver)) {
         newDocs.clickOnLink(driver, s);
         // After each click, the drop down will go away. Need to hover again.
         newDocs.hoverOverDocs(driver);
      }
   }
}
