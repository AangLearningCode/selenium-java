package demo;

import org.testng.annotations.*;

public class SampleTest1 {
    @BeforeSuite
    void beforeSuite() {
        System.out.println("Before Suite Sample Test 1");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("Before Test Sample Test 1");
    }

    @BeforeGroups
    void beforeGroups() {
        System.out.println("Before Groups Sample Test 1");
        System.out.println("--------------------------------------");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before Class");
        System.out.println("--------------------------------------");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Before Method");
        System.out.println("--------------------------------------");
    }

    @Test
    void testMethod1() {
        System.out.println("Test Method 1 Sample Test 1");

    }

    @Test
    void testMethod2() {
        System.out.println("Test Method 2 Sample Test 1");

    }

    @Test
    void testMethod3() {
        System.out.println("Test Method 3 Sample Test 1");
    }

    @Test
    void testMethod4() {
        System.out.println("Test Method 4 Sample Test 1");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("After Method");
        System.out.println("--------------------------------------");
    }

    @AfterClass
    void afterClass() {
        System.out.println("After Class");
    }

    @AfterGroups
    void afterGroups() {
        System.out.println("After Groups Sample Test 1");
    }

    @AfterTest
    void afterTest() {
        System.out.println("After Test Sample Test 1");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("After Suite Sample Test 1");
    }
}
