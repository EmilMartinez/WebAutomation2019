package testpageswellsfargo;

import base.CommonAPI;
import databases.ExcelData;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wellsfargopages.WFHomePage;

import java.util.List;
import java.util.WeakHashMap;

public class TestWFHomePage extends CommonAPI {

    WFHomePage wfHomePage;
    ExcelData excelData = new ExcelData();
    String path = "../WellsFargo/src/test/resources/KeywordData.xls";
    String title = "";

    @BeforeMethod
    public void initialize() {
        wfHomePage = PageFactory.initElements(this.driver, WFHomePage.class);
    }

    //@Test(description = "search")
    public void testSearchBar() {
        wfHomePage.searchBar("loans");
        title = driver.getTitle();
        driver.navigate().back();
    }

    //@Test(description = "dropdown")
    public void testDropDownOptions() {
        List<WebElement> elements = wfHomePage.dropDownOptions();
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    //@Test(description = "navigation")
    public void testCommercialLinks() {
        wfHomePage.commericialLink();
        String title = "Wells Fargo Commercial – Commercial Financing Services";
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Test
    public void testSteps() throws Exception {
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

    /*@Test
    public void testHomePageTabs() {
        List<String> tabTexts = wfHomePage.homePageTabs(driver);
        for (String tabText : tabTexts) {
            System.out.println(tabText);
        }
    }*/
}
