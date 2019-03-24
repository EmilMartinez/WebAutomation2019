package com.kiehls.qa.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerServicePage {


    @FindBy(css = ".customer_service_dropdown")
    WebElement customerService;

    public void validateCustomerService(){ customerService.click();}
}
