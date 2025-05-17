package heroku;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.HyperlinkPage;


import static utils.Browser.*;

public class HyperlinkTest {
    HyperlinkPage hyperlinkPage;

    @BeforeClass
    void setup(){
        openBrowser("chrome");
        hyperlinkPage = new HyperlinkPage();

    }

    @BeforeMethod
    void openPage(){
        hyperlinkPage.open();
    }

    @Test
    void redirect(){
        hyperlinkPage.clickStatusCode("here");
        Assert.assertEquals(getCurrentUrl(),"https://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml");
    }

    @Test
    void workAroundInStatusCodePage(){
        hyperlinkPage.clickStatusCode("200");
        Assert.assertTrue(hyperlinkPage.isStatusCodeDisplayed("200"),"Status code 200 is not displayed");
        hyperlinkPage.clickStatusCode("here");

        hyperlinkPage.clickStatusCode("301");
        Assert.assertTrue(hyperlinkPage.isStatusCodeDisplayed("301"),"Status code 301 is not displayed");
        hyperlinkPage.clickStatusCode("here");

        hyperlinkPage.clickStatusCode("404");
        Assert.assertTrue(hyperlinkPage.isStatusCodeDisplayed("404"),"Status code 404 is not displayed");
        hyperlinkPage.clickStatusCode("here");

        hyperlinkPage.clickStatusCode("500");
        Assert.assertTrue(hyperlinkPage.isStatusCodeDisplayed("500"),"Status code 500 is not displayed");
        hyperlinkPage.clickStatusCode("here");
    }

    @AfterClass
    void teardown(){
        quit();
    }

}
