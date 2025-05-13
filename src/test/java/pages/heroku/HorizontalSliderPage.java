package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;

import static utils.Browser.*;

public class HorizontalSliderPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/horizontal_slider");
    }

    public void sliderToMax() {
        slider(By.xpath("//input[@type='range']"), 5.0);
    }

    public void sliderToMin() {
        slider(By.xpath("//input[@type='range']"), 0.0);
    }

    public void sliderToValue(double value) {
        slider(By.xpath("//input[@type='range']"), value);
    }

    public String getSliderValue() {
        return getDriver().findElement(By.id("range")).getText();
    }

    private void slider(By by, double value) {
        moveToElement(by);

        HashMap<Double, Integer> offsets = new HashMap<>();
        offsets.put(0.0, -65);
        offsets.put(0.5, -52);
        offsets.put(1.0, -39);
        offsets.put(1.5, -26);
        offsets.put(2.0, -13);
        offsets.put(2.5, 0);
        offsets.put(3.0, 13);
        offsets.put(3.5, 26);
        offsets.put(4.0, 39);
        offsets.put(4.5, 52);
        offsets.put(5.0, 65);

        Actions action = new Actions(getDriver());
        action.clickAndHold(getDriver().findElement(by))
                .moveByOffset(offsets.get(value), 0)
                .release()
                .perform();

    }
}
