package com.test;

import com.arcane.pages.Day10_C6_TestAdressLoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.annotations.Test;

public class Day10_C7_TestAdressLoginTest {
    @Test
    public void testAdressLogin(){
        //once applicationa (adrese git) https://www.testyou.in/Login.aspx
  //      Driver.getDriver().get("https://www.testyou.in/Login.aspx"); // artık bunu yapmıyoruz

        Driver.getDriver().get(ConfigReader.getProperty("test_address_url"));

        Day10_C6_TestAdressLoginPage testAdressLoginPage = new Day10_C6_TestAdressLoginPage();

        testAdressLoginPage.email.sendKeys(ConfigReader.getProperty("test_address_email"));
        testAdressLoginPage.password.sendKeys(ConfigReader.getProperty("test_address_password"));

        testAdressLoginPage.loginButton.click();

        //driveri kapatmak için
        Driver.closeDriver();

        /*
        Diyelim ki 100 tane test case niz var hepsinde şifre kullanmışsınız
        Daha sonra şifre değişirse ne yaparsanız?
        config.propirties olmadan tum bu 100 case ye gidip her biri için gidip değiştirmemiz lazım bu çok zaman alır
        config.properties ile config.properties fileye gidip sadece oarada değiştirmemiz  veya şifrenin value kısmını değiştirmemiz yeterlidir


         */
    }
}
