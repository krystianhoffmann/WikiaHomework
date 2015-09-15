package pageobjects;

/**
 * Created by Krystian on 2015-09-13.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseObject{

    @FindBy(className = "account-navigation-item")
    private WebElement openLoginForm;

    @FindBy(how = How.CSS, using = "div.buttons > nav")
    private WebElement contributeButton;

    @FindBy(className = "logged-avatar-placeholder")
    private WebElement loggedInAvatar;

    @FindBy(linkText = "Add a Video")
    private WebElement addVideoMenuOption;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public boolean isLoggedIn() {
        if (loggedInAvatar.isDisplayed()) {
            return true;
        } else
            return false;
    }

    public boolean isContributeDropdownExpanded(){
        if(addVideoMenuOption.isDisplayed()){
            return true;
        }
        else return false;
    }

    public MainPage clickContributeButton(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(contributeButton));
        contributeButton.click();
        return this;
    }
    public AddVideoPage clickGoToAddVideoPage() {

        addVideoMenuOption.click();

        return new AddVideoPage(driver);
    }

}
