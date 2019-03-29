package testpageswellsfargo;

import base.CommonAPI;
import googlesheets.GoogleSpreadsheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reporting.TestLogger;
import wellsfargopages.WFHomePage;
import wellsfargopages.WFTodaysRatesPage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.NumberFormat;
import java.text.ParseException;
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

    @Test(dataProvider = "googleSheetData", testName = "Google Sheet Data", priority = 1)
    public void testCalculateMonthlyPayments(String zipCode, String amount) {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getAnnotation(Test.class).testName()));
        driver.navigate().to("https://www.wellsfargo.com/personal-credit/rate-and-payment-calculator/?linkLoc=taskbar");
        wfTodaysRatesPage.calculateMonthlyPaymentForPersonalLoans(zipCode, amount);
    }

    @Test(priority = 3)
    public void testCalculatePaymentsForHomePurchase() throws Exception{
        driver.navigate().to("https://www.wellsfargo.com/home-equity?linkLoc=taskbar");
        wfTodaysRatesPage.calculatePaymentsForHomePurchase();
    }

    @Test(testName = "Input data from a text file", priority = 2)
    public void testCalculateLoanAmount() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getAnnotation(Test.class).testName()));
        String[] inputData = getPaymentCalculationData();
        driver.navigate().to("https://www.wellsfargo.com/home-equity?linkLoc=taskbar");
        String result = wfTodaysRatesPage.calculateLoanAmount(inputData[0], inputData[1]);
        long actualResult = 0;
        try {
            actualResult = (Long) NumberFormat.getNumberInstance(java.util.Locale.US).parse(result);
        } catch (ParseException e) {
        }
        long expectedResult = Long.parseLong(inputData[0]) - Long.parseLong(inputData[1]);
        TestLogger.log("Loan Amount: $"+ result);
        Assert.assertEquals(expectedResult, actualResult);
    }

    public String[] getPaymentCalculationData() {
        String[] data = null;
        try {
            BufferedReader br = new BufferedReader((new FileReader("../WellsFargo/src/test/resources/InputDataForPaymentCalcualtion")));
                String line = null;
                while ((line = br.readLine()) != null) {
                    data = line.split(",");
                }
         } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
