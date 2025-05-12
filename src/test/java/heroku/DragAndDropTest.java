package heroku;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.DragAndDropPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class DragAndDropTest {
    DragAndDropPage dragAndDropPage;

    @BeforeMethod
    void setup() {
        openBrowser("chrome");
        dragAndDropPage = new DragAndDropPage();
        dragAndDropPage.open();
    }

    @Test
    void leftToRight() {
        dragAndDropPage.dragAndDropLeftToRight();
        Assert.assertEquals(dragAndDropPage.checkColumnA(), "B", "Column A text is not B");
    }

    @Test
    void rightToLeft() {
        dragAndDropPage.dragAndDropRightToLeft();
        Assert.assertEquals(dragAndDropPage.checkColumnA(), "B", "Column A text is not B");
    }

    @Test
    void rightToLeftThenLeftToRight() {
        dragAndDropPage.dragAndDropRightToLeft();
        Assert.assertEquals(dragAndDropPage.checkColumnA(), "B", "Column A text is not A");
        dragAndDropPage.dragAndDropLeftToRight();
        Assert.assertEquals(dragAndDropPage.checkColumnA(), "A", "Column A text is not B");
    }

    @AfterMethod
    void tearDown() {
        quit();
    }
}
