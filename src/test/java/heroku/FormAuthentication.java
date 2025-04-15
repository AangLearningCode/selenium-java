package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormAuthentication {
    /**
     * Open Bowser
     * Navigate to https://the-internet.herokuapp.com/login

     * Fill in the username field with "tomsmith"
     * Fill in the password field with "SuperSecretPassword!"
     * Click on the login button
     */
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    void load() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    void testValidLogin() {


        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.id("flash-messages")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

    }
    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
