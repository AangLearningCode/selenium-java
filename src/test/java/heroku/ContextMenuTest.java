package heroku;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.ContextMenuPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class ContextMenuTest {
    ContextMenuPage contextMenu;

    @BeforeMethod
    public void setUp() {
        openBrowser("chrome");
        contextMenu = new ContextMenuPage();
        contextMenu.open();
    }

    @Test
    public void contextMenuTest() {
        contextMenu.rightClickToContextBox();
        Assert.assertEquals(contextMenu.getAlertText(), "You selected a context menu");
        contextMenu.acceptAlert();
    }

    @AfterMethod
    public void tearDown() {
        quit();
    }
}
