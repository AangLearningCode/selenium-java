package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicAuthenticationTest {
    WebDriver driver;
    @BeforeClass
    void Setup(){
        driver  = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test (priority = 1)
    void VerifyBasicAuthentication(){
        driver.findElement(By.linkText("Basic Auth")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/basic_auth");
    }
    @Test (priority = 2)
    void VerifyLoginSuccess(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed(),"Unable to login successfully");
    }
}
