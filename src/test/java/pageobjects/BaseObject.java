package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Krystian on 2015-09-13.
 */
public class BaseObject {
    protected WebDriver driver;

    public BaseObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
