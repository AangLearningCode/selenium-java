package browser;

;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v134.emulation.Emulation;
import org.openqa.selenium.devtools.v134.network.Network;
import org.openqa.selenium.devtools.v134.network.model.ConnectionType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChromeTest {
//    @Test
    void openWithDefaultMode(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }
//    @Test
    void openWithHeadlessMode(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

//    @Test
    void openWithMobileViewPort(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 430);
        deviceMetrics.put("height", 932);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.close();
    }

    //@Test
    void openWithBetaChromeVersion(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("136");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");

    }
    //@Test
    void openChromeBrowserWithFakeGeoLocation(){
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(37.386052),
                Optional.of(-122.083851),
                Optional.of(1)
        ));
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[.='Where am I?']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#lat-value")).getText(),"37.386052");
        Assert.assertEquals(driver.findElement(By.cssSelector("#long-value")).getText(),"-122.083851");
    }
//    @Test
//    void simulate3GNetworkCondition(){
//        WebDriver driver = new ChromeDriver();
//        DevTools devTools = ((HasDevTools) driver).getDevTools();
//        devTools.createSession();
//        //Enable network simulator
//        devTools.send(Network.enable(Optional.of(100000000),Optional.empty(),Optional.empty()));
//        //Set network conditions
//        devTools.send(Network.emulateNetworkConditions(
//                false,
//                100,
//                75000,
//                25000,
//                Optional.of(ConnectionType.NONE)
//        ));
//        driver.get("https://www.selenium.dev/");
//
//    }
//    @Test
    void interceptionNetwork(){
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.of(0),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),requestSent -> {;
            System.out.println("Request URL: " + requestSent.getRequest().getUrl());
            System.out.println("Request Method: " + requestSent.getRequest().getMethod());
            System.out.println("Request Headers: " + requestSent.getRequest().getHeaders());
        });

        devTools.addListener(Network.responseReceived(), responseReceived -> {
            System.out.println("Response URL: " + responseReceived.getResponse().getUrl());
            System.out.println("Response Status: " + responseReceived.getResponse().getStatus());
            System.out.println("Response Headers: " + responseReceived.getResponse().getHeaders());
            System.out.println("Response MIME Type: " + responseReceived.getResponse().getMimeType().toString());
        });

        driver.get("https://www.selenium.dev/");

    }
//    @Test
//    void openSeleniumHomePageAndCapturePerformanceMetrics(){
//        ChromeDriver driver = new ChromeDriver();
//        DevTools devTools = driver.getDevTools();
//        devTools.createSession();
//        devTools.send(Performance.enable(Optional.empty()));
//        List<Metric> metricList = devTools.send(Performance.getMetrics());
//
//        driver.get("https://www.selenium.dev/");
//        Assert.assertEquals(driver.getTitle(),"Selenium");
//        driver.quit();
//        for(Metric m : metricList){
//            System.out.println(m.getName() + " : " + m.getValue());
//        }
//
//    }
}
