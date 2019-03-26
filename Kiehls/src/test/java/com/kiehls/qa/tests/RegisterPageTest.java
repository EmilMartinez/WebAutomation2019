package com.kiehls.qa.tests;

import base.CommonAPI;
import com.kiehls.qa.inputdata.ReadProperties;
import com.kiehls.qa.pages.HomePage;
import com.kiehls.qa.pages.RegisterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.DataReader;

import java.io.IOException;


public class RegisterPageTest extends CommonAPI {
    RegisterPage registerPage;
    ReadProperties rp = new ReadProperties();
    HomePage homePage;
    DataReader dataReader = new DataReader();

    @BeforeMethod
    public void initialize() {
        registerPage = PageFactory.initElements(this.driver, RegisterPage.class);
    }

    @Test
    public void titleTest(){
        String title = registerPage.verifyTitle();
        Assert.assertEquals(title, "Kiehl’s – Naturally Inspired Skin Care, Body and Haircare");}

     @Test
     public void createAccountPageTitleTest(){
        String title = registerPage.verifyCreateAccountPageTitle();
        Assert.assertEquals(title, "Create Account");
     }

    @Test
   public void checkBoxTest() {
        boolean flag = registerPage.validateCheckBox();
        Assert.assertTrue(flag);}

   @Test
   public void newToKeihlsTextTest(){
       String text =  registerPage.validateNewToKeihlsText();
       Assert.assertEquals(text, "NEW TO KIEHL’S?");
    }

    @Test
    public void createAccountTextTest(){
        String text = registerPage.validateCreateAccountText();
        Assert.assertEquals(text, "CREATE ACCOUNT");
    }

    @Test
    public void forUSCustomerOnlyTextTest(){
        String text = registerPage.validateForUSCustomerOnlyText();
        Assert.assertEquals(text, "*For U.S. Consumers Only");}

    @Test
    public void kiehlsRewardsImgTest(){
        boolean flag = registerPage.validateKiehlsRewardsImg();
        Assert.assertTrue(flag);
    }

    @Test
    public void kiehlsRewardsTextTest(){
        boolean flag = registerPage.validateKiehlsRewardsText();
        Assert.assertTrue(flag);
    }

    @Test
    public void stayInTouchTest(){
        boolean flag = registerPage.vlaidateStayInTouchText();
        Assert.assertTrue(flag);
    }

    @DataProvider
    public Object[][] getTestDataFromExcelSheet() throws IOException {
       Object[][] testData = dataReader.fileReader1("C:\\Users\\Mira\\Documents\\GitHub\\WebAutomation2019\\" +
               "Kiehls\\src\\test\\resources\\TestData\\KiehlsSigUpTestData.xls", "SignUp");
        return testData;

    }

    @Test(dataProvider =  "getTestDataFromExcelSheet")
    public void registrationTest(String firstName, String lastName, String email, String password, String confirmPassword, String month, String day, String year) throws IOException, InterruptedException {
//        String fName = rp.loadProperties().getProperty("firstName");
//        String lName = rp.loadProperties().getProperty("lastName");
//        String mail = rp.loadProperties().getProperty("email");
//        String pword = rp.loadProperties().getProperty("password");
//        String confirmPassword = "loveK@1234";
//        String month = rp.loadProperties().getProperty("month");
//        String day = rp.loadProperties().getProperty("day");
//        String year = rp.loadProperties().getProperty("year");
        homePage = registerPage.validateRegistration(firstName, lastName,  email,  password,  confirmPassword,  month,  day,  year);
    }


}

