package heroku;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.HorizontalSliderPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class HorizontalSliderTest {
    HorizontalSliderPage horizontalSliderPage;

    @BeforeMethod
    public void openPage() {
        openBrowser("chrome");
        horizontalSliderPage = new HorizontalSliderPage();
        horizontalSliderPage.open();
    }

    @Test
    public void testSliderToMax() {
        horizontalSliderPage.sliderToMax();
        Assert.assertEquals(horizontalSliderPage.getSliderValue(), "5");
    }

    @Test
    public void testSliderToMin() {
        horizontalSliderPage.sliderToMax();
        horizontalSliderPage.sliderToMin();
        Assert.assertEquals(horizontalSliderPage.getSliderValue(), "0");
    }

    @Test
    public void testSliderToValue() {
        horizontalSliderPage.sliderToValue(4);
        Assert.assertEquals(horizontalSliderPage.getSliderValue(), "4");
    }

    @AfterMethod
    public void tearDown() {
        quit();
    }
}
