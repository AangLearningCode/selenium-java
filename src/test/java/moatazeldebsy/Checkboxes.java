package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Checkboxes {
    WebDriver driver;
    @BeforeClass
    void Setup(){
        driver  = new ChromeDriver();
    }
    @BeforeMethod
    void load(){
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
    }
    @Test(priority = 1)
    void VerifyDefaultCheckboxesState(){

        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']"))
                .isSelected(),"Checkbox1 is selected by default");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']"))
                .isSelected(),"Checkbox2 is not selected by default");
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']"))
                .isSelected(),"Checkbox3 is selected by default");
    }
    @Test(priority = 2)
    void VerifyCheckbox1AbleToBeChecked(){
        CheckboxesCheck(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")).isSelected(),"Unable to check checkbox1");
        CheckboxesUncheck(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")));
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")).isSelected(),"Unable to uncheck checkbox1");
    }
    @Test(priority = 3)
    void VerifyCheckbox2AbleToBeChecked() {
        CheckboxesUncheck(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")));
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")).isSelected(),"Unable to uncheck checkbox2");
        CheckboxesCheck(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")).isSelected(),"Unable to check checkbox2");
    }
    @Test(priority = 4)
    void VerifyCheckbox3AbleToBeChecked(){
        CheckboxesCheck(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")).isSelected(),"Unable to check checkbox3");
        CheckboxesUncheck(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")));
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")).isSelected(),"Unable to uncheck checkbox3");
    }
    @Test(priority = 5)
    void VerifyCheckAllButtonChecksAllCheckboxes(){
        WebElement checkAllButton = driver.findElement(By.xpath("//button[@data-test='check-all-button']"));
        checkAllButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']"))
                .isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']"))
                .isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']"))
                .isSelected());
    }
    @Test(priority = 6)
    void VerifyUncheckAllButtonUncheckAllCheckboxes(){
        WebElement uncheckAllButton = driver.findElement(By.xpath("//button[@data-test='uncheck-all-button']"));
        uncheckAllButton.click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']"))
                .isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']"))
                .isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']"))
                .isSelected());
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }

    void CheckboxesCheck(WebElement checkbox){
        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }
    void CheckboxesUncheck(WebElement checkbox){
        if (checkbox.isSelected()){
            checkbox.click();
        }
    }
}
