package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FromAuthentication {
    /*
   Testing url:https://moatazeldebsy.github.io/test-automation-practices/#/auth
   Element on Login page:
        - username:
            - id: username
            - xpath: //input[@id='username']
            - css: input#username
        - password:
            - id: password-
            - xpath: //input[@id='password']
            - css: input#password
        - login button:
            - xpath: //button[@type='submit']
            - css: button[type="submit"]
        - message:
            - xpath: //div[@data-test='auth-error']
            - css: div[data-test='auth-error']
    Element on Secure page:
        - logout button:
            - xpath: //button[@data-test='logout-button']
            - css: button[data-test='logout-button']
        - message:
            - xpath: //h2[text()='Successfully authenticated!']
            - css: h2

    TC1: Verify that the user is able to login successfully
    1. Navigate to https://moatazeldebsy.github.io/test-automation-practices/#/auth
    1. Fill in the username field with "admin"
    2. Fill in the password field with "admin"
    3. Click on the login button
    4. Verify that the message "Successfully authenticated!" is displayed

    TC2: Verify that the user is able to logout successfully
    Pre-condition: The user is logged in
    1. Click on the logout button
    2. Verify that the login button is displayed

    TC3: Verify that the user is not able to login with valid username and invalid password
    pre-condition: The user is logged out
    1. Fill in the username field with "admin"
    2. Fill in the password field with "invalid"
    3. Click on the login button
    4. verify that the message "Invalid username or password!" is displayed

    TC4: Verify that the user is not able to login with invalid username and valid password
    pre-condition: The user is logged out
    1. Fill in the username field with "invalid"
    2. Fill in the password field with "admin"
    3. Click on the login button
    4. verify that the message "Invalid username or password!" is displayed
    * */
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @BeforeMethod
    void load(){
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/auth");
    }
    @Test (priority = 1)
    void VerifyLoginSuccess(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='logout-button']")));

        Assert.assertTrue(driver.findElement(By.cssSelector("button[data-test='logout-button']")).isDisplayed(),"Logout button is not displayed");
        Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(),"Successfully authenticated!","Message is not displayed");
    }
    @Test (priority = 2)
    void VerifyLogoutSuccess(){
        driver.findElement(By.cssSelector("button[data-test='logout-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        Assert.assertTrue(driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed(),"Login button is not displayed");
    }
    @Test (priority = 3)
    void VerifyInvalidPassword(){
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("invalid");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-test='auth-error']")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div[data-test='auth-error']")).getText(),"Invalid username or password","Message is not displayed");
    }

    @Test (priority = 4)
    void VerifyInvalidUsername(){
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();

        driver.findElement(By.id("username")).sendKeys("invalid");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-test='auth-error']")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div[data-test='auth-error']")).getText(),"Invalid username or password","Message is not displayed");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
