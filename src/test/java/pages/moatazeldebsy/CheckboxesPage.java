package pages.moatazeldebsy;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class CheckboxesPage {
    public void open(){
        visit("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
    }

    public void check(String checkboxName) {
        if (!isSelected(By.xpath(String.format("//input[@data-test='checkbox-checkbox%s']", checkboxName)))) {
            click(By.xpath(String.format("//input[@data-test='checkbox-checkbox%s']", checkboxName)));
        }
    }

    public void uncheck(String checkboxName) {
        if (isSelected(By.xpath(String.format("//input[@data-test='checkbox-checkbox%s']", checkboxName)))) {
            click(By.xpath(String.format("//input[@data-test='checkbox-checkbox%s']", checkboxName)));
        }
    }

    public void clickCheckAllButton() {
        click(By.xpath("//button[@data-test='check-all-button']"));
    }

    public void clickUncheckAllButton() {
        click(By.xpath("//button[@data-test='uncheck-all-button']"));
    }

    public boolean isChecked(String checkboxName) {
        return isSelected(By.xpath(String.format("//input[@data-test='checkbox-checkbox%s']", checkboxName)));
    }

    public boolean isUnchecked(String checkboxName) {
        return !isSelected(By.xpath(String.format("//input[@data-test='checkbox-checkbox%s']", checkboxName)));
    }

}
