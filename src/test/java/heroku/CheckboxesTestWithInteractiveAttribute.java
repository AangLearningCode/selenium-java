package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTestWithInteractiveAttribute {
    @Test
    void TC02(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        String check = driver.findElement(By.cssSelector("form#checkboxes input:nth-child(1)")).getDomAttribute("checked");
        //check
        if(!driver.findElement(By.cssSelector("form#checkboxes input:nth-child(1)")).isSelected()){
            driver.findElement(By.cssSelector("form#checkboxes input:nth-child(1)")).click();
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("form#checkboxes input:nth-child(1)")).getDomAttribute("checked").equals("true"));
        check = driver.findElement(By.cssSelector("form#checkboxes input:nth-child(1)")).getDomAttribute("checked");
        driver.findElement(By.cssSelector("form#checkboxes input:nth-child(3)")).click();
    }
}

