package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BrokenImage {
    void VerifyBrokenImage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images = driver.findElements(By.tagName("img"));
        images.forEach(image ->  {

        });
        };
}
