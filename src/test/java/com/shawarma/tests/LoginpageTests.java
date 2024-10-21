package com.shawarma.tests;
import com.shawarma.driver.Driver;
import com.shawarma.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.annotations.Test;

public final class LoginpageTests extends BaseTest{
    private LoginpageTests(){}

    @Test
    public void test2(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("ShawarmaBoy", Keys.ENTER);
    }
}
