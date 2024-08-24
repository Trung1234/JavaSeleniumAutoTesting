package com.autotest.homework3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class AnnotationPractice  {
	@BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: This runs once before any test suite runs.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test: This runs before any test methods in the test class.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: This runs before any test methods in the class.");
    
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: This runs before each test method.");
    }



    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: This runs after each test method.");
        // Optionally add code here to clean up after each test
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class: This runs after all test methods in the class.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test: This runs after all test methods in the test class have run.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: This runs once after all test suites have finished.");
    }
}
