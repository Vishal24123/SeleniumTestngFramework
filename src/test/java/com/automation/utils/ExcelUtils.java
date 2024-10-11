package com.automation.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    public  ExcelUtils(String fileName,String sheetName){
        try {
            workbook = new XSSFWorkbook("src/test/resources/data/" + fileName);
            sheet = workbook.getSheet(sheetName);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public int getTotalNumberOfRows(){
        return  sheet.getLastRowNum();
    }
    public int getTotalNumberOfCols(){
        return  sheet.getRow(0).getLastCellNum();
    }
    public List<List<String>> getData(){
        List<List<String>> tableData= new ArrayList<>();
        for (int i=1;i<=getTotalNumberOfRows();i++){
            XSSFRow row= sheet.getRow(i);
            List<String> rowData=new ArrayList<>();
            for (int j=0;j< row.getLastCellNum();j++){
                rowData.add(row.getCell(j).getStringCellValue());
            }
            tableData.add(rowData);
        }
        return tableData;
    }
}
