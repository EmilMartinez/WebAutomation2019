package testhomepage.testmenubar;
import base.CommonAPI;
import homepage.menubar.MenuLinks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class TestMenuLinks extends CommonAPI {
   MenuLinks newNav;

   @BeforeMethod
   public void init() {
      newNav =  PageFactory.initElements(driver, MenuLinks.class);
   }

   @Test (priority = 1, description = "Test #1")
   public void testHomeTitle() throws IOException, SQLException, ClassNotFoundException {
      String temp = "";
      try {
         temp = newNav.getMainPageTitle();
      } catch (NullPointerException e) {
         System.out.println("String is null");
      }
      Assert.assertEquals(temp, driver.getTitle());
   }

   @Test (priority = 2, description = "Test #2")
   public void clickAllMenuLinks() throws InterruptedException, NullPointerException {
      for (WebElement w : newNav.returnWebElemListOfMenuLinks()) {
         w.click();
         CommonAPI.sleepForTwoSec();
         driver.navigate().back();
      }
   }

   /**
    * Clicks on each Menu link and checks to see if the title of each homepage.menu page is the expected title.
    * Expected title is already stored in an SQL table.
    *
    * @throws Exception This happens if you cannot connect to the Sql table, read the system.properties
    * file to connect or cannot define the class.
    */
   @Test (priority = 3, description = "Test #3-10")
   public void clickAndCheckTitleOfMenuLinks() throws Exception {
      for (int i = 0; i < newNav.returnWebElemListOfMenuLinks().size(); i++) {
         newNav.returnWebElemListOfMenuLinks().get(i).click();
         Assert.assertEquals(newNav.getListOfTitlesFromMenuLinks().get(i),driver.getTitle());
         driver.navigate().back();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
   }

   /**
    * Hovers over each menu link with a dropdown and checks if the dropdown is visible.
    *
    * @throws Exception This is when the driver cannot be stalled.
    */
   @Test (priority = 4, description = "Test#11-#14")
   public void checkMenuLinksWithDropdowns() throws Exception {
      for (WebElement w : newNav.returnWebElemListOfMenuLinksWithDD()) {
         newNav.hoverOverMenuLink(w, driver);
         CommonAPI.sleepFor(1);
         // Checks to see if the dropdown is visible.
         Assert.assertTrue(newNav.isDropDownVisible(w));
      }
   }

}