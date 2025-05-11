package calculator;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.calcualtor.CalculatorPage;

import static utils.Browser.openBrowser;
import static utils.Browser.quit;

public class BMICalculatorTest {
    CalculatorPage calculatorPage;
    @BeforeClass
    void setup() {
        openBrowser("chrome");
        calculatorPage = new CalculatorPage();
        calculatorPage.open();
        calculatorPage.selectUnitMetric();
        calculatorPage.clearForm();
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
        calculatorPage.fillForm(age, gender, height, weight);

        String resultText = calculatorPage.getResultText();

        Assert.assertEquals(resultText,expectedResult);
    }
    @AfterClass
    void tearDown() {
        quit();
    }
}
