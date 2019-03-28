package testcontactpage;

import base.CommonAPI;
import contactpage.ContactUs;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class TestContactUs extends CommonAPI {
   ContactUs newContact;

   @BeforeMethod
   public void init() throws Exception {
      newContact = PageFactory.initElements(driver, ContactUs.class);

      newContact.closeCookiePopup();
      // Scroll down, click on 'Contact Us' to navigate to its page.
      newContact.scrollToFooterField();
      newContact.clickContactUs();
      CommonAPI.waitForPageLoad();
   }

   @Test(description = "Test #108")
   public void checkPageTitle() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      String actualTitle = newContact.getContactPageTitle();
      Assert.assertEquals("CONTACT US", actualTitle);
   }

   @Test(description = "Test #109")
   public void scrollDown() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newContact.scrollABitDown();
   }

   /**
    * Grabs the excel file from Google Sheets that contains actions and text and performs the actions.
    *
    * @throws IOException              If credentials.json does not exist.
    * @throws GeneralSecurityException If I do not have permission to connect to the Google sheet.
    */
   @Test(description = "Test #110 - Uses Google Sheets and keywords")
   public void useKeywordActions() throws IOException, GeneralSecurityException {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newContact.selectActions();
   }

   @Test(description = "Test #111 - Uses Google Sheets and keywords")
   public void testVerificationError() throws IOException, GeneralSecurityException {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newContact.selectActions();
      Assert.assertTrue(newContact.isVerificationError());
   }
}