package pageobjects;

/**
 * Created by Krystian on 2015-09-13.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddVideoPage extends BaseObject{


    @FindBy(id = "wpWikiaVideoAddUrl")
    private WebElement typeVideoURL;

    @FindBy(xpath = "//input[@value='Add']")
    private WebElement submitVideoButton;

    @FindBy(className = "msg")
    private WebElement flashMessage;

    @FindBy(css = "msg > a")
    private WebElement flashMessageLink;

    public AddVideoPage(WebDriver driver) {
        super(driver);
    }

    public AddVideoPage submitVideoLink(String URL) {
        typeVideoURL.sendKeys(URL);

        return this;
    }

    public AllVideosPage clickSubmitVideoButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitVideoButton));
        submitVideoButton.click();

        return new AllVideosPage(driver);
    }

    public WebElement getFlashMessage() {

        return flashMessage;
    }

    public WebElement getFlashMessageLink() {
        return flashMessageLink;
    }

    public VideoPage openFlashMessageLink() {

        getFlashMessageLink().click();
        return new VideoPage(driver);
    }

}