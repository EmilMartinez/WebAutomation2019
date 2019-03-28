package testhomepage.testmenubar;

import base.CommonAPI;
import homepage.menubar.MenuLinks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
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

   @Test(description = "Test #1")
   public void testHomeTitle() throws IOException, SQLException, ClassNotFoundException {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      String temp = "";
      try {
         temp = newNav.getMainPageTitle();
      } catch (NullPointerException e) {
         System.out.println("String is null");
      }
      Assert.assertEquals(temp, driver.getTitle());
   }

   @Test(description = "Test #2")
   public void clickOnLogo() {
      newNav.clickOnLogo();
   }

   @Test(description = "Test #3 - Uses SQL Database")
   public void checkTitleAfterClickOnLogo() throws IOException, SQLException, ClassNotFoundException {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNav.clickOnLogo();
      String temp = "";
      try {
         temp = newNav.getMainPageTitle();
      } catch (NullPointerException e) {
         e.printStackTrace();
      }
      Assert.assertEquals(temp, driver.getTitle());
   }

   @Test(description = "Test #4")
   public void clickAllMenuLinks() throws NullPointerException {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newNav.returnWebElemListOfMenuLinks()) {
         newNav.clickOnElem(w);
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
   @Test(description = "Test #5 - Uses SQL DB")
   public void clickAndCheckTitleOfMenuLinks() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (int i = 0; i < newNav.returnWebElemListOfMenuLinks().size(); i++) {
         WebElement w = newNav.returnWebElemListOfMenuLinks().get(i);
         newNav.clickOnElem(w);
         Assert.assertEquals(newNav.getListOfTitlesFromMenuLinks().get(i), driver.getTitle());
         driver.navigate().back();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
   }

   /**
    * Hovers over each menu link with a dropdown and checks if the dropdown is visible.
    */
   @Test(description = "Test #6 - Uses SQL DB")
   public void checkMenuLinksWithDropdowns() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newNav.returnWebElemListOfMenuLinksWithDD()) {
         newNav.hoverOverMenuLink(w);
         // Checks to see if the dropdown is visible.
         Assert.assertTrue(newNav.isDropDownVisible(w));
      }
   }

   /**
    * Checks to see if the Menu dropdown appears when you reduce the size of the browser window.
    */
   @Test(description = "Test #7")
   public void checkMenuAfterReducingWindowSize() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNav.decreaseWindowSize();
      Assert.assertTrue(newNav.isSmallNavbarVisible());
   }

   @Test(description = "Test #8")
   public void checkSmallMenuCloseButton() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNav.decreaseWindowSize();
      newNav.clickOnSmallNavBar();
      Assert.assertTrue(newNav.isSmallNavbarCloseButtonVisible());
   }

   @Test(description = "Test #9")
   public void checkLiveAfterSmallWindow() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNav.decreaseWindowSize();
      Assert.assertTrue(newNav.isLiveVisibleAfterReducingWindowSize());
   }
}