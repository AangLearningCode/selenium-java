package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Checkboxes {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    void Setup(){
        driver  = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @BeforeMethod
    void load(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    void theCheckboxesShouldSelected(){
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        check(checkbox1);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        check(checkbox2);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected());
    }
    @Test
    void theCheckboxesShouldeDeselected(){
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        uncheck(checkbox1);
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        uncheck(checkbox2);
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected());
    }
    @Test
    void theCheckboxesShouldSelectedAndDeselected() {
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        check(checkbox1);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
        uncheck(checkbox1);
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        uncheck(checkbox2);
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected());
        check(checkbox2);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected());
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
    void check(WebElement checkbox){
        if(!checkbox.isSelected()){
            checkbox.click();
        }
    }
    void uncheck(WebElement checkbox){
        if(checkbox.isSelected()){
            checkbox.click();
        }
    }
}
