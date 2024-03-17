package api.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class ExcelUtility {

        public static List<Map<String, Object>> getTestDetails(String excelFilePath, String sheetName) {
            List<Map<String, Object>> list = new ArrayList<>();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(excelFilePath);
                Workbook workbook = new XSSFWorkbook(fileInputStream);
                Sheet sheet = workbook.getSheet(sheetName);

                int lastRowNum = sheet.getLastRowNum();
                int lastCellNum = sheet.getRow(0).getLastCellNum();

                for (int i = 1; i <= lastRowNum; i++) {
                    Map<String, Object> map = new HashMap<>();
                    Row row = sheet.getRow(i);
                    for (int j = 0; j < lastCellNum; j++) {
                        String key = sheet.getRow(0).getCell(j).getStringCellValue();
                        Cell cell = row.getCell(j);
                        Object value;
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    value = cell.getStringCellValue();
                                    break;
                                case NUMERIC:
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        value = cell.getDateCellValue();
                                    } else {
                                        value = cell.getNumericCellValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    value = cell.getBooleanCellValue();
                                    break;
                                default:
                                    value = null;
                            }
                        } else {
                            value = null;
                        }
                        map.put(key, value);
                    }
                    list.add(map);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileInputStream != null)
                        fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return list;
        }
    }
