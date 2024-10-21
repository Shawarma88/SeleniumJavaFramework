package com.shawarma.tests;

import com.shawarma.driver.DriverManager;
import net.bytebuddy.build.ToStringPlugin;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.joda.time.LocalDate;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssertTest {

    //dynamic xpath - is only possible when using findElements, not possible with PageFactory
    private String menuItems = "//div[text()='%wildCard%']//parent::a";

    @Test
    public void dynamicXpathTest(String menuItem){
        DriverManager.getDriver().findElement(By.xpath(menuItems.replace("%wildCard%",menuItem )));
    }

    @Test
    public void Test(){
        String temp = "Hello World";
        Assertions.assertThat(temp)
                .as("String is Null").isNotNull()
                .isNotBlank()
                .isNotEmpty()
                .isEqualTo("Hello World")
                .contains("Hello")
                .doesNotContain("world")
                .containsWhitespaces()
                .doesNotContainPattern("\\d.*")
                .containsIgnoringCase("world");
    }
    @Test
    public void IntTest(){
        int a = 12;
        Assertions.assertThat(a)
                .isEven()
                .isCloseTo(14, Offset.offset(5))
                .isPositive()
                .isCloseTo(20, Percentage.withPercentage(25))
                .isGreaterThanOrEqualTo(11)
                .isInstanceOf(Integer.class);
    }
//    @Test
    public void ListTest(){
        List<String> list = Arrays.asList("gokul", "jkko", "test");
        List<String> list2 = Arrays.asList("gokul", "test");
        List<String> list3 = Arrays.asList("automation", "selenium");

        Assertions.assertThat(list)
                .hasSize(3)
                .hasSizeBetween(2, 19)
                .contains("gokul")
                .containsAll(list2)
                .doesNotContainAnyElementsOf(list3)
                .withFailMessage(()-> "String is not having size less than 3").allMatch(s -> s.length() > 3);

    }
//    @Test
    public void mapTest(){
        Map<String, String> map = new HashMap<>();
        map.put("ytName", "ShawarmaYT");
        map.put("ytSubs", "TwentyTwo");
        map.put("ytFav", "Naruto");
        Assertions.assertThat(map)
                .isNotNull()
                .containsEntry("ytSubs", "TwentyTwo")
                .containsEntry("ytFav", "Naruto")
                .containsKey("ytName")
                .containsValue("Naruto");
    }
//    @Test
    public void SoftAssertions(){
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat("Hello World")
                .isNotBlank()
                .hasSize(3)
                .containsWhitespaces();
        System.out.println("Hello, I'm Here");
        soft.assertAll();
    }
//    @Test
    public void DateTest(){
        LocalDate date = new LocalDate(2000, 12, 1);
        Assertions.assertThat(date)
                .isGreaterThan(new LocalDate(1999, 12, 31));

    }

    @Test(dataProvider = "getData2")
    public void newTest(String uu){
        System.out.println("Enter Username " +uu);
        System.out.println("Enter Password");
        System.out.println("Click Login");
    }
    @Test(dataProvider = "getData2")
    public void newTest2(int uu){
        System.out.println("Enter login id " +uu);
        System.out.println("Enter Pwd ");
        System.out.println("Login");
    }

//    @DataProvider
//    public String [] getData(){
//        String [] arr = {"Gokul","Joyal","Victor"};
//        return arr;
//    }
    @DataProvider
    public Object[] getData2(Method method){
        if(method.getName().equalsIgnoreCase("newTest")){
            return new String[]{
                    "Gokul",
                    "Health",
                    "Task"
            };
        } else if (method.getName().equalsIgnoreCase("newTest2")) {
            return new Integer[]{
                    1213,
                    342,
                    423
            };
        }
        return null;
    }

    @Test(dataProvider = "getNewData1")
    public void testMethod(Map<String, String> map){
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        System.out.println(map.get("firstname"));
        System.out.println(map.get("lastname"));
        System.out.println("---------------------");
    }

    @DataProvider
    public Object[] getNewData1() throws IOException {
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("testing");
        int rowNum = sheet.getLastRowNum();
        XSSFRow row = sheet.getRow(0);
        int cellNum = row.getLastCellNum();
        Map<String , String> map;
        Object []data = new Object[rowNum];
        for (int i=1; i<=rowNum; i++){
            XSSFRow currentRow = sheet.getRow(i);
            map = new HashMap<>();
            for(int j=0; j<cellNum; j++){
                String key = row.getCell(j).getStringCellValue();
                String value = currentRow.getCell(j).getStringCellValue();
                map.put(key, value);
                data[i-1]=map;
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] getNewData() throws IOException {
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("testing");
        int rowNum = sheet.getLastRowNum();
        XSSFRow row = sheet.getRow(0);
        int cellNum = row.getLastCellNum();
        Object [][] data = new Object[rowNum][cellNum];
        for (int i=1; i<=rowNum; i++){
            XSSFRow currentRow = sheet.getRow(i);
            for(int j=0; j<cellNum; j++){
                data[i-1][j]=currentRow.getCell(j).getStringCellValue();
            }
        }
        return data;
    }


}
