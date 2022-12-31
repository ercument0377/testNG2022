package com.test.smoketest;

import com.arcane.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day11_C10_HotelRoomOlusturma {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));

        loginPage.loginButton.click();

        //loginnin başarılı oldugnu verify ediyoruz
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
    }
    @Test
    public void hotelRoomOlusturma(){

        //hotel

    }
}
