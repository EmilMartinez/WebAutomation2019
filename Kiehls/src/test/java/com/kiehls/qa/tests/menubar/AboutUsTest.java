package com.kiehls.qa.tests.menubar;

import base.CommonAPI;
import com.kiehls.qa.pages.menubar.AboutUs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class AboutUsTest extends CommonAPI {
    AboutUs aboutUs;

    @BeforeMethod
    public void initialize(){aboutUs = PageFactory.initElements(this.driver, AboutUs.class); }

    @Test

    public void aboutusLinkTest(){
        aboutUs = aboutUs.verifyAboutUsLink();
    }

    @Test
    public void hoverOverTest() throws InterruptedException {
        aboutUs.hoverOverAboutUsLink();
    }

    @Test
    public void hoverOverDropDownListTest() throws InterruptedException {
        for(WebElement we : aboutUs.getListOfLinksAboutUS()){
            aboutUs.hoverOverDropDownList(we);
        }
    }
    @Test
    public void clickEachDropDownTest() throws InterruptedException {
        aboutUs.clickDropDownElem();
    }

   @Test
    public void setDropDownLinkTest() throws InterruptedException {
        aboutUs.setDropDownLink("Charity");
   }

   @Test
    public void checkDropDownTextTest() throws IOException, InterruptedException {
       List<WebElement> listOfWebElem = aboutUs.getListOfLinksAboutUS();
       String[] listOfActualTexts = aboutUs.getListOfTitleFromExcelFile();
       for(int i=0; i<listOfWebElem.size(); i++){
           aboutUs.hoverOverAboutUsLink();
           String expected = listOfActualTexts[i];
           String actual = listOfWebElem.get(i).getText();
           Assert.assertEquals(expected, actual);

       }


   }

}
