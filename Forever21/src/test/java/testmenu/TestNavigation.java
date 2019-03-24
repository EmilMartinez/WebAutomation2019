package testmenu;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import menu.Navigation;
import base.CommonAPI;

public class TestNavigation extends CommonAPI {
    Navigation newNav;

    @BeforeMethod
    public void initialize() {
        newNav = PageFactory.initElements(driver, Navigation.class);
    }
//    @Test (priority = 1)
//    public void testWomenTab() throws Exception {
//        newNav.clickOnWomensTab();
//    }
//    @Test (priority = 2)
//    public void testAccessoriesTab() throws Exception{
//        newNav.clickOnAccessoriesTab();
//    }
//    @Test
//    public void testPlusSizeTab() throws Exception{
//        newNav.clickOnPlusSizeTab();
//    }
//    @Test
//    public void testMenTab() throws Exception{
//        newNav.clickMenTab();
//    }
//    @Test
//    public void testGirlTab() throws Exception{
//        newNav.clickGirlsTab();
//    }
//    @Test
//    public void testSaleTab() throws Exception{
//        newNav.clickSaleTab();
//    }

    @Test
    public void testViewAllTab() throws Exception, InterruptedException {
        newNav.hoverOverViewAllTab();
    }
    @Test
    public void testBestSellerTab() throws Exception, InterruptedException{
        newNav.hoverOverBestSellerTab();
    }
    @Test
    public void testBodysuitTab() throws Exception, InterruptedException{
        newNav.hoverOverBodysuitTab();
    }
    @Test
    public void testDressesTab() throws Exception, InterruptedException{
        newNav.hoverOverDressesTab();
    }
    @Test
    public void testJumpsuitsTab() throws Exception, InterruptedException{
        newNav.hoverOverJumpsuitsTab();
    }
    @Test
    public void testBlousesTab() throws Exception,InterruptedException{
        newNav.hoverOverBlousesTab();
    }
    @Test
    public void testSwimwearTab() throws Exception, InterruptedException{
        newNav.hoverOverSwimwearTab();
    }
    @Test
    public void testShortsTab ()throws Exception, InterruptedException{
        newNav.hoverOverShortsTab();
    }
    @Test
    public void testSetsTab ()throws Exception, InterruptedException{
        newNav.hoverOverSetsTab();
    }
    @Test
    public void testActivewearTab ()throws Exception, InterruptedException{
        newNav.hoverOverActivewearTab();
    }
    @Test
    public void test ()throws Exception, InterruptedException{
        newNav.hoverOverBottomsTab();
    }
    @Test
    public void testJeansTab ()throws Exception, InterruptedException{
        newNav.hoverOverJeansTab();
    }
    @Test
    public void testGraphicTeesTab ()throws Exception, InterruptedException{
        newNav.hoverOverGraphicTeesTab();
    }
    @Test
    public void testHoodiesTab ()throws Exception, InterruptedException{
        newNav.hoverOverHoodiesTab();
    }
    @Test
    public void testSleepwearTab ()throws Exception, InterruptedException{
        newNav.hoverOverSleepwearTab();
    }
    @Test
    public void testCoatsTab ()throws Exception, InterruptedException{
        newNav.hoverOverCoatsTab();
    }
    @Test
    public void testShoesTab ()throws Exception, InterruptedException{
        newNav.hoverOverShoesTab();
    }
    @Test
    public void testSweatersTab ()throws Exception, InterruptedException{
        newNav.hoverOverSweatersTab();
    }
}
