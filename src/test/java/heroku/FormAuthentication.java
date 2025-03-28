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
        /**
         * Click on the login button
         * tagname: button, i
         * Attribute: class="radius", type="submit"
         * text: " Login"
         */
//        driver.findElement(By.tagName("button")).click();
//        driver.findElement(By.tagName("i")).click();
//        driver.findElement(By.className("radius")).click();
//        driver.findElement(By.cssSelector("button.radius")).click();
//          driver.findElement(By.cssSelector(".radius")).click();
//        driver.findElement(By.cssSelector("button[type='submit']")).click();

//        driver.findElement(By.xpath("//*[@class='radius']")).click();
//        driver.findElement(By.xpath("//*[text()='Login']")).click();
//        driver.findElement(By.xpath("//*[@class='radius']")).click();
//        driver.findElement(By.xpath("//button[@class='radius']")).click();
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.xpath("//button[text()='Login']")).click();
//        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
//          driver.findElement(By.xpath("//i[contains(text(),' Login')]")).click();


    }
    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
