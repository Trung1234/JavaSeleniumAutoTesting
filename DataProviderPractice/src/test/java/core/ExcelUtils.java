package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
        public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int startRow = 1;
            int startCol = 0;
            int ci, cj;
            int totalRows = ExcelWSheet.getLastRowNum();

            // you can write a function as well to get Column count
            int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
            tabArray = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols; j++, cj++) {
                    tabArray[ci][cj] = getCellData(i,j);
                    System.out.println(tabArray[ci][cj]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (tabArray);
    }

    public static String getCellData(int RowNum, int ColNum) {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            if (Cell == null) {
                return "";
            } else {
                return new DataFormatter().formatCellValue(Cell);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }
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
                    rowData[j] = Objects.nonNull(row.getCell(j)) ? row.getCell(j).toString() : "";
                }
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[][]  oldData = data.toArray(new Object[0][]);
        
        //return data.toArray(new Object[0][]);
//        Object[][]  newArray = new Object[oldData.length - 1][oldData.length - 1];
//        System.arraycopy(oldData, 1, newArray, 0, oldData.length - 1);
        return oldData;
    }
}
