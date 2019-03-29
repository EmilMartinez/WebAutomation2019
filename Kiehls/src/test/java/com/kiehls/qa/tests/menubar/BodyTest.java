package com.kiehls.qa.tests.menubar;

import base.CommonAPI;
import com.kiehls.qa.pages.menubar.Body;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BodyTest extends CommonAPI{
    Body body;

    @BeforeMethod
    public void initialize(){
        body = PageFactory.initElements(CommonAPI.driver, Body.class);
    }

    @Test
    public void bodyLinkTest(){body = body.verifyBodyLink();}

    @Test
    public void hoverOverBodyLinkTest() throws InterruptedException { body.hoverOverBody();

    }

    @Test
    public void  clickEachDropDownLinkTest() throws InterruptedException {
        for(WebElement we:body.getListOfLinksBody()){
            body.clickOnElem(we);
            driver.navigate().back();
            CommonAPI.waitForPageLoad();
        }

    }

    @Test
    public void hoverOverDropDownTest() throws InterruptedException {
        for(WebElement we:body.getListOfLinksBody()){
            body.hoverOverDropDownLink(we);
        }
    }

    @Test
    public void setDropDownBodyTest(){
      boolean flag = body.setDropDownBody("Musk");
        Assert.assertTrue(flag);
    }

    @Test
    public void checkDropDownText() throws IOException, InterruptedException {
        List<WebElement> listOfWebElem = body.getListOfLinksBody();
        String[] listOfActualTexts = body.getListTiltleFromExcelFile();
        for(int i=0; i<listOfWebElem.size(); i++){
            body.hoverOverBody();
            String expectedText = listOfActualTexts[i];
            String actualText = listOfWebElem.get(i).getText();

            Assert.assertEquals(expectedText, actualText);

        }
    }
}
