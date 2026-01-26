package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility class for reading Excel (.xlsx) files.
 *
 * <p>This class provides helper methods to read and process Excel data
 * using Apache POI.
 */
public final class ExcelUtils {

    /** Prevent instantiation of utility class. */
    private ExcelUtils() {
    }

    /** Path to the Excel file containing user test data. */
    private static final String USERS_EXCEL_PATH =
            "src/test/testData/users.xlsx";

    /**
     * Reads the first sheet of the Excel file and prints its contents
     * row by row to standard output.
     *
     * <p>Each cell value is formatted as a string using {@link DataFormatter}
     * to ensure consistent output for different cell types.
     */
    public static void readExcelFile() {
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fileInputStream =
                     new FileInputStream(USERS_EXCEL_PATH);
             XSSFWorkbook workbook =
                     new XSSFWorkbook(fileInputStream)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                // Skip empty or missing rows.
                if (row == null) {
                    continue;
                }

                int cellCount = row.getLastCellNum();

                for (int cellIndex = 0; cellIndex < cellCount; cellIndex++) {
                    // Print a space between cell values (not before the first).
                    if (cellIndex > 0) {
                        System.out.print(" ");
                    }

                    System.out.print(
                            formatter.formatCellValue(row.getCell(cellIndex))
                    );
                }
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file", e);
        }
    }
}