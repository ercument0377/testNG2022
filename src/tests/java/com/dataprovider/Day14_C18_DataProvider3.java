package com.dataprovider;

import com.arcane.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import com.utilities.ExcelUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day14_C18_DataProvider3 {

    @DataProvider
    public Object [][] getData(){
        String path = "src/test/java/recurces/smoketestdata.xlsx";
        String sayfaIsmi = "manager_login_info";
        ExcelUtil excelUtil = new ExcelUtil(path, sayfaIsmi);
        Object [][] managerProfili = excelUtil.getDataArrayWithoutFirstRow();

        return managerProfili;


    }
    LoginPage loginPage;

    public void setUp() {
        loginPage = new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        try {
            loginPage.advancedLink.click();
            loginPage.proceedLink.click();
        } catch (Exception e) {
            System.out.println("advanced ve proceedlink gorulmedi");
        }
    }
    @Test(dataProvider =  "getData")
    public void managerLoginTest(String managerId, String managerSifre){
        setUp();
        loginPage.username.sendKeys(managerId);
        loginPage.password.sendKeys(managerSifre);
        loginPage.loginButton.click();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
