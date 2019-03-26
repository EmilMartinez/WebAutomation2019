package com.kiehls.qa.tests;

import base.CommonAPI;
import com.kiehls.qa.pages.LocationsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

public class LocationsPageTest extends CommonAPI {

    LocationsPage locationsPage;

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
    public void filterTextTest(){
       String text = locationsPage.verifyFilterText();
        Assert.assertEquals(text, "Filter");
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
        Assert.assertEquals(text, "");
    }

}
