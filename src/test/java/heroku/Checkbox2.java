package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Checkbox2 {
//    @Test
    void tc02(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected());;
    }
    @Test
    void VerifyCheckAllButtonWorkingTest(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//*[contains(text(),'Checkbox 1')]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[contains(text(),'Checkbox 2')]"));
        WebElement checkbox3 = driver.findElement(By.xpath("//*[contains(text(),'Checkbox 3')]"));
        check(checkbox1);
        Assert.assertTrue(checkbox1.isSelected(), "Checkbox 1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 is selected");

    }
    void check(WebElement element){
        if (!element.isSelected()){
            element.click();
        }
    }
}
