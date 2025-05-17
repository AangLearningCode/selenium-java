package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class FormAuthentificationPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/login");
    }
    public void fillForm(String username, String password){
        fill(By.id("username"), username);
        fill(By.id("password"), password);
    }
    public void clickLoginButton(){
        click(By.cssSelector("[type='submit']"));
    }
    public String getResultText(){
        return getText(By.id("flash-messages"));
    }
}
