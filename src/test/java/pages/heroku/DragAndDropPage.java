package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class DragAndDropPage {
    By columnA = By.id("column-a");
    By columnB = By.id("column-b");

    public void open(){
        visit("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public void dragAndDropLeftToRight() {
        dragAndDrop(columnA, columnB);
    }

    public void dragAndDropRightToLeft() {
        dragAndDrop(columnB, columnA);
    }

    public String checkColumnA(){
        return getDriver().findElement(columnA).getText();
    }
}
