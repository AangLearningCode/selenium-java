package demo;

import org.testng.annotations.*;

public class SampleTest2 {
    @BeforeSuite
    void beforeSuite() {
        System.out.println("Before Suite Sample Test 2");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("Before Test Sample Test 2");
    }

    @BeforeGroups
    void beforeGroups() {
        System.out.println("Before Groups Sample Test 2");
        System.out.println("--------------------------------------");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before Class Sample Test 2");
        System.out.println("--------------------------------------");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Before Method");
        System.out.println("--------------------------------------");
    }

    @Test
    void testMethod1() {
        System.out.println("Test Method 1 Sample Test 2");
    }

    @Test
    void testMethod2() {
        System.out.println("Test Method 2 Sample Test 2");
    }

    @Test
    void testMethod3() {
        System.out.println("Test Method 3 Sample Test 2");
    }

    @Test
    void testMethod4() {
        System.out.println("Test Method 4 Sample Test 2");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("After Method");
        System.out.println("--------------------------------------");
    }

    @AfterClass
    void afterClass() {
        System.out.println("After Class Sample Test 2");
    }

    @AfterGroups
    void afterGroups() {
        System.out.println("After Groups Sample Test 2");
    }

    @AfterTest
    void afterTest() {
        System.out.println("After Test Sample Test 2");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("After Suite Sample Test 2");
    }
}
