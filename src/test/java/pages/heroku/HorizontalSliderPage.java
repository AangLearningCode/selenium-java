package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class HorizontalSliderPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/horizontal_slider");
    }

    public void sliderToMax(){
        slider(By.xpath("//input[@type='range']"),5.0,0);
    }

    public void sliderToMin(){
        slider(By.xpath("//input[@type='range']"),0.0,0);
    }
    public void sliderToValue(double value){
        slider(By.xpath("//input[@type='range']"),value,0);
    }

    public String getSliderValue(){
        return getDriver().findElement(By.id("range")).getText();
    }
}
