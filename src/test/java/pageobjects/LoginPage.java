package pageobjects;

import misc.HelperFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Krystian on 2015-09-14.
 */
    public class LoginPage extends BaseObject{

    public LoginPage(WebDriver driver){
        super(driver);
    }



        @FindBy(className = "account-navigation-item")
        private WebElement openLoginForm;

        @FindBy(name="username")
        private WebElement usernameInput;

        @FindBy(name="password")
        private WebElement passwordInput;

        @FindBy(className = "login-button")
        private WebElement loginButton;

        @FindBy(className = "logged-avatar-placeholder")
         private WebElement loggedInAvatar;

          public static LoginPage openLoginPage(WebDriver driver) {

        try {
            driver.get(HelperFunctions.getProperty("wikiaMainURL"));
        } catch (org.openqa.selenium.TimeoutException te) {
        }
        return new LoginPage(driver);
        }

        public LoginPage hoverOverLogin() {

            new Actions(driver).moveToElement(openLoginForm).perform();
            new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(loginButton));
            return this;
        }

        public MainPage loginToWikia() {

            hoverOverLogin();
            usernameInput.clear();
            usernameInput.sendKeys(HelperFunctions.getProperty("login"));
            passwordInput.clear();
            passwordInput.sendKeys(HelperFunctions.getProperty("password"));
            new Actions(driver).moveToElement(loginButton).clickAndHold().release().perform();
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(loggedInAvatar));
            return new MainPage(driver);
        }

        public boolean isUserLoginDropdownExpanded(){

            if(loginButton.isDisplayed()){
                return true;
            }
            return false;
        }
    }

