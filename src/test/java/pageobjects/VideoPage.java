package pageobjects;

/**
 * Created by Krystian on 2015-09-13.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class  VideoPage extends BaseObject{

    @FindBy(css ="#WikiaPageHeader > div > div.header-column.header-title > h1")
    private WebElement videoName;

    public VideoPage(WebDriver driver){
        super(driver);
    }

    public String getVideoTitle(){
        return videoName.getText();
    }
}