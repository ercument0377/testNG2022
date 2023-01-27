package com.javascriptexecutor;

import com.arcane.pages.LoginPage;
import com.arcane.pages.MainPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import com.utilities.JSUtils;
import com.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Day14_C15_JSUtilTest {

    MainPage mainPage;
    LoginPage loginPage;

    @Test
    public void scrollIntoViev(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
         mainPage = new  MainPage();
        try{
            mainPage.advancedLink.click();
            mainPage.proceedLink.click();
        } catch (Exception e ){
            System.out.println("advanced ve proceedlink gorulmedi");
        }
      WebElement haveAQuestions = Driver.getDriver().findElement(By.xpath("//*[.='Have a Questions?']"));

        JSUtils.scrollIntoViewJS(haveAQuestions);
        ReusableMethods.waitFor(2);

        Assert.assertEquals(haveAQuestions.getText(), "Have a Questions?");

        Assert.assertTrue(haveAQuestions.isDisplayed());


    }
    @Test
    public void clickByJS(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage = new MainPage();
        try{
            mainPage.advancedLink.click();
            mainPage.proceedLink.click();
        } catch (Exception e ){
            System.out.println("advanced ve proceedlink gorulmedi");
        }

//       WebElement loginLink = Driver.getDriver().findElement(By.linkText("Log in"));
//        JSUtils.clickElementByJS(loginLink);

        WebElement checkAvailability = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.clickElementByJS(checkAvailability);


    }
    @Test
    public void flashJS(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage = new MainPage();
        try{
            mainPage.advancedLink.click();
            mainPage.proceedLink.click();
        } catch (Exception e ){
            System.out.println("advanced ve proceedlink gorulmedi");
        }

      WebElement  checkAvailabilityButton =  Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.clickElementByJS(checkAvailabilityButton);


    }
    @Test
    public void changeColor(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage = new MainPage();
        try{
            mainPage.advancedLink.click();
            mainPage.proceedLink.click();
        } catch (Exception e ){
            System.out.println("advanced ve proceedlink gorulmedi");
        }
        WebElement  checkAvailabilityButton =  Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.changeColor("red", checkAvailabilityButton);


    }

@AfterMethod
    public void closeDriver(){
        Driver.closeDriver();
}

}
