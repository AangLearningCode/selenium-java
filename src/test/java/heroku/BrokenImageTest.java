package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
    }

    @Test
    void verifyBrokenImage(){
        List<WebElement> images = driver.findElements(By.cssSelector(".example img"));
        images.forEach(image -> {
            String imageUrl = image.getDomAttribute("src");
            String naturalWidth = image.getDomProperty("naturalWidth");
            String naturalHeight = image.getDomProperty("naturalHeight");
            System.out.println("-".repeat(10));
            System.out.println("Image URL: " + imageUrl);
            System.out.println("Natural Width: " + naturalWidth);
            System.out.println("Natural Height: " + naturalHeight);
        });
        Assert.assertEquals(images.get(0).getDomProperty("naturalWidth"), "0", "Image is broken");
        Assert.assertEquals(images.get(1).getDomProperty("naturalHeight"), "0", "Image is broken");
        Assert.assertFalse(images.get(2).getDomProperty("naturalWidth").equals("0"), "Image is not broken");
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
