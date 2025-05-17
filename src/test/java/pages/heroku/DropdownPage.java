package pages.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utils.Browser.*;

public class DropdownPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/dropdown");
    }
    public void selectOption(String option){
        WebElement select = getDriver().findElement(By.id("dropdown"));
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText(option);
    }
    public boolean isOptionSelected(String option){
        WebElement select = getDriver().findElement(By.id("dropdown"));
        Select dropdown = new Select(select);
        return dropdown.getFirstSelectedOption().getText().equals(option);
    }
}
