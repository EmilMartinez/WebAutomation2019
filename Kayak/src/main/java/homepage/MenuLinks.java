package homepage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class MenuLinks extends CommonAPI {
   @FindBy(css = ".col.js-vertical-flights._bd._CZ._Y._mK._cF._e05._8W")
   private WebElement link_flights;

   @FindBy(css = ".col.js-vertical-hotels._bd._CZ._Y._mK._cF")
   private WebElement link_hotels;

   @FindBy(css = ".col.js-vertical-cars._bd._CZ._Y._mK._5")
   private WebElement link_cars;

   @FindBy(css = ".col.js-vertical-packages._bd._CZ._Y._mK._5")
   private WebElement link_flightNHotel;

   @FindBy(css = ".col.js-vertical-cruises._bd._CZ._Y._mK._sh")
   private WebElement link_cruises;

   @FindBy(css = ".col.js-vertical-deals._bd._CZ._Y._mK._sh")
   private WebElement link_deals;

   @FindBy(css = ".col.js-vertical-more._bd._CZ._Y._mK._N-")
   private WebElement link_more;

   @FindBy(css = "._Gk._r8._cA._cB._6V")
   private WebElement modal_moreDD;

   @FindBy(css = ".moreMenuItem.restaurants._6X._cg._cf._25._ch._e._I._cr._fx._fw._c9._u._cA._rr._cB._cb")
   private WebElement link_more_restaurants;

   @FindBy(css = ".moreMenuItem.explore._6X._cg._cf._25._ch._e._I._cr._fx._fw._c9._u._cA._rr._cB._cb._cc._K")
   private WebElement link_more_explore;

   @FindBy(css = ".moreMenuItem.guides._6X._cg._cf._25._ch._e._I._cr._fx._fw._c9._u._cA._rr._cB._cb._cc._K")
   private WebElement link_more_guides;

   @FindBy(css = ".moreMenuItem.planner._6X._cg._cf._25._ch._e._I._cr._fx._fw._c9._u._cA._rr._cB._cb._cc._K")
   private WebElement link_more_tripHudle;

   @FindBy(css = ".moreMenuItem.routes._6X._cg._cf._25._ch._e._I._cr._fx._fw._c9._u._cA._rr._cB._cb._cc._K")
   private WebElement link_more_routes;

   @FindBy(css = ".moreMenuItem.direct._6X._cg._cf._25._ch._e._I._cr._fx._fw._c9._u._cA._rr._cB._cb._E1._K")
   private WebElement link_more_direct;

   @FindBy(css = ".moreMenuItem.help._6X._cg._cf._25._ch._e._I._cr._fx._fw._c9._u._cA._rr._cB._cb._K._cc")
   private WebElement link_more_help;

   @FindBy(css = ".moreMenuItem.mobile._6X._cg._cf._25._ch._e._I._cr._fx._fw._c9._u._cA._rr._cB._cb._K._E1")
   private WebElement link_more_mobile;

   @FindBy(css = "._dw._Sy._sh._Em._Sz._w._y._Y._ji")
   private WebElement link_trips;

   @FindBy(css = ".js-trigger-label._k")
   private WebElement link_signIn;

   @FindBy(css = "._be._PX._PY._dO")
   private WebElement modal_signIn;

   @FindBy(id = "logo")
   private WebElement image_logo;

   public void clickFlights() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

//      CommonAPI.driver.switchTo().frame(iframe);
      this.link_flights.click();
   }

   public void clickHotels() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_hotels.click();
   }

   public void clickCars() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_cars.click();
   }

   public void clickFlightNHotels() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_flightNHotel.click();
   }

   public void clickCruises() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_cruises.click();
   }

   public void clickDeals() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_deals.click();
   }

   public void clickMore() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_more.click();
   }

   public void clickTrips() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_trips.click();
   }

   public void clickSignIn() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_signIn.click();
   }

   public void clickRestaurants() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_more_restaurants.click();
   }

   public void clickExplore() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_more_explore.click();
   }

   public void clickGuides() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_more_guides.click();
   }

   public void clickTripHuddle() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_more_tripHudle.click();
   }

   public void clickRoutes() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_more_routes.click();
   }

   public void clickDirect() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_more_direct.click();
   }

   public void clickHelp() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_more_help.click();
   }

   public void clickMobile() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.link_more_mobile.click();
   }

   public boolean isMoreDDVisible() {
      if (this.modal_moreDD.isDisplayed())
         return true;
      return false;
   }

   public boolean isSignInDDVisible() {
      if (this.modal_signIn.isDisplayed())
         return true;
      return false;
   }
}
