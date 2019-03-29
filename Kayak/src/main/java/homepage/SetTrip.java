package homepage;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.util.List;

public class SetTrip extends CommonAPI {
   @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
   private WebElement field_from;

   @FindBy(name = "origin")
   private WebElement input_from;

   @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]")
   private WebElement field_to;

   @FindBy(name = "destination")
   private WebElement input_to;

   //@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
   @FindBy(id = "qZxd-originDepartureSwitch")
   private WebElement button_switch;

   @FindBy(id = "#R_19-submit")
   private WebElement button_search;

   ConnectToSqlDB conn = new ConnectToSqlDB();
   private String filepath = "../Kayak/src/test/resources/secret.properties";

   public void clickOnOrigin() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      field_from.click();
   }

   public void clickOnDestination() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));
   }

   public boolean isFromInputVisible() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if (input_from.isDisplayed())
         return true;
      return false;
   }

   public void searchFromByStr(String loc) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      input_from.clear();
      input_from.sendKeys(loc);
   }

   public void searchDestinationByStr(String loc) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      input_to.clear();
      input_to.sendKeys(loc);
   }

   public List<String> getSearchValuesFromSqlDB() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<String> list = conn.readDataBase("travel_searches", "SearchValues", filepath);

      return list;
   }
}