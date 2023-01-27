package com.exelAutomation;

import com.arcane.pages.DefaultPage;
import com.arcane.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import com.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day13_C14_LoginSmokeTest {

    ExcelUtil excelUtil;

    //datayi key-value pairs şeklinde ( username, password) şeklinde al
    // Bir Map  ==> Map<String, String>  : {manager, Manager1!}
    // list Map  ==> List<Map<String, String> : {{manager, Manager1!}, manager5, Manager5!},{manager12, Manager12!}}

    List<Map<String, String>> testData;
    //page object model
    LoginPage loginPage;
    DefaultPage defaultPage;

    public  void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage = new LoginPage();

//      if (loginPage.advancedLink.isDisplayed()){
//          loginPage.advancedLink.click();
//          loginPage.proceedLink.click();
//      }
        try{
            loginPage.advancedLink.click();
            loginPage.proceedLink.click();
        } catch (Exception e ){
            System.out.println("advanced ve proceedlink gorulmedi");
        }

    }
    @Test
    public void adminLoginTest(){
        //1.yol
//        setUp();
////        loginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
////        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
////        loginPage.loginButton.click();

        //2.yol
//        setUp();
//        loginPage.username.sendKeys("manager");
//        loginPage.password.sendKeys("Manager1!");
//        loginPage.loginButton.click();

        //3.yol (excelden data alıyoruz) (eger coklu data varsa bu yolu kullan)
        String path = "./src/test/java/recurces/smoketestdata.xlsx";
        String sheetName = "admin_login_info";
        excelUtil = new ExcelUtil(path, sheetName);

       testData = excelUtil.getDataList();

        System.out.println(testData);  // [{password=Arcane123!, username=admin}]


        for (Map<String, String> herData : testData){
            setUp();
            loginPage.username.sendKeys(herData.get("username"));
            loginPage.password.sendKeys(herData.get("password"));
            loginPage.loginButton.click();
        }

    }
    @Test
    public void managerLoginTest(){
        String path = "./src/test/java/recurces/smoketestdata.xlsx";
        String sheetName = "manager_login_info";
        excelUtil = new ExcelUtil(path, sheetName);

        testData = excelUtil.getDataList();

        System.out.println(testData); //[{password=Manager1!, username=manager}, {password=Manager5!, username=manager5}, {password=Manager12!, username=manager12}]


        for (Map<String, String> herData : testData){
            setUp();   // çoklu datalarda for un içine yazılmalı setUp()
            loginPage.username.sendKeys(herData.get("username"));
            loginPage.password.sendKeys(herData.get("password"));
            loginPage.loginButton.click();
        }

    }

}
