package heroku;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.InfiniteScrollPage;

import static utils.Browser.openBrowser;

public class InfinieScrollTest {
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
}
