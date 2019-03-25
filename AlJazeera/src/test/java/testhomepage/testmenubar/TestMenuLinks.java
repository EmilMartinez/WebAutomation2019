package testhomepage.testmenubar;

import base.CommonAPI;
import homepage.menubar.MenuLinks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class TestMenuLinks extends CommonAPI {
   MenuLinks newNav;

   @BeforeMethod
   public void init() {
      newNav = PageFactory.initElements(driver, MenuLinks.class);
   }

   @Test
   public void testHomeTitle() throws IOException, SQLException, ClassNotFoundException {
      String temp = "";
      try {
         temp = newNav.getMainPageTitle();
      } catch (NullPointerException e) {
         System.out.println("String is null");
      }
      Assert.assertEquals(temp, driver.getTitle());
   }

   @Test
   public void clickOnLogo() {
      newNav.clickOnLogo();
   }

   @Test
   public void checkTitleAfterClickOnLogo() throws IOException, SQLException, ClassNotFoundException {
      newNav.clickOnLogo();
      String temp = "";
      try {
         temp = newNav.getMainPageTitle();
      } catch (NullPointerException e) {
         e.printStackTrace();
      }
      Assert.assertEquals(temp, driver.getTitle());
   }

   @Test
   public void clickAllMenuLinks() throws NullPointerException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
      for (WebElement w : newNav.returnWebElemListOfMenuLinks()) {
         w.click();
         driver.navigate().back();
      }
   }

   /**
    * Clicks on each Menu link and checks to see if the title of each homepage.menu page is the expected title.
    * Expected title is already stored in an SQL table.
    *
    * @throws Exception This happens if you cannot connect to the Sql table, read the system.properties
    *                   file to connect or cannot define the class.
    */
   @Test
   public void clickAndCheckTitleOfMenuLinks() throws Exception {
      for (int i = 0; i < newNav.returnWebElemListOfMenuLinks().size(); i++) {
         newNav.returnWebElemListOfMenuLinks().get(i).click();
         Assert.assertEquals(newNav.getListOfTitlesFromMenuLinks().get(i), driver.getTitle());
         driver.navigate().back();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
   }

   /**
    * Hovers over each menu link with a dropdown and checks if the dropdown is visible.
    *
    * @throws Exception This is when the driver cannot be stalled.
    */
   @Test
   public void checkMenuLinksWithDropdowns() throws Exception {
      for (WebElement w : newNav.returnWebElemListOfMenuLinksWithDD()) {
         newNav.hoverOverMenuLink(w, driver);
         // Checks to see if the dropdown is visible.
         Assert.assertTrue(newNav.isDropDownVisible(w));
      }
   }

<<<<<<< HEAD
   /**
    * Checks to see if the Menu dropdown appears when you reduce the size of the browser window.
    */
   @Test
   public void checkMenuAfterReducingWindowSize() {
      newNav.decreaseWindowSize(driver);
      Assert.assertTrue(newNav.isSmallNavbarVisible(driver));
   }

   @Test
   public void checkSmallMenuCloseButton() throws InterruptedException {
      newNav.decreaseWindowSize(driver);
      Thread.sleep(2000);
      newNav.clickOnSmallNavBar(driver);
      Assert.assertTrue(newNav.isSmallNavbarCloseButtonVisible(driver));
   }

   @Test
   public void checkLiveAfterSmallWindow() {
      newNav.decreaseWindowSize(driver);
      Assert.assertTrue(newNav.isLiveVisible(driver));
   }
=======
>>>>>>> develop
}