package testpageswellsfargo;

import base.CommonAPI;
import databases.ExcelData;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;
import wellsfargopages.WFHomePage;

import java.util.ArrayList;
import java.util.List;

public class TestWFHomePage extends CommonAPI {

    WFHomePage wfHomePage;
    ExcelData excelData = new ExcelData();
    String path = "../WellsFargo/src/test/resources/KeywordData.xls";
    String title = "";
    List<String> imageInfo = new ArrayList<>();

    @BeforeMethod
    public void initialize() {
        wfHomePage = PageFactory.initElements(this.driver, WFHomePage.class);
    }

    //@Test(description = "search")
    public void testSearchBar() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        wfHomePage.searchBar("loans");
        title = driver.getTitle();
        driver.navigate().back();

    }

    //@Test(description = "dropdown")
    public void testDropDownOptions() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        List<WebElement> elements = wfHomePage.dropDownOptions();
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    //@Test(description = "navigation")
    public void testCommercialLinks() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        wfHomePage.commericialLink();
        String title = "Wells Fargo Commercial – Commercial Financing Services";
        Assert.assertEquals(driver.getTitle(), title);
    }

    //@Test(testName = "Keyword driven testing")
    public void testSteps() throws Exception {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getAnnotation(Test.class).testName()));
        String[] testSteps = excelData.fileReader2(path, 0);
        for (String step : testSteps) {
            switch (step) {
                case "dropdown":
                    testDropDownOptions();
                    break;
                case "search":
                    testSearchBar();
                    Assert.assertEquals(title, "Wells Fargo Search Our Site");
                    break;
                case "navigate":
                    testCommercialLinks();
                    break;
                default:
                    throw new InvalidArgumentException("Invalid choice");
            }
        }
    }

    @Test(testName = "Carousel testing and Dynamic fetching of locators")
    public void testCarouselTabs() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getAnnotation(Test.class).testName()));
        wfHomePage.carouselTabs(driver);
    }

    //@Test
    public void testPopUpWindowSubmit() {
        wfHomePage.popUpWindowSubmit();
    }

    //@Test
    public void testPersonalLoansLink() {
        String expectedResult = "Personal Loan & Line of Credit Calculator - Wells Fargo";
        wfHomePage.personalLoansLink();
    }

    //@Test
    public void testPopUpWindowClose() {
        wfHomePage.popUpWindowClose();
        System.out.println(driver.getTitle());
    }

    //@Test
    public void testPersonalLink() {
        wfHomePage.personalLink();
        String expectedResult = "Wells Fargo – Banking, Credit Cards, Loans, Mortgages & More";
        Assert.assertEquals(driver.getTitle(), expectedResult);
    }

    //@Test
    public void testSmallBusinessLink() {
        wfHomePage.smallBusinessLink();
        String expectedResult = "Wells Fargo Small Business - Online and Business Banking, Lending and Investing Services for Business";
        Assert.assertEquals(driver.getTitle(), expectedResult);
    }

    //@Test
    public void testFinancialEducationLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String expectedResult = "Financial Education – My Financial Guide – Wells Fargo";
        TestLogger.log("Link Title: " + expectedResult);
        Assert.assertEquals(wfHomePage.financialEducationLink(), expectedResult);
    }

    //@Test
    public void testCheckingAccountsLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String expectedResult = "Checking Accounts: Open Online Today | Wells Fargo";
        TestLogger.log("Link Title: " + expectedResult);
        Assert.assertEquals(wfHomePage.checkingAccountsLink(), expectedResult);
    }

    //@Test
    public void testSavingsAccountsCDLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String expectedResult = "Savings Account: Open Online Today | Wells Fargo";
        TestLogger.log("Link Title: " + expectedResult);
        Assert.assertEquals(wfHomePage.savingAccountsCDLink(), expectedResult);
    }

    //@Test
    public void testDebitCardsLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String expectedResult = "Debit Card: Request Today | Wells Fargo";
        TestLogger.log("Link Title: " + expectedResult);
        Assert.assertEquals(wfHomePage.debitCardsLink(), expectedResult);
    }

    //@Test
    public void testCreditCardsLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String expectedResult = "Credit Cards - Apply for Visa & American Express Credit Card Online | Wells Fargo";
        TestLogger.log("Link Title: " + expectedResult);
        Assert.assertEquals(wfHomePage.creditCardsLink(), expectedResult);
    }

    //@Test
    public void testForeignExchangeLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String expectedResult = "Foreign Exchange – Wells Fargo";
        TestLogger.log("Link Title: " + expectedResult);
        Assert.assertEquals(wfHomePage.foreignExchangeLink(), expectedResult);
    }

    //@Test
    public void testOnlineBankingLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String expectedResult = "Online Banking - Online Savings & Checking Accounts - Wells Fargo";
        TestLogger.log("Link Title: " + expectedResult);
        Assert.assertEquals(wfHomePage.onlineBankingLink(), expectedResult);
    }

    //@Test
    public void testTransferPayLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String expectedResult = "Transfer and Pay with Wells Fargo Online®";
        TestLogger.log("Link Title: " + expectedResult);
        Assert.assertEquals(wfHomePage.transferPayLink(), expectedResult);
    }

    //@Test
    public void testControlTowerLink() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String expectedResult = "Control Tower | Wells Fargo";
        TestLogger.log("Link Title: " + expectedResult);
        Assert.assertEquals(wfHomePage.controlTowerLink(), expectedResult);
    }
}
