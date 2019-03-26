package com.kiehls.qa.pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomerServicePage {

    @FindBy(css = ".header_customer_service")
    WebElement customerService;

    @FindBy(css = "b-cs_title")
    WebElement csTitle;

    @FindBy(xpath = "//h2[contains(text(),'Customer Service')]")
    WebElement csListTitle;

    @FindBy(xpath = "/ul[@class = 'b-category-left_navigation hidden-mobile']//li//a")
    List<WebElement> csList;

    public CustomerServicePage(){ PageFactory.initElements(CommonAPI.driver, this); }

    public CustomerServicePage validateCustomerServiceLink(){ customerService.click(); return new CustomerServicePage();}

    public void validatePageTitle(){ CommonAPI.driver.getTitle(); }

    public void validateTitleText(){csTitle.getText();}

    public void validatecsListTitle(){csListTitle.getText();}

    public ContactUsPage setCsList(String value) throws InterruptedException {
        validateCustomerServiceLink();
        for(int i=0; i<csList.size(); i++){
            if(csList.get(i).getText().equalsIgnoreCase(value)){
                csList.get(i).click();
                break;
            }
        }
        return new ContactUsPage();

    }

}
