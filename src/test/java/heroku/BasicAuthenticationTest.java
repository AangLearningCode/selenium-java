package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthenticationTest {
    @Test
    void verifyAbleToLoginWithValidCredentials(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String p = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertTrue(p.equals("Congratulations! You must have the proper credentials."),"Login failed");
    }
}
