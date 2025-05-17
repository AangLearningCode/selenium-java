package heroku;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.InfiniteScrollPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class InfiniteScrollTest {
    InfiniteScrollPage infiniteScrollPage;

    @BeforeMethod
    public void setUp() {
        openBrowser("chrome");
        infiniteScrollPage = new InfiniteScrollPage();
        infiniteScrollPage.open();
    }

    @Test
    public void infiniteScrollTest() throws InterruptedException {
        infiniteScrollPage.scrollDown(5);
    }

    @AfterMethod
    public void tearDown() {
        quit();
    }
}
