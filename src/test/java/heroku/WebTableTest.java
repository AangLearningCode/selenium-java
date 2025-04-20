/*
table1: Class attributes is not grouping of rows and columns therefor to loop through the columns, it is necessary to loop through the rows and then the cells
    - tHeader:
        - cssSelector: "#table1 .header"
        - xpath: "//table[@id='table1']//th[@class='header']" -> //table[@id='table1']//th
            - List<WebElement> tHeader = driver.findElements(By.cssSelector("#table1 .header"));
            Check the header elements
            - header.forEach(element -> {
                System.out.println("Header: " + element.getText());
            });
    - tBody:
        - cssSelector: "#table1 tbody tr"
        - xpath: "//table[@id='table1']//tbody/tr"
            - List<WebElement> tRows = driver.findElements(By.cssSelector("#table1 tbody tr"));
            Check the rows
            - rows.forEach(row -> {
                System.out.println("Row: " + row.getText());
                List<WebElement> tCells = row.findElements(By.cssSelector("td"));
                get the cells
                tCells.forEach(cell -> {
                    System.out.println("Cell: " + cell.getText());
                });
            });
table2: Class attributes to signify groupings of rows and columns
    - tBody: loop through the Last Name column
        - cssSelector: "#table2  tbody tr td.last-name"
        - xpath: "//table[@id='table2']//td[@class='last Name']"
            - List<WebElement> lastName = driver.findElements(By.cssSelector("#table2  tbody tr td.last-name"));
            Check the rows
            - rows.forEach(row -> {
                System.out.println("Row: " + row.getText());
                List<WebElement> tCells = row.findElements(By.cssSelector("td"));
                get the cells
                tCells.forEach(cell -> {
                    System.out.println("Cell: " + cell.getText());
                });
            });


* */
package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebTableTest {
    @Test//Print the Last name column
    void TC1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
//        List<WebElement> tRows = driver.findElements(By.cssSelector("#table1 tbody tr"));
        List<WebElement> tRows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        tRows.forEach(row -> {;
            //System.out.println("Row: " + row.getText());
            List<WebElement> tCells = row.findElements(By.cssSelector("td"));
            System.out.println(tCells.get(0).getText());
        });
    }
    @Test //Print the Last name column
    void TC2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> lastName = driver.findElements(By.cssSelector("#table2  tbody tr td.last-name"));
        lastName.forEach(row -> {
            System.out.println("Row: " + row.getText());
        });
    }
    @Test
    void  findTheMinimumDueInTable1(){
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tRows = driver.findElements(By.cssSelector("#table1 tbody tr"));
        tRows.forEach(row -> {
            List<WebElement> tCells = row.findElements(By.cssSelector("td"));
        });
    }


    @Test
    void tc06(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> personList = new ArrayList<>();

        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row -> {
                    String lastName = row.findElement(By.xpath("./td[1]")).getText();
                    String firstName = row.findElement(By.xpath("./td[2]")).getText();
                    double due = Double.parseDouble(row.findElement(By.xpath("./td[4]")).getText().replace("$", ""));
                    personList.add(new Person( firstName,lastName, due));
                });
        String maxDuePersonFullName = personList.stream().max(Comparator.comparing(Person::getDue)).get().getFullName();
        Assert.assertEquals(maxDuePersonFullName, "Jason Doe");
        driver.quit();
    }

}
