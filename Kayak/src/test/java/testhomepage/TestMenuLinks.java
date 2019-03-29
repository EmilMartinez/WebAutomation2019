package testhomepage;

import base.CommonAPI;
import homepage.MenuLinks;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

import java.util.concurrent.TimeUnit;

public class TestMenuLinks extends CommonAPI {
   MenuLinks objMenu;

   @BeforeMethod
   public void init() {
      this.objMenu = PageFactory.initElements(this.driver, MenuLinks.class);
   }

   @Test(alwaysRun = true, description = "Test #1")
   public void clickOnFlights() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

      this.objMenu.clickFlights();
   }

   @Test(alwaysRun = true, description = "Test #2")
   public void clickOnHotels() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickHotels();
   }

   @Test(alwaysRun = true, description = "Test #3")
   public void clickOnCars() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickCars();
   }

   @Test(alwaysRun = true, description = "Test #4")
   public void clickOnFlightsNHotels() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickFlightNHotels();
   }

   @Test(alwaysRun = true, description = "Test #5")
   public void clickOnCruises() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickCruises();
   }

   @Test(alwaysRun = true, description = "Test #6")
   public void clickOnDeals() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickDeals();
   }

   @Test(alwaysRun = true, description = "Test #7")
   public void clickOnMore() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickMore();
   }

   @Test(alwaysRun = true, description = "Test #8")
   public void checkMoreDropdown() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickMore();

      Assert.assertTrue(this.objMenu.isMoreDDVisible());
   }

   @Test(alwaysRun = true, description = "Test #9")
   public void clickOnTrips() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickTrips();
   }

   @Test(alwaysRun = true, description = "Test #10")
   public void clickOnSignIn() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickSignIn();
   }

   @Test(alwaysRun = true, description = "Test #11")
   public void checkSignInDropdown() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objMenu.clickSignIn();

      Assert.assertTrue(this.objMenu.isSignInDDVisible());
   }

   @Test(alwaysRun = true, description = "Test #12")
   public void clickOnRestaurants() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Restaurant is under the More dropdown.
      this.objMenu.clickMore();
      this.objMenu.clickRestaurants();
   }

   @Test(alwaysRun = true, description = "Test #13")
   public void clickOnExplore() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Explore is under the More dropdown.
      this.objMenu.clickMore();
      this.objMenu.clickGuides();
   }

   @Test(alwaysRun = true, description = "Test #14")
   public void clickOnTripHuddle() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Trip Huddle is under the More dropdown.
      this.objMenu.clickMore();
      this.objMenu.clickTripHuddle();
   }

   @Test(alwaysRun = true, description = "Test #15")
   public void clickOnRoutes() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Routes is under the More dropdown.
      this.objMenu.clickMore();
      this.objMenu.clickRoutes();
   }

   @Test(alwaysRun = true, description = "Test #16")
   public void clickOnDirect() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Direct is under the More dropdown.
      this.objMenu.clickMore();
      this.objMenu.clickDirect();
   }

   @Test(alwaysRun = true, description = "Test #17")
   public void clickOnHelp() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Explore is under the More dropdown.
      this.objMenu.clickMore();
      this.objMenu.clickHelp();
   }

   @Test(alwaysRun = true, description = "Test #18")
   public void clickOnMobile() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Mobile is under the More dropdown.
      this.objMenu.clickMore();
      this.objMenu.clickMobile();
   }
}
