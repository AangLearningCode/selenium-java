package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormAuthenticationTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void load(){
        driver.get("https://the-internet.herokuapp.com/login");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
    }
    @Test (priority = 1, invocationCount = 1)
    void testValidLogin() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='flash-messages']")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
    }

    @Test (priority = 2, invocationCount = 1)
    void invalidCredential() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("error")).isDisplayed());
    }
    @AfterClass
    void tearDown() {
        driver.quit();

    }
}
