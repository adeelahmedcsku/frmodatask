package com.frmoda.demo.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.frmoda.demo.model.Stock;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

@Configuration
@PropertySource("classpath:application.properties")

public class excelHelper {

//    @Value( "${file.name}" )
    private  String filename="classpath:example_live_stock_11022021.xlsx";

    static String SHEET = "Foglio1";

    public List<Stock> excelToStock() {
        try {
            File file = ResourceUtils.getFile(filename);
            FileInputStream fis = new FileInputStream(file);   //ob
            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Stock> stocks = new ArrayList<Stock>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Stock stock = new Stock();
                DataFormatter dataFormatter = new DataFormatter();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            stock.setProductNum(currentCell.getStringCellValue());
                            break;

                        case 1:
                                stock.setSize(dataFormatter.formatCellValue(currentCell));
                            break;

                        case 2:
                            stock.setBrand(currentCell.getStringCellValue());
                            break;

                        case 3:
                            stock.setData(Timestamp.valueOf(currentCell.getStringCellValue()));
                            break;
                        case 4:
                            stock.setStock(currentCell.getNumericCellValue());
                            break;
                        case 5:
                            stock.setColor(currentCell.getStringCellValue());
                            break;
                        case 6:
                            //stock.setUpdated((Boolean.valueOf(String.valueOf(currentCell.getNumericCellValue()))));
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }

                stocks.add(stock);
            }

            workbook.close();

            return stocks;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
