package testpageswellsfargo;

import base.CommonAPI;
import googlesheets.GoogleSpreadsheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import wellsfargopages.WFHomePage;
import wellsfargopages.WFTodaysRatesPage;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class TestWFTodaysRatesPage extends CommonAPI {
    WFHomePage wfHomePage;
    WFTodaysRatesPage wfTodaysRatesPage;
    private GoogleSpreadsheet gSheet = new GoogleSpreadsheet();
    private String credentialFilepath = "../WellsFargo/src/test/resources/credentials.json";
    private String spreadsheetID = "14rPvFLanoWQEAzUAd63Nm_qQYy1RWptZVDTVAfp_gbI";

    @BeforeMethod
    public void initialize() {
        wfHomePage = PageFactory.initElements(this.driver, WFHomePage.class);
        wfTodaysRatesPage = PageFactory.initElements(this.driver, WFTodaysRatesPage.class);
    }

    @Test(dataProvider = "googleSheetData")
    public void testCalculateMonthlyPayments(String zipCode, String amount) {
        driver.navigate().to("https://www.wellsfargo.com/personal-credit/rate-and-payment-calculator/?linkLoc=taskbar");
        wfTodaysRatesPage.calculateMonthlyPayment(zipCode, amount);
    }

    @DataProvider(name = "googleSheetData")
    public Object[][] testGoogleData() throws IOException, GeneralSecurityException {
        List<List<Object>> listOfGoogleSheetData = gSheet.readDataFromGoogleSheets(credentialFilepath, spreadsheetID, "A2:B");
        int i = 0;
        Object[][] arrayList = new Object[listOfGoogleSheetData.size()][];
        for (List<Object> listObject : listOfGoogleSheetData) {
            arrayList[i++] = listObject.toArray();
        }
        return arrayList;
    }
}
