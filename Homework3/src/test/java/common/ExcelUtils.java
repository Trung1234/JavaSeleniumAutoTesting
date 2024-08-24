package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class ExcelUtils {
    public static   Object[][] getExcelData(String filePath, String sheetName) {
        List<Object[]> data = new ArrayList<Object[]>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rows; i++) { // Starting from 1 to skip headers
                Row row = sheet.getRow(i);
                int cols = row.getPhysicalNumberOfCells();
                String[] rowData = new String[cols];
                for (int j = 0; j < cols; j++) {
                    rowData[j] = row.getCell(j).toString();
                }
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toArray(new Object[0][]);
    }
}