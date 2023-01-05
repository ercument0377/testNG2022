package com.test;

import com.arcane.pages.DefaultPage;
import com.arcane.pages.HotelRoomPage;
import com.arcane.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.utilities.Driver.getDriver;

public class Dat12_C12_WebTables {
    //    When kullanici application'da HotelRoom sayfasina gider
    // Log in https://www.carettahotel.com/
    // Hotel Management'e Click yapar
    // Hotel Rooms'a Click yapar
//    test method: entireTable() ve tum header'lari yazdir
//    test method: printRows() ve tum row'lari ile 4 row'daki elementi yazdir
//    test method: printCells() ve table body'dek' cells'lerin toplam sayilarini yazdir ve tum cell'leri yazdir
//    test method: printColumns() ve columns'larin toplam sayisini yazdir ve 5. column yazdir
//    test method: printData(int row, int column); Bu method veriline cell'i yazdirmali
//    ornek : printData(2,3); 2. row ve 3 column yazdirmali


    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    HotelRoomPage hotelRoomPage = new HotelRoomPage();


@BeforeMethod
    public void setUp() {
    getDriver().get(ConfigReader.getProperty("app_url_login"));

    //private isterse
    loginPage.advancedLink.click();
    loginPage.proceedLink.click();

    loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
    loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
    loginPage.loginButton.click();

    //loginbasarılı oldugunu test edelim
    Assert.assertTrue(defaultPage.addUserButton.isDisplayed());

    //hotel managemente click eder
    defaultPage.hotelManagement.click();
    //hotel romsa click eder
    defaultPage.hotelRooms.click();
}

    //    test method: entireTable() ve tum header'lari yazdir

    @Test
    public void entireTable() {
        //setup();
        System.out.println("tum table");
        System.out.println("table body");

        WebElement tableBody = getDriver().findElement(By.xpath("//table//tbody"));
        System.out.println(tableBody.getText());

        // ve tum header leri yazdır
        List<WebElement> tumHeader = getDriver().findElements(By.xpath("//th"));
        for (WebElement herHeader : tumHeader) {
            System.out.println(herHeader.getText() + "  ");
        }

}
//    test method: printRows() ve tum row'lari ile 4. row'daki elementi yazdir
    @Test
    public void printRows(){
        System.out.println("print rows");
      List<WebElement> tumRows =  Driver.getDriver().findElements(By.xpath("//tbody//tr"));

      // tum row ların sayısı
      int satirNumarasi=1;
      for (WebElement herRow : tumRows){
          System.out.println("Satir  :"+satirNumarasi+ " -> " +herRow.getText());
          satirNumarasi++;
      }

      //4. row'daki elementi yazdir
    WebElement row4 =    Driver.getDriver().findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("row 4 -> "+ row4.getText());
        Driver.closeDriver();
    }
//    test method: printCells() ve table body'dek' cells'lerin toplam sayilarini yazdir ve tum cell'leri yazdir
//    test method: printColumns() ve columns'larin toplam sayisini yazdir ve 5. column yazdir
//    test method: printData(int row, int column); Bu method veriline cell'i yazdirmali
//    ornek : printData(2,3); 2. row ve 3 column yazdirmali


}
