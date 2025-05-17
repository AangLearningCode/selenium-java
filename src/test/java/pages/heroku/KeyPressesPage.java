package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class KeyPressesPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/key_presses");
    }

    public String getResultText() {
        return getDriver().findElement(By.id("result")).getText();
    }

    public void sendEscapeKey() {
        pressEscape(By.tagName("body"));
    }
    public void pressEnterKey() {
        pressEnter(By.tagName("body"));
    }

    public String getText() {
        return getDriver().findElement(By.id("result")).getText();
    }
}
