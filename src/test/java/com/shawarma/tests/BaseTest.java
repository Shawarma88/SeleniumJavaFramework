package com.shawarma.tests;

import com.shawarma.constants.FrameworkConstants;
import com.shawarma.driver.Driver;
import com.shawarma.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected BaseTest(){

    }
    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.initDriver();
    }
    @AfterMethod
    protected void tearDown(){
//        Driver.quitDriver();
    }
}
