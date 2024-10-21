package com.shawarma.tests;

import com.shawarma.driver.Driver;
import com.shawarma.driver.DriverManager;
import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public final class HomepageTests extends BaseTest{
    /*
    ~ Validate whether the title is containing Google Search or google search
    ~ Validate whether the title is not null & length of the title is greater than 15 & less than 100
    ~ Check for the links in the pages -> Verify the link text
    ~ number of links displayed - 10 or 15 exactly
     */
    private HomepageTests(){

    }
    @Test
    public void test3(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing mini bytes youtube", Keys.ENTER);
//        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("testing"));
        String title = DriverManager.getDriver().getTitle();
        System.out.println("Title - "+ title);
        //AssertJ
        assertThat(title)
                .as("Title is Actually Null").isNotNull()
                .as("Size not in limit 15 to 100").hasSizeBetween(15, 100)
                .containsIgnoringCase("google search")
                .matches("\\w.*"+"Google Search");
        //testNG
        /*
        Assert.assertTrue(Objects.nonNull(title), "Title is null");
        Assert.assertTrue(title.length()>15);
        Assert.assertTrue(title.length()<100);
        Assert.assertTrue(title.toLowerCase().contains("google search"));
        Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search"));
        */
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
        //AssertJ
        assertThat(elements)
                .hasSize(10)
                .extracting(e->e.getText())
                .contains("Testing Mini Bytes");
        //testNG
        /*Assert.assertEquals(elements.size(), 10);
        boolean isDisplayed = false;
        for (WebElement element: elements){
            if(element.getText().equalsIgnoreCase("testing mini bytes")){
                isDisplayed = true;
                break;
            }
        }
        Assert.assertTrue(isDisplayed, "testing mini bytes not found");
         */
    }
}
