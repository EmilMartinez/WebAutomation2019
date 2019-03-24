package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;
    public String browserstack_username= "";
    public String browserstack_accesskey = "";
    public String saucelabs_username = "";
    public String saucelabs_accesskey = "";

    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false")String cloudEnvName,
                      @Optional("OS X") String os, @Optional("10") String os_version, @Optional("chrome-options") String browserName, @Optional("34")
                              String browserVersion, @Optional("http://www.amazon.com") String url)throws IOException {
        if(useCloudEnv==true){
            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browserName, browserVersion);
            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browserName, browserVersion);
            }
        }else{
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.get(url);
        // driver.navigate().to(url);
        // driver.navigate().refresh();
        driver.manage().window().maximize();
    }
    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "../generic/browser-driver/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../generic/browser-driver/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("chrome-options")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "../generic/browser-driver/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../generic/browser-driver/chromedriver.exe");
            }
            driver = new ChromeDriver(options);
        }

        else if(browserName.equalsIgnoreCase("firefox")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.gecko.driver", "../generic/browser-driver/geckodriver");
            }else if(OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.gecko.driver", "../generic/browser-driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();

        } else if(browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "../generic/browser-driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }


    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
                                    String browserVersion)throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            //resolution for Saucelabs
            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }



    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    /**
     * Typing value of a general locator. Method will choose what technique to use.
     *
     * @param locator: locator technique: cssSelector, name, xpath and id.
     * @param value: Value being assigned to the locator.
     */
    public void typeOnElem(String locator, String value) {
        try {
            // Check by cssSelector
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception e1) {
            try {
                // Check by name
                driver.findElement(By.name(locator)).sendKeys(value);
            } catch (Exception e2) {
                try {
                    // Check by xpath
                    driver.findElement(By.xpath(locator)).sendKeys(value);
                } catch (Exception e3) {
                    // Check by id
                    driver.findElement(By.id(locator)).sendKeys(value);
                }
            }
        }
    }

    /**
     * Typing value of a general locator. Method will choose what technique to use and hit 'ENTER'
     *
     * @param locator: locator technique(cssSelector, name, xpath and id).
     * @param value: Value being assigned to the locator.
     */
    public static void typeOnElementNEnter(String locator, String value) {
        try {
            // Check and enter by cssSelector
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception e1) {
            try {
                // Check and enter by name
                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception e2) {
                try {
                    // Check and enter by xpath
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception e3) {
                    // Check and enter by id
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }

    /**
     *  Checking with locator technique and clicking on it.
     *
     * @param locator: locator technique(cssSelector, name, xpath and id)
     */
    public void clickOnElem(String locator) {
        try {
            // Check and click by cssSelector
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception e1) {
            try {
                // Check and click by name
                driver.findElement(By.name(locator)).click();
            } catch (Exception e2) {
                try {
                    // Check and click by xpath
                    driver.findElement(By.xpath(locator)).click();
                } catch (Exception e3) {
                    // Check and click by id
                    driver.findElement(By.id(locator)).click();
                }
            }
        }
    }

    /**
     *  Checking with locator technique and hitting 'ENTER' on it.
     *
     * @param locator: locator technique(cssSelector, name, xpath and id)
     */
    public void enterOnElem(String locator) {
        try {
            // Check and enter by cssSelector
            driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
        } catch (Exception e1) {
            try {
                // Check and enter by name
                driver.findElement(By.name(locator)).sendKeys(Keys.ENTER);
            } catch (Exception e2) {
                try {
                    // Check and enter by xpath
                    driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
                } catch (Exception e3) {
                    // Check and enter by id
                    driver.findElement(By.id(locator)).sendKeys(Keys.ENTER);
                }
            }
        }
    }

    /**
     *  Checking with locator technique and clearing its value.
     *
     * @param locator: locator technique(cssSelector, name, xpath and id)
     */
    public void clearInputField(String locator) {
        try {
            // Check and clear by cssSelector
            driver.findElement(By.cssSelector(locator)).clear();
        } catch (Exception e1) {
            try {
                // Check and clear by name
                driver.findElement(By.name(locator)).clear();
            } catch (Exception e2) {
                try {
                    // Check and clear by xpath
                    driver.findElement(By.xpath(locator)).clear();
                } catch (Exception e3) {
                    // Check and clear by id
                    driver.findElement(By.id(locator)).clear();
                }
            }
        }
    }

    /**
     * Server sleeps for 2000 milliseconds.
     * @throws InterruptedException
     */
    public static void sleepForTwoSec() throws InterruptedException {
        Thread.sleep(2000);
    }

    /**
     * Server sleeps for user's given seconds.
     *
     * @param sec: Number of seconds for the server to sleep.
     * @throws InterruptedException
     */
    public static void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    /**
     * Returns current page's URL
     *
     * @return: String of the url.
     */
    public String getCurrUrl() {
        return driver.getCurrentUrl();
    }
}