package com.kiehls.qa.tests.menubar;

import base.CommonAPI;
import com.kiehls.qa.pages.menubar.SkinCare;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SkinCareTest extends CommonAPI {
    SkinCare skinCare;

    @BeforeMethod
    public void initialize(){
        skinCare = PageFactory.initElements(this.driver, SkinCare.class);
    }

    @Test
    public void clickSkinCareLinkTest(){skinCare.clickSkinCare();}

    @Test
    public void clickEachDropDownTest(){
        for(WebElement we : skinCare.getlistOfLinksSkinCare()){
            skinCare.hoverOverSkinCare();
            skinCare.clickOnElem(we);
            driver.navigate().back();
            CommonAPI.waitForPageLoad();
        }
    }

    @Test
    public void  hoverOverSkinCareTest(){
        boolean flag = skinCare.hoverOverSkinCare();
        Assert.assertTrue(flag);

    }

//    @Test
//    public void dropDownVisibilityTest(){
//        boolean flag = skinCare.verifyDropDownVisibility();
//        Assert.assertTrue(flag);
//    }

    @Test
    public void hoverOverDropDownTest(){
        for(WebElement we: skinCare.getlistOfLinksSkinCare()){
            skinCare.hoverOverDropDownLink(we);
        }
    }

    @Test
    public void checkDropDownText() throws IOException {
        List<WebElement> listOfWebElem = skinCare.getlistOfLinksSkinCare();
        String[] listOfActualText = skinCare.getListTitleFromExcelFile();
        for(int i=0; i<listOfWebElem.size(); i++){
            skinCare.hoverOverSkinCare();
            String expextedText = listOfActualText[i];
            String actualText = listOfWebElem.get(i).getText();

            Assert.assertEquals(expextedText, actualText);
        }

    }
}
