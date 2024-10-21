package com.shawarma.pages;

import com.shawarma.driver.DriverManager;
import com.shawarma.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage{
    //Assertions should not be used in the page layers.
    //all your page methods should have the return type
    private final By textBoxUsername = By.xpath("//input[@name='username']");
    private final By textBoxPassword = By.xpath("//input[@name='password' and @type='password']");
    private final By btnLogin = By.xpath("//button[@type='submit']");
    public OrangeHRMLoginPage enterUserName(String username){
        //DriverManager.getDriver().findElement(textBoxUsername).sendKeys(username);
        sendKeys(textBoxUsername,username, WaitStrategy.PRESENCE);
        //return new OrangeHRMLoginPage();
        return this;
    }
    public OrangeHRMLoginPage enterPassword(String password){
        //DriverManager.getDriver().findElement(textBoxPassword).sendKeys(password);
        sendKeys(textBoxPassword,password, WaitStrategy.PRESENCE);
        //return new OrangeHRMLoginPage();
        return this;
    }
    public OrangeHRMHomePage clickLogin(){
        //DriverManager.getDriver().findElement(btnLogin).click();
        click(btnLogin, WaitStrategy.PRESENCE);
        return new OrangeHRMHomePage();
    }
    public String getTitle(){
        return getPageTitle();
    }
}
