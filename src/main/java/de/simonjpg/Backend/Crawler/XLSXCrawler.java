package de.simonjpg.Backend.Crawler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class XLSXCrawler.
 *
 * <p>
 *     Class to crawl CO2 data stored in an excel sheet.
 * </p>
 * @author Simon Balcke
 */

public class XLSXCrawler {
    private static final Logger LOGGER = LogManager.getLogger(XLSXCrawler.class);
    private static XLSXCrawler xlsxCrawler;
    private final Map<Integer, List<String>> data;

    /**
     * Constructor XLSXCrawler.
     * <p>
     *     Calls Method readCO2Data to avoid errors if the data is referenced.
     * </p>
     */
    public XLSXCrawler() {
        LOGGER.info("Instantiating new XLSXCrawler");
        data = new HashMap<>();
        readCO2Data();
    }

    public static XLSXCrawler instance() {
        LOGGER.info("Referencing XLSXCrawler");
        if (xlsxCrawler == null) {
            xlsxCrawler = new XLSXCrawler();
        }
        return xlsxCrawler;
    }

    /**
     * Method readCO2Data.
     * <p>
     *     Scans excel sheet for CO2 data and stores them into a Map.
     * </p>
     */
    public void readCO2Data() {
        LOGGER.info("Capturing CO2 data");
        try {
            Workbook workbook = new XSSFWorkbook(WebCrawler.instance(
                                new URL("https://www.umweltbundesamt.de/sites/default/files/medien/384/bilder/dateien/de-en_indikator_klim-01_emission-treibhausgase_2023-04-11_0.xlsx")
                                ).crawlXlsxFile());
            Sheet sheet = workbook.getSheetAt(workbook.getSheetIndex("Daten"));
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:   data.get(i).add(cell.getStringCellValue()); break;
                        case NUMERIC:  data.get(i).add(Double.toString(cell.getNumericCellValue())); break;
                        case BOOLEAN:  break;
                        case FORMULA:  data.get(i).add(cell.getCellFormula()); break;
                    }
                }
                i++;
            }
        } catch (IOException e) {
            LOGGER.error("Capturing CO2 data failed: {}", e.getMessage());
        }
    }

    public Map<Integer, List<String>> getCO2Data() {
        return data;
    }
}
