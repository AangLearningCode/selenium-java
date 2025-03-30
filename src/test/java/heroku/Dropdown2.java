package heroku;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdown2 {
//    @Test
    void verifyAbleToSelectOption1InDropdownList(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));

        select.selectByVisibleText("Option 1");
        Assert.assertTrue(select.getFirstSelectedOption().isSelected());
        driver.close();
    }
//    @Test
    void verifyAbleToSelectOption2InDropdownList(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 2");
        Assert.assertTrue(driver.findElement(By.cssSelector("select#dropdown option:nth-child(3)")).isSelected(),"Option 2 is not selected");

    }
//    @Test
    void verifyAbleToSelectOption1InDropdownListByUsingCssSelector(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.cssSelector("select#dropdown")).click();
        driver.findElement(By.cssSelector("option:first-child")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[.='Option 2']")).isSelected(),"Option 2 is not selected");

    }
    @Test
    void ableToSelectMultipleOptions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));

        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Grape");

        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());

        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());
    }
}
