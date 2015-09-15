package testcases;

/**
 * Created by Krystian on 2015-09-13.
 */

import misc.HelperFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;


    @BeforeMethod
    public void setUp() {

        driver = getDriver();
        HelperFunctions.moveCursorOutOfTheWay();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        if(System.getProperty("drivertype").equals("firefox")){
            return new FirefoxDriver();
        }
        else if (System.getProperty("drivertype").equals("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("chromedriverpath"));
            return new ChromeDriver();
        }
        else return new FirefoxDriver();

    }

}

