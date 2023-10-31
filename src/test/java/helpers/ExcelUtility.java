package helpers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtility {

    // Create a new Excel workbook
    public static Workbook createWorkbook() {
        return new XSSFWorkbook();
    }

    // Create a new sheet in the workbook
    public static Sheet createSheet(Workbook workbook, String sheetName) {
        return workbook.createSheet(sheetName);
    }

    // Write data to an Excel sheet
    public static void writeData(Sheet sheet, List<List<Object>> data) {
        int rowIdx = 0;
        for (List<Object> rowData : data) {
            Row row = sheet.createRow(rowIdx++);
            int cellIdx = 0;
            for (Object cellData : rowData) {
                Cell cell = row.createCell(cellIdx++);
                if (cellData instanceof Number) {
                    cell.setCellValue(((Number) cellData).doubleValue());
                } else if (cellData instanceof String) {
                    cell.setCellValue((String) cellData);
                }
            }
        }
    }

    // Save the workbook to a file
    public static void saveWorkbook(Workbook workbook, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
