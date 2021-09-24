package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static Object[][] ReadFromExcelToObjectArr(String filepath, String filename, String sheetname) throws IOException {
        FileInputStream inputStream = new FileInputStream(filepath + "/" + filename);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetname);
        int rowcount = sheet.getLastRowNum(); //Return the number of data rows - this does not include header row
        System.out.println("rowcount = " + rowcount);
        Object[][] data = new Object[rowcount][1];
        //Keys Row <--- row 0
        Row keysRow = sheet.getRow(0); //keys apply to all data rows - 1,2,3
        Hashtable<String, String> rec;
        for (int r = 1; r < rowcount + 1; r++) {
            Row dataRow = sheet.getRow(r);
            //for each row - Hashtable
            rec = new Hashtable<>();
            for (int c = 0; c < dataRow.getLastCellNum(); c++) {
                //key and value for the current row - 1,2,3
                String key = keysRow.getCell(c).getStringCellValue();
                String val = dataRow.getCell(c).getStringCellValue();
                rec.put(key, val);
            }
            data[r - 1][0] = rec;
        }
        return data;
    }

    public static void ReadFromExcel(String filepath, String filename, String sheetname) throws IOException {
        //Create an instance FileInputStream - Opens file in read mode - in argument - location of the file with filename
        FileInputStream inputStream = new FileInputStream(filepath + "/" + filename);
        //we have 2 classes - HSSFWorkbook (for .xls)- sl packages and XSSFWorkbook -(for.xlsx - ss packages(
        //if condition - check for filename ends with .xls or xlsx and accordingly create an instance of either
        //XSSFWorkbook or HSSFWorkbook
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetname);
        //non empty rows in excel sheet
        int rowcount = sheet.getLastRowNum(); //Return the number of data rows - this does not include header row
        System.out.println("rowcount = " + rowcount);
        for (int r = 0; r < rowcount + 1; r++) {
            Row row = sheet.getRow(r);
            for (int c = 0; c < row.getLastCellNum(); c++) {
                Cell cell = row.getCell(c);
                System.out.print(cell.getStringCellValue() + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        String filepath = System.getProperty("user.dir") + "/src/testdata";
        String filename = "BMITestData.xlsx";
        String sheetname = "BMIDataSet";
        //ExcelReader.ReadFromExcel(filepath, filename, sheetname);
        System.out.println(Arrays.deepToString(ExcelReader.ReadFromExcelToObjectArr(filepath, filename, sheetname)));
    }
}
