package com.exelAutomation;

import com.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Day12_C12_ReadExel {
    /*
    Import the apache poi dependency in your pom file
    resources package olustur > java altinda acilmali (java'ya sag tikla ve dosyayi olustur)
    Add the excel file on the resources folder
    Yeni package olustur: excelautomation
    Yeni class olustur : ReadExcel
    test method olustur: readExcel()
    Dosyanin adresini String olarak bir konteynira koy
    dosyayi ac
    fileinputstream kullanarak workbook'u ac
    ilk worksheet'i ac
    ilk row'a git
    ilk row'daki ilk cell'e git ve yazdir
    ilk row'daki ikinci cell'e git ve yazdir
    2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
    3rd row'daki 2nd cell-chain the row and cell
    row sayisini bul
    Kullanilan row sayisini bul
    Ulke ve baskent key-value ciftlerini map object olarak yazdir
    */

@Test
    public void ReadExel() throws IOException {
    //    Dosyanin adresini String olarak bir konteynira koy
  //  String path = ".src/test/java/recurces/Baskent.xlsx";
    String path = "C:/Users/Asus/IdeaProjects/testNG2022/src/test/java/recurces/Baskent.xlsx";

    //dosyayi ac
    FileInputStream fileInputStream = new FileInputStream(path);

    //fileinputstream kullanarak workbook'u ac
    Workbook workbook = WorkbookFactory.create(fileInputStream);

    //ilk worksheet'i ac
    Sheet sheet = workbook.getSheetAt(0); // sheet sayfaları 0. indexeten başlar

    //ilk row'a git
    Row ilkRow = sheet.getRow(0);  // rowlarda index 0 dan başlar

    //ilk row'daki ikinci cell'e git ve yazdir
    Cell ilkCell= ilkRow.getCell(0); // cellerde indexi 0 dan başlar
    System.out.println(ilkCell);

     // 2. row'daki ikinci cell'e git ve yazdir
    //1.yol
//    Row row2 =  sheet.getRow(1);
//    Cell cell21 =  row2.getCell(1);
//    System.out.println(cell21);
    //2.yol
   Cell row1cell2 = sheet.getRow(0).getCell(1);
    System.out.println(row1cell2); //Baskent

    // 2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
   Cell row2cell1 = sheet.getRow(1).getCell(0);
    System.out.println("Data ABD olmali :" + row2cell1);

    boolean esitMi = row2cell1.toString().equals("ABD");

    Assert.assertTrue(esitMi);

// 3rd row'daki 2nd cell-chain the row and cell
   Cell row3cell2 = sheet.getRow(2).getCell(1);
    System.out.println(row3cell2);  //Paris

//row sayisini bul (satır sayısını bul)
    int rowSayisi =  sheet.getLastRowNum()+1;
    System.out.println(rowSayisi); //11

//Kullanilan row sayisini bul
   int kullanilanrowSayisi = sheet.getPhysicalNumberOfRows();
    System.out.println(kullanilanrowSayisi); //11

    // Ulke ve baskent key-value ciftlerini map object olarak yazdir

    Map<String, String> dunyaBaskentleri = new HashMap<>();

    int ulkeColumn = 0;
    int baskentColumn = 1;

    /*
    row numarası 1 den baslar, cunku header 0. indextedir
    en sondaki row un indexi : lastRowNumber yada sheet.getLastRowNum()+1;

    ABD    : sheet. getRow(1). getCell(0);
    Fransa : sheet. getRow(2). getCell(0);
    ..........

     */
    for(int rowNumarasi = 1 ; rowNumarasi<rowSayisi; rowNumarasi++){
       String ulke = sheet.getRow(rowNumarasi).getCell(ulkeColumn).toString();
       String baskent =  sheet.getRow(rowNumarasi).getCell(baskentColumn).toString();

        System.out.println("Ulke: " + ulke);
        System.out.println("Baskent: " + baskent);

        dunyaBaskentleri.put(ulke, baskent); // Map e ulke ve baskenti eklemiş olduk

    }
    System.out.println(dunyaBaskentleri);

}
@Test
    public void exelUtilDemo(){
    String path = "C:/Users/Asus/IdeaProjects/testNG2022/src/test/java/recurces/Baskent.xlsx";
    String sheetName = "Sayfa1";

    //ExelUtilClass ı okumak için once bir nesne olusturduk
    ExcelUtil exelUtil = new ExcelUtil(path, sheetName);
    //ExcelUtildeki methodları çağırabiliriz

    System.out.println(exelUtil.getDataList());

    System.out.println(exelUtil.columnCount());  //2

    System.out.println(exelUtil.rowCount());  // 11

    System.out.println(exelUtil.getCellData(5,1));  // Ottova

    System.out.println(exelUtil.getColumnsNames());  // [Ulke, Baskent]  list döndurur



}
}
