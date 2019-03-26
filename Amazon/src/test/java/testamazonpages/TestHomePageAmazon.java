package testamazonpages;

import amazonpages.HomePageAmazon;
import base.CommonAPI;
import databases.ExcelData;
import datasource.MongoDbData;
import datasource.MySqlData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reporting.TestLogger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestHomePageAmazon extends CommonAPI {
    HomePageAmazon homePageAmazon;
    MySqlData mySqlData;
    MongoDbData mongoDbData;
    ExcelData excelData = new ExcelData();
    String excelPath = "../Amazon/src/test/resources/testForSelenium.xls";
    List<String> inLinks = new ArrayList<>();
    List<String> extLinks = new ArrayList<>();
    List<String> imageInfo = new ArrayList<>();
    int count = 0;

    @BeforeMethod
    public void initialize() {
        this.homePageAmazon = PageFactory.initElements(this.driver, HomePageAmazon.class);
        mySqlData = new MySqlData();
        mongoDbData = new MongoDbData();
        //TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
    }

    //@Test(description = "search bar")
    public void testSearchForItems() {
        //TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        homePageAmazon.searchForItems("alexa");
        Assert.assertEquals(driver.getTitle(), "Amazon.com: alexa");
    }

    //@Test(description = "mysql test")
    public void testSearchItemsSql() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> list = null;
        try {
            list = mySqlData.getItemsListFromDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String s : list) {
            homePageAmazon.searchForItems(s);
            TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName())+" "+s);
        }
    }

    @Test(description = "mongo database")
    public void testSearchForItemsMongo() throws Exception, IOException, SQLException, ClassNotFoundException {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> list = mongoDbData.getItemsListFromDB();
        for (String s : list) {
            homePageAmazon.searchForItems(s);
            TestLogger.log(getClass().getSimpleName() + ": "+ s);
        }
    }

    @Test(description = "search button")
    public void testSearchButton() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        homePageAmazon.searchButton("scarf");
    }

    //@Test(description = "search results")
    public void testSearchResults() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String item = "iphones";
        TestLogger.log(homePageAmazon.searchResults(item) + " " + item);
    }

    //@Test(description = "dropdown test1")
    public void testSetDropdown() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        boolean checkTitle = true;
        Assert.assertEquals(homePageAmazon.setDropdown().endsWith("AmazonFresh"), checkTitle);
    }

    //@Test(description = "dropdown options")
    public void testGetDropdownOptions() {
        String dropDownOptions = "";
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<WebElement> options = homePageAmazon.getDropdownOptions();
        for (WebElement element : options) {
            dropDownOptions += " " + element.getText();
            //System.out.println(element.getText());
        }
        TestLogger.log("Dropdown options: " + dropDownOptions);
    }

    //@Test(description = "sign in")
    public void testSignInLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        homePageAmazon.signInLink();
        String signInPageTitle = "Amazon Sign In";
        Assert.assertEquals(driver.getTitle(), signInPageTitle);
    }

    @DataProvider(name = "signInExcelData")
    public Object[][] signInData() throws IOException{
        Object[][] arrayExcelData = excelData.fileReader1(excelPath, "Sheet1");
        return arrayExcelData;
    }

    @Test(dataProvider = "signInExcelData")
    public void testInvalidAccountSignIn(String email, String pwd) {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        TestLogger.log("Error message: " + homePageAmazon.invalidAccountSignIn(email, pwd));
    }

    @Test
    public void testInvalidSignInScreenShot() {
        SoftAssert softAssert = new SoftAssert();
        homePageAmazon.InvalidSignInScreenShot("user@usertest.com", "userabc");
        String path = CommonAPI.captureScreenshot(driver, "Failed");
        TestLogger.screenShot(path, getClass().getSimpleName());
        Assert.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    }

    @Test(description = "navigation")
    public void testNavigation() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String subUrl = "https://www.google.com/";
        driver.navigate().to(subUrl);
        driver.navigate().back();
        driver.navigate().forward();
        Assert.assertEquals(driver.getCurrentUrl(), subUrl);
    }

    @Test(description = "?")
    public void testClickLangSettings() {
        homePageAmazon.clickLangSettings();
        throw new SkipException("Still working on this test");
    }

    //@Test(description = "mouse hover your list link")
    public void testYourLists() throws Exception {
        System.out.println(homePageAmazon.hoverOverAccountsAndSelect());

    }

    //@Test(description = "checkboxes")
    public void testCheckboxesInGiftCards() throws Exception {
        homePageAmazon.checkboxesInGiftCards();
    }

    //@Test(description = "form, radiobuttons, text area")
    public void testAdFeedbackWindow() {
        homePageAmazon.adFeedbackWindow();
    }

    //@Test - Not working
    public void testHandleWindows() {
        System.out.println(homePageAmazon.handleWindows());
    }

    //@Test(description = "web table")
    public void testPrimePageTable() {
        homePageAmazon.primePageTable();
    }

    //@Test(description = "tabs")
    public void testGetPrimePageTabs() {
        homePageAmazon.getPrimePageTabs();
    }

    //@Test(description = "your account")
    public void testYourAccountLists() {
        homePageAmazon.yourAccountLinks();
    }

    //@Test(description = "try prime")
    public void testPrimeLink() {
        homePageAmazon.primeLink();
        Assert.assertEquals(driver.getTitle(),"Prime Delivery");
    }

    //@Test(description = "Add to cart")
    public void testAddToCart() {
        homePageAmazon.addToCart();
    }

    //@Test(description = "iframe")
    public void testIFrameExample() {
        homePageAmazon.iFrameExample();
    }

    //@Test(description = "top right link")
    public void testUpperRightLink() {
        homePageAmazon.upperRightLink();
    }

    //@Test(description = "Image present test")
    public void testImagePresent() {
        homePageAmazon.imagePresent(imageInfo);
        for (String info : imageInfo) {
            System.out.println(info);
        }
        String csvpath = "/Users/varija/Documents/Selenium/WebAutomation2019/Amazon/src/test/resources/ImagesPresent.txt";
        writeToCsv(imageInfo, csvpath, "Images check" );
        //Assert.assertEquals(true,homePageAmazon.bargainFindsImage());
    }

    //@Test(description = "Internal Links")
    public void testInternalLinks() {
        homePageAmazon.internalLinks(inLinks);
        for (String linkTitle: inLinks) {
            System.out.println(linkTitle);
        }
        String csvpath = "/Users/varija/Documents/Selenium/WebAutomation2019/Amazon/src/test/resources/InternalLinks.txt";
        writeToCsv(inLinks, csvpath, "Internal Links");
    }

    //@Test(description = "External Links")
    public void testExaternalLinks() {
        homePageAmazon.externalLinks(extLinks);
        for (String linkTitle: extLinks) {
            System.out.println(linkTitle);
        }
        String csvpath = "/Users/varija/Documents/Selenium/WebAutomation2019/Amazon/src/test/resources/ExternalLinks.txt";
        writeToCsv(extLinks, csvpath, "External Links");
    }

    public void writeToCsv(List<String> csvData, String csvpath, String header) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvpath));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(header));
            for (String data : csvData) {
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
