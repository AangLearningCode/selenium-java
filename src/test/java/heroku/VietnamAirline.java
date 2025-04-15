package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class VietnamAirline {
    WebDriver driver;
    ChromeOptions chromeOption;
    WebDriverWait wait;
    @BeforeClass
    void setup(){
        chromeOption.addArguments("--disable-blink-features=AutomationControlled");
        chromeOption.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36");

        //todo: remove the notification from the browser: location, microphone, camera, Notification...
        HashMap<String, Integer> prefs = new HashMap<>();
        //Option 1 = allow, 2 = block, 0 = default
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.geolocation", 2);
        prefs.put("profile.default_content_setting_values.media_stream_camera", 2);
        prefs.put("profile.default_content_setting_values.media_stream_mic", 2);
        chromeOption.setExperimentalOption("prefs", prefs);
        //Option 2:
        //        chromeOption.addArguments("disable-notifications");
        //        chromeOption.addArguments("disable-geolocation");
        //Mic/Camera require prefs or JS workaround
        driver = new ChromeDriver(chromeOption);
        driver.get("https://www.vietnamairlines.com/vn/vi/home");

        //remove navigator.webdriver
        ((JavascriptExecutor) driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined});");
    }
    @Test
    void selectDepartureDate(){
        
        //todo: accept the cookies
        //todo: Select ngay di
        //todo: Select 1 chieu
        //todo: Select 07/04/2025
        //todo: verify
        driver.findElement(By.cssSelector("input#city-from-roundtrip")).click();
        driver.findElement(By.xpath("//div[text()='Tp. Hồ Chí Minh (SGN), Việt Nam']")).click();
    }

}
