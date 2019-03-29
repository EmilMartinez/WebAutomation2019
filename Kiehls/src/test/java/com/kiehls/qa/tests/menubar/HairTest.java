package com.kiehls.qa.tests.menubar;

import base.CommonAPI;
import com.kiehls.qa.pages.menubar.Hair;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HairTest extends CommonAPI {

    Hair hair;

    @BeforeMethod
    public void initialize(){hair = PageFactory.initElements(this.driver, Hair.class); }

    @Test
    public void hairLinkTest(){
        hair = hair.verifyHariLink();
    }

    @Test
    public void hoverOverTest() throws InterruptedException {
        hair.hoverOverHairLink();
    }

    @Test
    public void hoverOverDropDownListTest() throws InterruptedException {
        for(WebElement we : hair.getListOfLinksHair()){
            hair.hoverOverDropDownList(we);
        }
    }
    @Test
    public void clickEachDropDownTest() throws InterruptedException {
        hair.clickDropDownElem();
    }

    @Test
    public void setDropDownLinkTest() throws InterruptedException {
        hair.setDropDownLink("Charity");
    }

    @Test
    public void checkDropDownTextTest() throws IOException, InterruptedException {
        List<WebElement> listOfWebElem = hair.getListOfLinksHair();
        String[] listOfActualTexts = hair.getListOfTitleFromExcelFile();
        for(int i=0; i<listOfWebElem.size(); i++){
            hair.hoverOverHairLink();
            String expected = listOfActualTexts[i];
            String actual = listOfWebElem.get(i).getText();
            Assert.assertEquals(expected, actual);

        }


    }

}

