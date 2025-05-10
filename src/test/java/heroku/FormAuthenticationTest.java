package heroku;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.heroku.FormAuthentificationPage;

import static utils.Browser.*;

public class FormAuthenticationTest {
    FormAuthentificationPage formAuthenticationPage;

    @Parameters({"browser"})
    @BeforeMethod
    void load(String browser) {
        openBrowser(browser);
        formAuthenticationPage = new FormAuthentificationPage();
        formAuthenticationPage.open();
    }

    @Test
    void testValidLogin() {

        formAuthenticationPage.fillForm("tomsmith","SuperSecretPassword!");
        formAuthenticationPage.clickLoginButton();

        Assert.assertTrue(formAuthenticationPage.getResultText().contains("You logged into a secure area!"));
        Assert.assertEquals(getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

    }
    @AfterMethod
    void tearDown() {
        quit();
    }
}
