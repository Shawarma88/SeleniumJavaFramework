package com.shawarma.pages;

import com.shawarma.constants.FrameworkConstants;
import com.shawarma.driver.DriverManager;
import com.shawarma.enums.WaitStrategy;
import com.shawarma.factory.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected BasePage(){
    }
    protected void click(By by, WaitStrategy waitStrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.click();
    }
    protected void sendKeys(By by, String value, WaitStrategy waitStrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.sendKeys(value);
    }
    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
    private void explicitlyWaitForElementToBeClickable(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
    private void explicitlyWaitForPresenceOfElement(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
