package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class CheckboxesPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void check(String checkboxName){
        if(!isSelected(By.xpath(String.format("//input[%s]", checkboxName)))) {
            click(By.xpath(String.format("//input[%s]", checkboxName)));
        }
    }

    public void uncheck(String checkboxName){
        if(isSelected(By.xpath(String.format("//input[%s]", checkboxName)))) {
            click(By.xpath(String.format("//input[%s]", checkboxName)));
        }
    }
    public boolean isCheckboxChecked(String checkboxName){
        return isSelected(By.xpath(String.format("//input[%s]", checkboxName)));
    }
    public boolean isCheckboxUnchecked(String checkboxName){
        return !isSelected(By.xpath(String.format("//input['%s']", checkboxName)));
    }

}
