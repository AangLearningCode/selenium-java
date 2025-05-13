package pages.heroku;

import static utils.Browser.scrollDownByAmount;
import static utils.Browser.visit;

public class InfiniteScrollPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/infinite_scroll");
    }
    public void scrollDown(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            scrollDownByAmount(100);
            Thread.sleep(1000);
        }
    }
}
