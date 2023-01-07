package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day14_C16_DataProvider1 {
    /*
    DataProvider ile test yap
    1- 2D Object array donduren bir getData methodu olustur
    2- getData()  ustunde @DataProvider anotation kullan


     */

    @DataProvider
    public Object [][] getData(){
        // manager    Manager1!
        // manager5   Manager5!
        // manager12  Manager12!

        //bu uzun yol
//        Object [][]  managerProfili = new Object[3][2];
//        managerProfili [0][0] = "manager";
//        managerProfili [0][1] = "Manager1!";

        // yukarıdakının kısa yolu
        Object [][]  managerProfili = {{"manager", "Manager1!" },{"manager5", "Manager5!"},{"manager12", "Manager12!"}};

        return managerProfili;

    }
    @Test (dataProvider = "getData")
    public void manageInfo(String kullaniciAdi, String sifre){

        System.out.println(" Kullanici Adi : " + kullaniciAdi + "\nSifre :" + sifre);
    }


}
