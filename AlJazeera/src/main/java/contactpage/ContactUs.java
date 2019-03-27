package contactpage;

import base.CommonAPI;
import googlesheets.GoogleSpreadsheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ContactUs extends CommonAPI {
   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(2) ul.list:nth-child(2) li:nth-child(1) > a:nth-child(1)")
   private WebElement link_contactUs;

   @FindBy(css = ".topics-title")
   private WebElement link_contactPageTitle;

   @FindBy(xpath = "//iframe[@id='ContactUsForm']")
   private WebElement iframe_contactUsForm;

   @FindBy(css = "#ddlTo")
//   @FindBy(xpath = "//select[@id='ddlTo']")
   private WebElement select_to;

   @FindBy(css = "#tbSenderName")
//   @FindBy(xpath = "//input[@name='tbSenderName']")
   private WebElement input_senderName;

   @FindBy(css = "#tbSenderEmail")
//   @FindBy(xpath = "//input[@id='tbSenderEmail']")
   private WebElement input_senderEmail;

   @FindBy(css = "#tbSubject")
//   @FindBy(xpath = "//input[@id='tbSubject']")
   private WebElement input_subject;

   @FindBy(css = "#tbMessage")
//   @FindBy(xpath = "//textarea[@id='tbMessage']")
   private WebElement input_message;

   @FindBy(css = "#cbConsent")
//   @FindBy(xpath = "//input[@id='cbConsent']")
   private WebElement checkbox_consent;

   @FindBy(css = "#btSend")
//   @FindBy(xpath = "//input[@id='btSend']")
   private WebElement button_send;

   @FindBy(xpath = "//div[@class='enstDismiss']")
   private WebElement button_cookieClose;

   private GoogleSpreadsheet gSheet = new GoogleSpreadsheet();
   private String credentialFilepath = "../AlJazeera/src/test/resources/credentials.json";
   private String spreadsheetID = "1XEF1Zq638djQFZruQdw2P-NLkYeKOQVfFOY-SNIQaBE";

   public void clickContactUs() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_contactUs.click();
   }

   public void scrollToFooterField() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      JavascriptExecutor js = (JavascriptExecutor) CommonAPI.driver;
      js.executeScript("window.scrollTo(0, 100000)");
      Thread.sleep(5000);
   }

   public void closeCookiePopup() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      button_cookieClose.click();
   }

   public String getContactPageTitle() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return link_contactPageTitle.getText();
   }

   public void scrollABitDown() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      JavascriptExecutor js = (JavascriptExecutor) CommonAPI.driver;
      js.executeScript("window.scrollTo(0, 450)");
   }

   public List<List<Object>> getDataFromGoogleSheet() throws IOException, GeneralSecurityException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return gSheet.readDataFromGoogleSheets(credentialFilepath, spreadsheetID, "A2:E");
   }

   public void selectActions() throws IOException, GeneralSecurityException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<List<Object>> listOfActionsAndText = getDataFromGoogleSheet();
      // Form is in an iframe. Need to switch to it.
      CommonAPI.driver.switchTo().frame(iframe_contactUsForm);

      for (List row : listOfActionsAndText) {
         String text = (String) row.get(1);
         switch ((String) row.get(0)) {
            case "scroll down":
               scrollABitDown();
               break;
            case "select to":
               CommonAPI.selectOptionByVisibleText(select_to, text);
               break;
            case "write sender name":
               input_senderName.sendKeys(text);
               break;
            case "write sender email":
               input_senderEmail.sendKeys(text);
               break;
            case "write subject":
               input_subject.sendKeys(text);
               break;
            case "write message":
               input_message.sendKeys(text);
               break;
            case "click consent":
               checkbox_consent.click();
               break;
            case "submit":
               button_send.click();
               break;
            default:
               break;
         }
      }
   }
}