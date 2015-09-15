package testcases;

import misc.HelperFunctions;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;

/**
 * Created by Krystian on 2015-09-13.
 */
public class LoginTest extends BaseTest {
    private MainPage mainPage;
    private LoginPage loginPage;

    @Test
    public void LoginToWikia() {

        // Go to WikiaHomework and verify if redirected to the correct page
        loginPage = LoginPage.openLoginPage(driver);
        softAssert.assertEquals(driver.getCurrentUrl(),
                HelperFunctions.getProperty("redirectedFromWikiaMainURL"));

        // Hover mouse over login button and verify if login dropdown is
        // displayed
        loginPage.hoverOverLogin();
        softAssert.assertTrue(loginPage.isUserLoginDropdownExpanded(),
                "\n\nLogin dropdown is not visible!");

        // enter username and password, click login button and verify that user
        // is logged in and correct username is displayed
        mainPage = loginPage.loginToWikia();
        softAssert.assertTrue(mainPage.isLoggedIn(), "\nLogin failed");
        softAssert.assertAll();
    }

}
