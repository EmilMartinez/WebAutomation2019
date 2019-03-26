package com.kiehls.qa.tests;

import base.CommonAPI;
import com.kiehls.qa.pages.ContactUsPage;
import com.kiehls.qa.pages.CustomerServicePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerServicePageTest extends CommonAPI {

    CustomerServicePage customerServicePage;
    ContactUsPage contactUsPage;

    @BeforeMethod

    public void initialization() {
        this.customerServicePage = PageFactory.initElements(driver, CustomerServicePage.class);
    }

//    @Test
//
//    public void setCustomerServiceLinkTest() {
//
//        customerServicePage = customerServicePage.validateCustomerServiceLink();
//
//    }

    @Test

    public void csListTest() throws InterruptedException {

        contactUsPage = customerServicePage.setCsList("Contact US");
    }
}
