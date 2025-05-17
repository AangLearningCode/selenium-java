package heroku;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.HoverPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class HoversTest {
    HoverPage hoverPage;

    @BeforeMethod
    void setup() {
        openBrowser("chrome");
        hoverPage = new HoverPage();
        hoverPage.open();
    }

    @Test
    void hoverOverAvatar1() {
        hoverPage.hoverOverAvatar("1");
        Assert.assertTrue(hoverPage.isAvatarTextDisplayed(), "Avatar text is not displayed");
        Assert.assertTrue(hoverPage.isProfileUrlDisplayed(), "Profile URL is not displayed");
    }

    @AfterMethod
    void tearDown() {
        quit();
    }
}
