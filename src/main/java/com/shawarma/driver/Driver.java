package com.shawarma.driver;

import com.shawarma.constants.FrameworkConstants;
import com.shawarma.enums.ConfigProperties;
import com.shawarma.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {
    private Driver(){}

    public static void initDriver() throws Exception {
        if(Objects.isNull(DriverManager.getDriver())){
            //WebDriver driver = new ChromeDriver();
            DriverManager.setDriver(new ChromeDriver());
            //DriverManager.setDriver(driver);
            System.out.println(FrameworkConstants.getName());
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }
    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
