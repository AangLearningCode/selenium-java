package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

// selenium owner methods
public class Browser {
    private static WebDriver driver;
    public static WebDriverWait wait;
    private static Actions action;

    public static void openBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
//                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static void quit() {
        driver.quit();
    }

    public static void click(By by) {
        wait
                .until(ExpectedConditions.elementToBeClickable(by))
                .click();
    }

    public static void fill(By by, String withText) {
        driver.findElement(by).sendKeys(withText);
    }

    public static boolean isSelected(By by) {
        return driver.findElement(by).isSelected();
    }

    public static void check(By by) {
        if (!isSelected(by)) {
            click(by);
        }
    }

    public static String getText(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void hover(By by) {
        action.moveToElement(driver.findElement(by)).perform();
    }

    public static void dragAndDrop(By positionA, By positionB) {
        action.dragAndDrop(
                        driver.findElement(positionA),
                        driver.findElement(positionB))
                .perform();
    }

    public static void moveToElement(By by) {
        action.moveToElement(driver.findElement(by)).perform();
    }

    //Scroll action
    public static void scrollToElement(By by) {
        action.scrollToElement(driver.findElement(by)).perform();
    }

    public static void scrollDownByAmount(int amount) {
        action.scrollByAmount(0, amount).perform();
    }

    //Mouse action
    public static void rightClick(By by) {
        action.contextClick(driver.findElement(by)).perform();
    }

    //Keyboard action
    public static void pressEscape(By by) {
        action.sendKeys(driver.findElement(by), Keys.ESCAPE).perform();
    }

    public static void pressEnter(By by) {
        action.sendKeys(driver.findElement(by), Keys.ENTER).perform();
    }

    public static void captureScreenshot(String fileName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshots-%s-%s.png", fileName, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

