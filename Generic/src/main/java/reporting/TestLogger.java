package reporting;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class TestLogger {
   public static ExtentTest test;
    public static void log(final String message){
        //Reporter.log(message,true);
        ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
    }
    public static void log(final StringUtils message){
        Reporter.log(message + "<br>",true);
        ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
    }
    public static void log(final String message, WebDriver driver){
        Reporter.log(message,true);
        ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
    }

    public static void screenShot(String path, String testName) {
        ExtentTest test = ExtentTestManager.startTest(testName, "fail");
        test.log(LogStatus.INFO, "Failed Test Image"+ test.addBase64ScreenShot(path));
    }

    public static void screenShotPass(String path, String testName) {
        ExtentTest test = ExtentTestManager.startTest(testName, "Image");
        test.log(LogStatus.PASS, "Screen shot"+ test.addBase64ScreenShot(path));
    }


}
