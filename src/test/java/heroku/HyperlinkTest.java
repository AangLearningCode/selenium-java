package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HyperlinkTest {
    WebDriver driver;
    WebDriverWait wait;
    ChromeOptions options = new ChromeOptions();
    String url = "https://the-internet.herokuapp.com/status_codes";
    @BeforeClass
    void setup(){
//        options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @BeforeMethod
    void load(){
        driver.get("https://the-internet.herokuapp.com/redirector");
    }
    @Test (priority = 1)
    void redirect(){
        WebElement here = driver.findElement(By.linkText("here"));
        WebElement hrefByXpath = driver.findElement(By.xpath("//a[text()='here']"));
        driver.findElement(By.xpath("//a[.='here']")).click();

//        hrefByXpath2.click();
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test (priority = 2)
    void workAroundInStatusCodePage(){
        clickHere();
        Assert.assertEquals(driver.getCurrentUrl(),url);

        WebElement statusCode200 = driver.findElement(By.linkText("200"));
        statusCode200.click();
        Assert.assertEquals(driver.getCurrentUrl(),url + "/200");
        driver.navigate().back();
//        driver.navigate().refresh();
//        driver.navigate().forward();
//        driver.navigate().to();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),url + "/301");
        clickHere();
        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(),url + "/404");
        clickHere();
        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),url + "/500");

    }
    @AfterClass
    void teardown(){
        driver.quit();
    }
    void clickHere(){
        WebElement here = driver.findElement(By.linkText("here"));
        here.click();
    }
}
