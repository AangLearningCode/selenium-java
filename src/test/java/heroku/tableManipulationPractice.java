package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class tableManipulationPractice {
//    @Test
    void printTableHeader(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));

        // Print the table header
        List<WebElement> headerRow = table1.findElements(By.xpath("./thead/tr/th"));
        System.out.print("Table Header: " + headerRow.size()+ "\n");
        for (WebElement header : headerRow) {
            System.out.print(header.getText() + "\t");
        }
        System.out.println("----------------------");
    }
//    @Test
    void printTableBody(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));

        //Print the table body
        List<WebElement> bodyRow = table1.findElements(By.tagName("tr"));
        for (WebElement row : bodyRow){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells){
                System.out.print(cell.getText() + "\t");
            }
            System.out.println();
        }
    }
//    @Test
    void printLastNameData (){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));

        // Print the last name data
        List<WebElement> lastNameData = table1.findElements(By.xpath("./tbody/tr/td[1]"));
        for(WebElement lastName : lastNameData){
            System.out.print(lastName.getText() + "\n");
        }
    }
    @Test
    void printLastNameColumn(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table1 = driver.findElement(By.id("table1"));

        // Print the last name column
        List<WebElement> lastNameColumn = table1.findElements(By.xpath(".//tr/*[self::th or self::td][1]"));
        System.out.print("Last Name Column: " + lastNameColumn.size() + "\n");
        for(WebElement lastName : lastNameColumn){
            System.out.print(lastName.getText() + "\n");
        }
        driver.quit();
    }
}
