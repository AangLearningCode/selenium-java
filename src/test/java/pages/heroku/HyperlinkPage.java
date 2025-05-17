package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class HyperlinkPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/status_codes");
    }
    public void clickStatusCode(String statusCode){
        click(By.linkText(statusCode));
    }

    public boolean isStatusCodeDisplayed(String statusCode){
        return getCurrentUrl().contains("https://the-internet.herokuapp.com/status_codes/" + statusCode);
    }
}
