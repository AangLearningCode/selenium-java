package heroku;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.heroku.FormAuthentificationPage;
import static utils.Browser.*;

public class BasicAuthenticationTest {
    FormAuthentificationPage formAuthenticationPage;
    @Parameters({"browser"})
    @BeforeMethod
    void setup(String browser){
        openBrowser(browser);
    }

    @Test (priority = 1)
    void VerifyBasicAuthentication(){
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        Assert.assertEquals(getCurrentUrl(),"https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
}
