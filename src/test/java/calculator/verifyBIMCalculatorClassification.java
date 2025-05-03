package calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.calculator.BMIpage;
import pages.calculator.BMIpage;
import java.time.Duration;

import static utils.Browser.openBrowser;
import static utils.Browser.wait;

public class verifyBIMCalculatorClassification {
    WebDriver driver;
//    BMIPage bmiPage;

//    @BeforeMethod
//    void setup() {
//        driver = openBrowser("chrome");
//        driver.get("https://www.calculator.net/bmi-calculator.html");
//        bmIpage = new BMIpage(driver);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#menuon a"))).click();
//    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {"25", "175", "70", "BMI = 22.9 kg/m2   (Normal)"},
                {"30", "180", "90", "BMI = 27.8 kg/m2   (Overweight)"},
                {"40", "160", "80", "BMI = 31.3 kg/m2   (Obese Class I)"},
                {"20", "170", "50", "BMI = 17.3 kg/m2   (-4%, Underweight)"}
        };
    }
    @Test(dataProvider = "testData")
    void verifyBIMCalculatorClassification(String age, String height, String weight, String expectedResult) {

        driver.findElement(By.xpath("//input[@value='Clear']")).click();
        driver.findElement(By.id("cage")).sendKeys(age);
        if(!driver.findElement(By.id("csex1")).isSelected()) {
            driver.findElement(By.id("csex1")).click();
        }
        driver.findElement(By.id("cheightmeter")).sendKeys(height);
        driver.findElement(By.id("ckg")).sendKeys(weight);
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        String resultText = driver.findElement(By.cssSelector(".bigtext")).getText();
        Assert.assertEquals(resultText,expectedResult);
        driver.quit();

    }
    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
