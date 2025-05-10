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
    @BeforeClass
    void Setup(){
        driver  = new ChromeDriver();
    }
    @BeforeMethod
    void load(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    void VerifyDefaultCheckboxesState(){

        Assert.assertFalse(driver.findElement(By.xpath("//input[1]"))
                .isSelected(),"Checkbox1 is selected by default");
        Assert.assertTrue(driver.findElement(By.xpath("//input[2]"))
                .isSelected(),"Checkbox2 is not selected by default");
    }
    @Test
    void VerifyCheckbox1AbleToBeChecked(){
        check(driver.findElement(By.xpath("//input[1]")));
        Assert.assertTrue(driver.findElement(By.xpath("//input[1]")).isSelected(),"Unable to check checkbox1");
        uncheck(driver.findElement(By.xpath("//input[1]")));
        Assert.assertFalse(driver.findElement(By.xpath("//input[1]")).isSelected(),"Unable to uncheck checkbox1");
    }
    @Test
    void VerifyCheckbox2AbleToBeChecked(){
        uncheck(driver.findElement(By.xpath("//input[2]")));
        Assert.assertFalse(driver.findElement(By.xpath("//input[2]")).isSelected(),"Unable to uncheck checkbox2");
        check(driver.findElement(By.xpath("//input[2]")));
        Assert.assertTrue(driver.findElement(By.xpath("//input[2]")).isSelected(),"Unable to check checkbox2");
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
