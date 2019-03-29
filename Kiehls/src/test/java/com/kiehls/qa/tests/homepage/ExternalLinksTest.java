package com.kiehls.qa.tests.homepage;

import base.CommonAPI;
import com.kiehls.qa.pages.Homepage.ExternalLinks;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExternalLinksTest extends CommonAPI{

    ExternalLinks externalLinks;

    @BeforeMethod
    public void initialize(){
        externalLinks = PageFactory.initElements(CommonAPI.driver, ExternalLinks.class);
    }

    @Test
    public void verifyExploreMoreLinkTest() throws Exception {
        externalLinks.verifyExploreMoreLink();
        //Assert.assertEquals(link, "https://www.kiehls.com/gallery.html");
    }

    @Test
    public void verifyFooterFieldTest(){
        boolean flag= externalLinks.verifyFooterField();
        Assert.assertTrue(flag);
    }
    @Test
    public void verifyMessengerLinkTest() throws Exception {
       externalLinks.verifyMessengerLink();


    }
    @Test
    public void verifyFacebookLinkTest() throws Exception {
        externalLinks.verifyFacebookLink();
        //Assert.assertEquals(faceLink, "https://www.facebook.com/KiehlsUS/");

    }
    @Test
    public void verifyTwitterLinkTest() throws Exception {
        externalLinks.verifyTwitterLink();
        //Assert.assertEquals(twLink, "https://twitter.com/kiehls");

    }
    @Test
    public void verifyYTLinkTest() throws Exception {
       externalLinks.verifyYTLink();
        //Assert.assertEquals(ytLink, "https://www.youtube.com/kiehls");

    }
    @Test
    public void verifyInstagramLinkTest() throws Exception {
       externalLinks.verifyInstagramLink();
        //Assert.assertEquals(ytLink, "https://www.instagram.com/kiehls/");

    }

    @Test
    public void verifyPintersLinkTest() throws Exception {
        externalLinks.verifyPintersLink();
        //Assert.assertEquals(pintersLink, "https://www.pinterest.com/kiehlssince1851");

    }


}
