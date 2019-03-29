package com.kiehls.qa.tests.footprint;

import base.CommonAPI;
import com.kiehls.qa.pages.CustomerServicePage;
import com.kiehls.qa.pages.footprint.LocationsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocationsPageTest extends CommonAPI {

    LocationsPage locationsPage;
    CustomerServicePage customerServicePage;

    @BeforeMethod
    public void  initialize(){
        locationsPage = PageFactory.initElements(driver, LocationsPage.class);
    }


    @Test
    public void TitleTest(){
        String title = locationsPage.verifyPageTitle();
        Assert.assertEquals(title, "Find the nearest Kiehl's location near you | Skincare, Hair, Body Care");
    }

    @Test
    public void storeLocatorLink(){
        locationsPage = locationsPage.validateStoreLocatorLink();
    }

    @Test
    public void verifyURLTest(){
        String url = locationsPage.verifyURL();
        Assert.assertEquals(url, "https://stores.kiehls.com/search.html");
    }
    @Test
    public void filterTextTest(){
       String text = locationsPage.verifyFilterText();
        Assert.assertEquals(text, "FILTER");
    }

    @Test
    public void phoneNumTest(){
        String phoneNum = locationsPage.verifyPhoneNum();
        Assert.assertEquals(phoneNum, "1-800-543-4572");
    }

    @Test
    public void findStoreTextTest(){
       String text = locationsPage.verifyFindStoreText();
       Assert.assertEquals(text, "Find a Kiehl's Store Near You");
    }

    @Test
    public void MainSubHeadingTest(){
        String text = locationsPage.verifyMainSubHeading();
        Assert.assertEquals(text, "Complimentary services, in-store pickup, and more!");
    }

    @Test
    public void storePickUpLinkTest(){
        locationsPage.verifyFindStoreText();
    }

    @Test

    public void searchButtnText(){
        boolean flag = locationsPage.verifySearchButtnText();
        Assert.assertTrue(flag);
    }

    @Test
    public void searchInputTest(){
        locationsPage.verifySearchInputBox("10010");
    }

    @Test
    public void dropDownTest(){
        locationsPage.ValidateSelectStore("Department Stores");
    }


    @Test
    public void validateCustomerServiceLinkTest(){
        customerServicePage = locationsPage.validateCustomerServiceLink();
    }

    @Test
    public void verifyAllLocationsLinkTest(){
        locationsPage = locationsPage.verifyAllLocationsLink();
    }

}
