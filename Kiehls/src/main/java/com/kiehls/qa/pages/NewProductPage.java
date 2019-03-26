package com.kiehls.qa.pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewProductPage extends CommonAPI {

    @FindBy(css = "level_1_list_item_link category_link whats-new class.navigation.list.link")
    WebElement newLink;

    @FindBy(xpath = "//ul[contains(@class, 'level_2_list')//li//a//")
    List<WebElement> newItemsLink;

    @FindBy(xpath = "//h3[contains(@class, 'Concern')]")
    WebElement concernLabel;

    @FindBy(xpath = "//ul[contains(@class, 'refinement_list toggle_content')]//li")
    List<WebElement> concerList;

    @FindBy(xpath = "//h3[contains(text(),'Price')]")
    WebElement price;

    @FindBy(xpath = "//div[@id='clp_banner']//span[contains(text(),'New Skincare Products')]")
    WebElement NewSkincareProductsImg;

    @FindBy(xpath = "//div[contains(@class,'search_result_options')]//span[contains(@class,'sort_by_label class.category.sorting.label')][contains(text(),'Sort By:')]")
    WebElement sortByText;

    @FindBy(xpath = "//div[contains(@class,'search_result_options')]//select[contains(@name,'sort_by_list')]//option")
    List<WebElement> sortByDropDownList;

    public NewProductPage(){ PageFactory.initElements(driver, this); }

    public void  validateTitle(){ driver.getTitle();}

    public void ValidateMouseHoverToNew() throws InterruptedException {
        newLink.click();
    }

    public void validateJustArrived(String value){
        for (int i = 0; i < newItemsLink.size(); i++) {
            if (newItemsLink.get(i).getText().equalsIgnoreCase(value)){
                newItemsLink.get(i).click();
                break;
            }
        }
    }

    public void validateConcernLabel() {concernLabel.isDisplayed();}

    public void validateConcernList(String value) throws InterruptedException {
        ValidateMouseHoverToNew();
        CommonAPI.sleepFor(1000);
        for(int i=0; i<concerList.size(); i++){
            if(concerList.get(i).getText().contains(value)){
                concerList.get(i).click();
                break;
            }
        }
    }

    public void validatePriceLink(){price.isDisplayed();}

    public void validateNewSkincareProductsImg(){NewSkincareProductsImg.isDisplayed();}

    public void validateSortByText(){sortByText.isDisplayed();}

    public void validateSortByList(String value){
        for(int i=0; i<sortByDropDownList.size(); i++){
            if(sortByDropDownList.get(i).getText().equalsIgnoreCase(value)){
                sortByDropDownList.get(i).click();
                break;
            }
        }
    }

}
