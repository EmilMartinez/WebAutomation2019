package testhomepage;

import base.CommonAPI;
import homepage.SetTrip;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

import java.util.List;

public class TestSetTrip extends CommonAPI {
   SetTrip objSetTrip;

   @BeforeMethod
   public void init() {
      this.objSetTrip = PageFactory.initElements(this.driver, SetTrip.class);
   }

   @Test(alwaysRun = true, description = "Test #19")
   public void clickOnFrom() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objSetTrip.clickOnOrigin();
   }

   @Test(alwaysRun = true, description = "Test #20")
   public void checkFromInput() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objSetTrip.clickOnOrigin();
      Assert.assertTrue(this.objSetTrip.isFromInputVisible());
   }

   @Test(alwaysRun = true, description = "Test #21 - Uses SQL DB")
   public void searchValuesOnFromInput() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objSetTrip.clickOnOrigin();
      List<String> listOfSearchValues = this.objSetTrip.getSearchValuesFromSqlDB();

      for (String s : listOfSearchValues)
         this.objSetTrip.searchFromByStr(s);
   }

   @Test(alwaysRun = true, description = "Test #22 - Uses SQL DB")
   public void searchValuesOnDestinationInput() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      this.objSetTrip.clickOnOrigin();
      List<String> listOfSearchValues = this.objSetTrip.getSearchValuesFromSqlDB();

      for (String s : listOfSearchValues)
         this.objSetTrip.searchDestinationByStr(s);
   }

   @Test(alwaysRun = true, description = "Test #23")
   public void clickSwitchButton() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));


   }
}
