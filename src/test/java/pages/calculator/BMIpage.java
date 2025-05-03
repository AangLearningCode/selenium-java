package pages.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Browser;

public class BMIpage {
    /**
     * fill form
     * get result
     * clear form
     * select unit metric
     */
    WebDriver driver;
    public BMIpage(WebDriver driver){
        this.driver =driver;
    }
    void selectUnitMetric(){
        Browser
                .wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#menuon a")))
                .click();
    }

    public void openCalculatorPage(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }
    public void clearForm(){
        driver.findElement(By.xpath("//input[@value='Clear']")).click();
    }

    public void fillForm(String age, String gender, String height, String weight){
        driver.findElement(By.id("cage")).sendKeys(age);
        if(gender.equalsIgnoreCase("male")){
            if(!driver.findElement(By.id("csex1")).isSelected()) {
                driver.findElement(By.id("csex1")).click();
            }
        } else {
            if(!driver.findElement(By.id("csex2")).isSelected()) {
                driver.findElement(By.id("csex2")).click();
            }
        }
        driver.findElement(By.id("cheightmeter")).sendKeys(height);
        driver.findElement(By.id("ckg")).sendKeys(weight);
        driver.findElement(By.xpath("//inpout[@value='Calculate']")).click();
    }
    public String getResultText(){
        return driver.findElement(By.cssSelector(".bigtext")).getText();
    }
}
