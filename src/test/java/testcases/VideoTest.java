package testcases;

import misc.HelperFunctions;
import org.testng.annotations.Test;
import pageobjects.*;

/**
 * Created by Krystian on 2015-09-13.
 */
public class VideoTest extends BaseTest {
    private AddVideoPage addvideopage;
    private AllVideosPage allvideospage;
    private String flashMessageFilename;
    private VideoPage videopage;
    private MainPage mainpage;
    private LoginPage loginPage;

    @Test
    public void addVideoTest(){
        // login to wikia
        loginPage = LoginPage.openLoginPage(driver);
        loginPage.hoverOverLogin();
            mainpage = loginPage.loginToWikia();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // expand contribute form
        mainpage.clickContributeButton();
        softAssert.assertTrue(mainpage.isContributeDropdownExpanded(),
                "\n\nContribute dropdown is not visible!");

        //go to add video page and check if URL is correct
        addvideopage = mainpage.clickGoToAddVideoPage();

        softAssert.assertEquals(driver.getCurrentUrl(),
                HelperFunctions.getProperty("wikiaVideoAddPageURL"));

        //pastes video URL and clicks "add" button
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        allvideospage = addvideopage.submitVideoLink(HelperFunctions.getProperty("videoToAddURL")).clickSubmitVideoButton();
        // finds if flash message is displayed
        softAssert.assertTrue(allvideospage.isFlashMessageDisplayed(),
                "\n\nElement with flash message is missing!");

        // gets "File:FILENAME" string from flash message
        flashMessageFilename = allvideospage.getFlashMessageLinkiText();

        // verifies if flash message displayed is correct
        softAssert.assertEquals(
                allvideospage.getFlashMessageText(),
                "Video page " + flashMessageFilename + " was successfully added.",
                "\n\nWrong flashmessage displayed!");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // click link on the flash message
        videopage = allvideospage.openFlashMessageLink();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        softAssert.assertEquals(driver.getCurrentUrl(),
                ("http://qm-homework.wikia.com/wiki/" + flashMessageFilename).replace(" ", "_"),
                "\n\nRedirected to wrong page !");

        //verify that new file is named correctly
        String actual = ("File:" + videopage.getVideoTitle()).replace(" ", "_");
        String expected = flashMessageFilename.replace(" ", "_");
        softAssert.assertEquals(actual, expected,
                "\n\nWrong filename displayed !");
        softAssert.assertAll();
    }

}
