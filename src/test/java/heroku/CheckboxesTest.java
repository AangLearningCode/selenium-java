package heroku;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.heroku.CheckboxesPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class CheckboxesTest {
    CheckboxesPage checkboxesPage;
    @BeforeClass
    void setup(){
        openBrowser("chrome");
        checkboxesPage = new CheckboxesPage();
        checkboxesPage.open();
    }

    @Test
    void VerifyDefaultCheckboxesState(){

        Assert.assertFalse(checkboxesPage.isCheckboxChecked("1"),"Checkbox1 is not selected by default");
        Assert.assertTrue(checkboxesPage.isCheckboxUnchecked("2"),"Checkbox2 is not selected by default");
    }
    @Test
    void VerifyCheckbox1AbleToBeChecked(){
        checkboxesPage.check("1");
        Assert.assertTrue(checkboxesPage.isCheckboxChecked("1"),"Checkbox1 is not selected by default");
        checkboxesPage.uncheck("1");
        Assert.assertFalse(checkboxesPage.isCheckboxChecked("1"),"Unable to uncheck checkbox1");
    }
    @Test
    void VerifyCheckbox2AbleToBeChecked(){
        checkboxesPage.check("2");
        Assert.assertTrue(checkboxesPage.isCheckboxChecked("2"),"Checkbox1 is not selected by default");
        checkboxesPage.uncheck("2");
        Assert.assertFalse(checkboxesPage.isCheckboxChecked("2"),"Unable to uncheck checkbox2");
    }
    @AfterClass
    void tearDown(){
        quit();
    }
}
