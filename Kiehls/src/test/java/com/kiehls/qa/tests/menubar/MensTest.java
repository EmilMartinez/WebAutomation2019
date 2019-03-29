package com.kiehls.qa.tests.menubar;

import base.CommonAPI;
import com.kiehls.qa.pages.menubar.Mens;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MensTest extends CommonAPI {
    Mens mens;

    @BeforeMethod
    public void initialize(){
        mens = PageFactory.initElements(this.driver, Mens.class);
    }

    @Test
    public void bodyLinkTest(){mens = mens.verifyMensLink();}

    @Test
    public void hoverOverBodyLinkTest() throws InterruptedException {
        mens.hoverOverMensLink();
    }

    @Test
    public void hoverOverDropDownLinkTest() throws InterruptedException {
        for (WebElement we : mens.getListOfMensLink()) {
            mens.hoverOverDropDownList(we);
        }
    }

    @Test
    public void setDropDownListTest() throws InterruptedException {
        mens.setDropDownSkinCare("Shave for Men");
    }

    @Test
    public void checkDropDownListTextTest() throws IOException, InterruptedException {
        List<WebElement> listOfWebElem = mens.getListOfMensLink();
        String [] listOfExpectedTexts = mens.getListOfTitleFromExcelFile();
        for(int i=0; i<listOfWebElem.size(); i++){
            mens.hoverOverMensLink();
            String expected = listOfExpectedTexts[i];
            String actual = listOfWebElem.get(i).getText();

            Assert.assertEquals(expected, actual);
        }
    }
}
