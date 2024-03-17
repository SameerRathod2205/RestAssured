package api.utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProvider123 {

    @DataProvider(name = "excelData")
    public static Object[][] provideTestData() {
        // Provide the path to your Excel file and sheet name
        String excelFilePath = "G:\\RestAssuredFrameWork\\src\\main\\resources\\Demo API Data.xlsx";
        String sheetName = "Sheet1";

        // Get test details from ExcelUtility
        List<Map<String, Object>> testData = ExcelUtility.getTestDetails(excelFilePath, sheetName);

        // Convert testData to Object[][]
        Object[][] data = new Object[testData.size()][1];
        for (int i = 0; i < testData.size(); i++) {
            data[i][0] = testData.get(i);
        }

        return data;
    }


}
