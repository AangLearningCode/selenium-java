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

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class WebTableTest {
   @Test
    void verifyMaxDuePerson(){
       WebDriver driver = new ChromeDriver();
       driver.get("https://the-internet.herokuapp.com/tables");

       List<Person> persons = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))
               .stream()
               .map(WebElement::getText)
               .map(row -> row.split(" "))
               .map(cells -> new Person(cells[1], cells[0], Double.parseDouble(cells[3].replace("$", ""))))
               .collect(Collectors.toList());
       OptionalDouble maxDue = persons.stream()
               .mapToDouble(Person::getDue)
               .max();
       List<Person> maxDuePersons = persons.stream()
               .filter(person -> person.getDue() == maxDue.getAsDouble())
               .collect(Collectors.toList());

       Assert.assertEquals(maxDuePersons.stream().map(Person::getFullName).collect(Collectors.toList()), List.of("Jason Doe"));

    }

}
