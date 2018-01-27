package ua.efa.landscape.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.ServletContextAware;
import ua.efa.landscape.model.ColorEnum;
import ua.efa.landscape.model.Plant;
import ua.efa.landscape.service.PlantService;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK;

public class ExcelToDatabaseProcessor implements ApplicationListener<ContextRefreshedEvent>, ServletContextAware {

    private static final String EXCEL_FILE_NAME = "excel.file";
    private static final String EXCEL_SHEET_NUMBER = "excel.sheet.number";
    private static boolean isExcelToDbTransfered;

    private ServletContext servletContext;

    @Autowired
    private PlantService plantService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            transferExcelToDatabase();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void transferExcelToDatabase() throws IOException {
        if (!isExcelToDbTransfered) {
            plantService.deleteAllPlants();
            doDataTransfer();
            isExcelToDbTransfered = true;
        }
    }

    private void doDataTransfer() throws IOException {
        String excelFileName = servletContext.getInitParameter(EXCEL_FILE_NAME);
        File excelFile = new File(excelFileName);
        try (FileInputStream inputStream = new FileInputStream(excelFile)) {
            parseExcelAndSaveToDb(inputStream);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void parseExcelAndSaveToDb(FileInputStream inputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(getSheetNumber());
        Iterator<Row> iterator = sheet.iterator();
        boolean isFirstRow = true;
        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (!isFirstRow) {
                plantService.insertPlant(parseRowToPlant(row));
            } else {
                isFirstRow = false;
            }
        }
    }

    private int getSheetNumber() {
        return Integer.parseInt(servletContext.getInitParameter(EXCEL_SHEET_NUMBER));
    }

    private Plant parseRowToPlant(Row row) {
        Plant plant = new Plant();
        plant.setName(row.getCell(0, CREATE_NULL_AS_BLANK).getStringCellValue());
        plant.setColor(ColorEnum.valueOf(row.getCell(1, CREATE_NULL_AS_BLANK).getStringCellValue().toUpperCase()));
        plant.setPrice(row.getCell(2, CREATE_NULL_AS_BLANK).getNumericCellValue());
        plant.setHeight(row.getCell(3, CREATE_NULL_AS_BLANK).getNumericCellValue());
        plant.setImg(row.getCell(4, CREATE_NULL_AS_BLANK).getStringCellValue());
        return plant;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
