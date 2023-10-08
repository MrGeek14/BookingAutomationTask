package utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import static utils.ConfigReader.getConfig;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    @DataProvider
    public Object[][] getLocationAndHotelData() throws IOException {
        FileInputStream location_Hotel_Data = new FileInputStream(System.getProperty("user.dir") + getConfig("locationHotelDataFilePath"));
        XSSFWorkbook wb = new XSSFWorkbook(location_Hotel_Data);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowsNo = sheet.getLastRowNum();
        int colsNo = sheet.getRow(0).getPhysicalNumberOfCells();
        String[][] locationHotelData = new String[rowsNo][colsNo];

        for (int i = 0; i < rowsNo; i++)
            for (int j = 0; j < colsNo; j++) {
                XSSFRow row = sheet.getRow(i + 1);
                locationHotelData[i][j] = row.getCell(j).toString();
            }
        wb.close();
        return locationHotelData;
    }

}
