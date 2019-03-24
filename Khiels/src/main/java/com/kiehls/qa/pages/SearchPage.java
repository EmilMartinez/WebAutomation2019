package com.kiehls.qa.pages;

import com.kiehls.qa.inputdata.SearchItems;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage {

    SearchItems searchItems = new SearchItems();

    @FindBy(xpath= "//input[@placeholder='Search']")
    public static WebElement searchInput;

    @FindBy(xpath = "//button[contains(text(),'Go')]")
    public  static WebElement submitButton;


    public WebElement getSearchInput(){ return searchInput; }

    public WebElement getSubmitButtonWebElement(){ return  submitButton; }

    public void searchFor(String value){ getSearchInput().sendKeys(value); }

    public void submitSearchButton() { getSubmitButtonWebElement().click(); }

   public void clearInput() { getSearchInput().clear(); }

   public void searchItemsAndSubmitButton() throws Exception {

        List<String> list = searchItems.getItemsListFromDB();

        for(int i = 0; i <list.size(); i++){
            searchFor(list.get(i));
            submitSearchButton();
            clearInput();
        }

   }

   public void searchItemsAndSubmitButton(WebDriver driver) throws Exception {

        List<String> list = searchItems.getItemsListFromDB();

        for(int i = 0; i < list.size(); i++){

            searchFor(list.get(i));
            submitSearchButton();
            clearInput();
        }

   }

   public void searchItemsAndSubmitButtonFromExcelFile(){

        List<String> list = null;

        for(int i = 0; i < list.size(); i++){
            searchFor(list.get(i));
            submitSearchButton();
            clearInput();
       }
   }

   public WebElement getSearchInputField(){

        return searchInput;
   }

   public void setSearchInputWebElement(WebElement searchInputField){

        this.searchInput = searchInputField;
   }

   public void searchItems() throws Exception {

        List<String> itemList = searchItems.getItemsListFromDB();

        for(String st: itemList){

          getSearchInputField().sendKeys(st, Keys.ENTER);
          getSearchInputField().clear();
            //validate items

        }
   }


}
