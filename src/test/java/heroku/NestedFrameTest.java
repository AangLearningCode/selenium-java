package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class NestedFrameTest {
    @Test
    void tc6(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));

        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));
        String leftFrame = driver.findElement(By.xpath("//body")).getText();
        System.out.println(leftFrame);

        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
        String middleFrame = driver.findElement(By.xpath("//body")).getText();

        System.out.println(middleFrame);
        driver.switchTo().parentFrame();

        List<WebElement> frames = driver.findElements(By.xpath("//frame"));
        System.out.println(frames.size());

        for(WebElement frame: frames){
            System.out.println(frame.getAttribute("name"));
            driver.switchTo().frame(frame);
            String body = driver.findElement(By.xpath("//body")).getText();
            System.out.println(body);
            driver.switchTo().parentFrame();
        }
    }
}
