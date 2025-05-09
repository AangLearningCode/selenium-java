package calculator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.calculator.BMIPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class verifyBIMCalculatorClassification {
    BMIPage bmiPage;
    @BeforeMethod
    void setup() {
        openBrowser("chrome");
        bmiPage.open();
        bmiPage.selectUnitMetric();
        bmiPage.clearForm();
    }
    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {"25", "male","175", "70", "BMI = 22.9 kg/m2   (Normal)"},
                {"30", "male","180", "90", "BMI = 27.8 kg/m2   (Overweight)"},
                {"40", "male","160", "80", "BMI = 31.3 kg/m2   (Obese Class I)"},
                {"20", "male","170", "50", "BMI = 17.3 kg/m2   (-4%, Underweight)"}
        };
    }
    @Test(dataProvider = "testData")
    void verifyNormalClassification(String age, String gender,String height, String weight, String expectedResult) {
        bmiPage.fillForm(age, gender, height, weight);

        String resultText = bmiPage.getResultText();

        Assert.assertEquals(resultText,expectedResult);
    }
    @AfterMethod
    void tearDown() {
        quit();
    }
}
