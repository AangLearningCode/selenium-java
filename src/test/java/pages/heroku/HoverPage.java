package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Browser.*;

public class HoverPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/hovers");
    }

    public void hoverOverAvatar(String avatar) {
        hover(By.xpath("//div[@class='figure'][" + avatar + "]"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("figcaption")));
    }
    public boolean isAvatarTextDisplayed() {
        return getDriver().findElement(By.xpath(".//h5")).isDisplayed();
    }

    public boolean isProfileUrlDisplayed() {
        WebElement element = getDriver().findElement(By.xpath(".//a[contains(@href,'/users/')]"));
        return element.isDisplayed();
    }
}
