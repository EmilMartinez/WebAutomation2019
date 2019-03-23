/*package com.homedepo.qa.pages;


import com.homedepo.qa.inputdata.SearchItems;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchPage {

     searchItems = new SearchItems();

    @FindBy(how = How.CSS, using = "#gh-tb ui-autocomplete-input ")
    public static WebElement searchInputWebElement;


    @FindBy(how = How.CSS, using = "#btn btn-prim gh-spr")
    public  static WebElement submitButtonWebElement;


    public WebElement getSearchInputWebElement(){

        return searchInputWebElement;

    }

   public WebElement getSubmitButtonWebElement(){

        return  submitButtonWebElement;

    }

   public void searchFor(String value){

        getSearchInputWebElement().sendKeys(value);
    }

   public void submitSearchButton(){

        getSubmitButtonWebElement().click()
        ;
    }
   public void clearInput() {

        getSearchInputWebElement().clear();
    }

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

        return searchInputWebElement;
   }

   public void setSearchInputWebElement(WebElement searchInputField){

        this.searchInputWebElement = searchInputField;
   }

   public void searchItems() throws Exception {

        List<String> itemList = searchItems.getItemsListFromDB();

        for(String st: itemList){

          getSearchInputField().sendKeys(st, Keys.ENTER);
          getSearchInputField().clear();
            //validate items

        }
   }


}*/
