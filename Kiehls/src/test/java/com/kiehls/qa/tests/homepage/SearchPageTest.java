package com.kiehls.qa.tests.homepage;

import base.CommonAPI;
import com.kiehls.qa.pages.Homepage.SearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPageTest extends CommonAPI {

    SearchPage searchPage = new SearchPage();

    @BeforeMethod
    public void initialize(){ this.searchPage = PageFactory.initElements(this.driver, SearchPage.class); }

    @Test
    public void searchItemsTest() throws Exception {

        searchPage.searchItemsAndSubmitButton();


    }
}