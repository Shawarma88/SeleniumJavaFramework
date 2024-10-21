package com.shawarma.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.shawarma.driver.DriverManager;
import com.shawarma.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class OrangeHRMHomePage extends BasePage{
    //link, btn, drpdwn
    private final By linkWelcome = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By linkLogout = By.xpath("//a[text()='Logout']");
    public OrangeHRMHomePage clickDropDown(){
        //DriverManager.getDriver().findElement(linkWelcome).click();
        click(linkWelcome, WaitStrategy.PRESENCE);
        return this;
    }
    public OrangeHRMLoginPage clickLogout(){
//        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        //Expected Condition
//        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(linkLogout));
        //DriverManager.getDriver().findElement(linkLogout).click();
        click(linkLogout, WaitStrategy.CLICKABLE);
        return new OrangeHRMLoginPage(); // it returns to login page - to perform validation in login page
    }
}
