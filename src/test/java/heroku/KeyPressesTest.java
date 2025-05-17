package heroku;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.KeyPressesPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class KeyPressesTest {
    KeyPressesPage keyPressesPage;
    @BeforeMethod
    public void setUp() {
        openBrowser("chrome");
        keyPressesPage = new KeyPressesPage();
        keyPressesPage.open();
    }

    @Test
    public void pressEscape() {
        keyPressesPage.sendEscapeKey();
        Assert.assertTrue(keyPressesPage.getResultText().contains("You entered: ESCAPE"));
    }

    @Test
    public void pressEnter() {
        keyPressesPage.pressEnterKey();
        Assert.assertTrue(keyPressesPage.getText().contains("You entered: ENTER"));
    }

    @AfterMethod
    public void tearDown() {
        quit();
    }


}
