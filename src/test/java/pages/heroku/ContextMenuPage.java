package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class ContextMenuPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/context_menu");
    }

    public void rightClickToContextBox() {
        rightClick(By.id("hot-spot"));
    }
    public String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }

    public void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }
}
