package pageobjects;

/**
 * Created by Krystian on 2015-09-13.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVideosPage extends BaseObject {


    @FindBy(className = "msg")
    private WebElement flashMessage;

    @FindBy(css = ".msg > a")
    private WebElement flashMessageLink;

    public AllVideosPage( WebDriver driver){
        super(driver);
    }

    public boolean isFlashMessageDisplayed(){
        return 	flashMessage.isDisplayed();
    }

    public String getFlashMessageText(){
        return flashMessage.getText();
    }

    public String getFlashMessageLinkiText(){
        return flashMessageLink.getText();
    }


    public VideoPage openFlashMessageLink() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(flashMessageLink));
        new Actions(driver).moveToElement(flashMessageLink).clickAndHold().release().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("WikiaMainContentContainer")));
        return new VideoPage(driver);
    }
}
