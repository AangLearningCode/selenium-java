package moatazeldebsy;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.moatazeldebsy.CheckboxesPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class CheckboxesTest {
    CheckboxesPage checkboxesPage;

    @BeforeMethod
    public void setUp() {
        openBrowser("chrome");
        checkboxesPage = new CheckboxesPage();
        checkboxesPage.open();
    }

    @Test
    public void defaultCheckboxes() {
        Assert.assertTrue(checkboxesPage.isUnchecked("1"),"Checkbox 1 is checked");
        Assert.assertTrue(checkboxesPage.isChecked("2"),"Checkbox 2 is unchecked");
        Assert.assertTrue(checkboxesPage.isUnchecked("3"),"Checkbox 3 is checked");
    }

    @Test
    public void checkAllButton() {
        checkboxesPage.clickCheckAllButton();
        Assert.assertTrue(checkboxesPage.isChecked("1"),"Checkbox 1 is unchecked");
        Assert.assertTrue(checkboxesPage.isChecked("2"),"Checkbox 2 is unchecked");
        Assert.assertTrue(checkboxesPage.isChecked("3"),"Checkbox 3 is unchecked");
    }

    @Test
    public void uncheckAllButton() {
        checkboxesPage.clickUncheckAllButton();
        Assert.assertTrue(checkboxesPage.isUnchecked("1"),"Checkbox 1 is checked");
        Assert.assertTrue(checkboxesPage.isUnchecked("2"),"Checkbox 2 is checked");
        Assert.assertTrue(checkboxesPage.isUnchecked("3"),"Checkbox 3 is checked");
    }

    @Test
    public void checkCheckbox1Test() {
        checkboxesPage.check("1");
        Assert.assertTrue(checkboxesPage.isChecked("1"),"Checkbox 1 is unchecked");
        checkboxesPage.uncheck("1");
        Assert.assertTrue(checkboxesPage.isUnchecked("1"),"Checkbox 1 is checked");
    }

    @Test
    public void checkCheckbox2Test() {
        checkboxesPage.uncheck("2");
        Assert.assertTrue(checkboxesPage.isUnchecked("2"),"Checkbox 2 is checked");
        checkboxesPage.check("2");
        Assert.assertTrue(checkboxesPage.isChecked("2"),"Checkbox 2 is unchecked");
    }

    @Test
    public void checkCheckbox3Test() {
        checkboxesPage.check("3");
        Assert.assertTrue(checkboxesPage.isChecked("3"),"Checkbox 3 is unchecked");
        checkboxesPage.uncheck("3");
        Assert.assertTrue(checkboxesPage.isUnchecked("3"),"Checkbox 3 is checked");
    }

    @AfterMethod
    public void tearDown() {
        quit();
    }
}
