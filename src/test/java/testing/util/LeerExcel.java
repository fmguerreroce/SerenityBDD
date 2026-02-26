package testing.util;

import org.apache.poi.ss.usermodel.*;
import testing.model.web.ModeloExcel;

import java.io.FileInputStream;
import java.util.*;

public class LeerExcel {

    private LeerExcel() {}

    public static List<ModeloExcel> readLoginData(String path, String sheetName) {

        List<ModeloExcel> users = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(path);
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheet(sheetName);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                String usuario = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();

                users.add(new ModeloExcel(usuario, password));
            }

        } catch (Exception e) {
            throw new RuntimeException("Error leyendo Excel: " + e.getMessage());
        }

        return users;
    }
}
