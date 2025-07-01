package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {
    public static String getCellData(String filePath, int row, int col) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row r = sheet.getRow(row);
        Cell c = r.getCell(col);
        return c.getStringCellValue();
    }
}
