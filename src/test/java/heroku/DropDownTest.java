package heroku;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static utils.Browser.*;
import pages.heroku.DropdownPage;

public class DropDownTest {
    DropdownPage dropdownPage;
    @BeforeClass
    void setup(){
        openBrowser("chrome");
        dropdownPage = new DropdownPage();
        dropdownPage.open();
    }
    @Test
    void Option1ShouldBeSelected(){
        dropdownPage.selectOption("Option 1");
        Assert.assertTrue(dropdownPage.isOptionSelected("Option 1"),"Option 1 is not selected");
    }
    @Test
    void Option2ShouldBeSelected(){
        dropdownPage.selectOption("Option 2");
        Assert.assertTrue(dropdownPage.isOptionSelected("Option 2"),"Option 2 is not selected");
    }

    @AfterClass
    void TearDown(){
        quit();
    }
}
