package de.simonjpg.Backend.Extractor;

import de.simonjpg.Backend.Crawler.XLSXCrawler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class ExtractCO2Data.
 * <p>
 *     Used to filter specific information of an .xlsx file.
 * </p>
 * @author Simon Balcke
 */

public class ExtractCO2Data {
    private static final Logger LOGGER = LogManager.getLogger(ExtractCO2Data.class);

    /**
     * Method extractData.
     * <p>
     * Extracts CO2 data for a given year.
     * </p>
     *
     * @param year the year of the CO2 data to be filtered for.
     * @return a {@link java.util.List} with the CO2 data.
     */
    public List<Double> extractData(String year) {
        List<Double> extractedData = new ArrayList<>();
        Map<Integer, List<String>> rawData = XLSXCrawler.instance().getCO2Data();
        LOGGER.info("Extracting CO2 data of year {}", year);

        for (int i = 0; i < rawData.size(); i++) {
            /*
             * The rawData contains every Cell of the "Daten" Sheet of the .xlsx file.
             * To extract the data, a special pattern is needed to be followed:
             * First we check, if the ArrayList of the current iteration is empty to avoid an IndexOutOfBoundsException.
             * Second we check for the value of the ArrayList if it matches with the searched year.
             * If so, we know that the current row is a part of our CO2 Data.
             * If we look at the complete value of the raw data, we see, that after the year, 6 CO2 values follow.
             * The same with the next 4 rows (5 in total) except for the years 2020 and 2022.
             *
             * In year 2020 the pattern is 6 on the current row and 6 on the following row. (2 rows in total)
             * In year 2022 the pattern is only 6 on the current row. (1 row in total)
             *
             * Now that we know how to filter for the data we can extract them.
             */

            if (!rawData.get(i).isEmpty() && rawData.get(i).get(0).equals(year)) {
                LOGGER.debug("Extract data of {}. element of the HashMap", i);
                // first row (row with the year of the values)
                extractedData.add(Double.parseDouble(rawData.get(i).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(5)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(6)));

                LOGGER.debug("Extract data of {}. element of the HashMap", i + 1);
                // second row
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(0)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(5)));

                LOGGER.debug("Extract data of {}. element of the HashMap", i + 2);
                // third row
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(0)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(5)));

                LOGGER.debug("Extract data of {}. element of the HashMap", i + 3);
                // fourth row
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(0)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(5)));

                LOGGER.debug("Extract data of {}. element of the HashMap", i + 4);
                // fifth row
                extractedData.add(Double.parseDouble(rawData.get(i + 4).get(0)));
                extractedData.add(Double.parseDouble(rawData.get(i + 4).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i + 4).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i + 4).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i + 4).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i + 4).get(5)));
            }
        }
        return extractedData;
    }

    /**
     * Method extractDataOf2020.
     * <p>
     * Extracts CO2 data for the year 2020.
     * </p>
     *
     * @return a {@link java.util.List} with the CO2 data.
     */

    public List<Double> extractDataOf2020() {
        List<Double> extractedData = new ArrayList<>();
        Map<Integer, List<String>> rawData = XLSXCrawler.instance().getCO2Data();
        LOGGER.info("Extracting CO2 data of year 2020");

        for (int i = 0; i < rawData.size(); i++) {
            /*
             * The rawData contains every Cell of the "Daten" Sheet of the .xlsx file.
             * To extract the data, a special pattern is needed to be followed:
             * First we check, if the ArrayList of the current iteration is empty to avoid an IndexOutOfBoundsException.
             * Second we check for the value of the ArrayList if it matches with the searched year.
             * If so, we know that the current row contains a part of our CO2 Data.
             * If we look at the complete value of the raw data, we see, that after the year, 6 CO2 values follow.
             * The same with the next rows except for the years 2020 and 2022.
             *
             * In year 2020 the pattern is 6 on the current row and 6 on the following row. (2 in total)
             * In year 2022 the pattern is only 6 on the current row. (1 in total)
             *
             * Now that we know how to filter for the data we can extract them.
             */

            if (!rawData.get(i).isEmpty() && rawData.get(i).get(0).equals("2020.0")) {
                LOGGER.debug("Extract data of {}. element of the HashMap", i);
                // first row (row with the year of the values)
                extractedData.add(Double.parseDouble(rawData.get(i).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(5)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(6)));

                LOGGER.debug("Extract data of {}. element of the HashMap", i + 1);
                // second row
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(0)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(5)));
            }
        }
        return extractedData;
    }

    /**
     * Method extractDataOf2022.
     * <p>
     * Extracts CO2 data for the year 2022.
     * </p>
     *
     * @return a {@link java.util.List} with the CO2 data.
     */

    public List<Double> extractDataOf2022() {
        List<Double> extractedData = new ArrayList<>();
        Map<Integer, List<String>> rawData = XLSXCrawler.instance().getCO2Data();
        LOGGER.info("Extracting CO2 data of year 2022");

        for (int i = 0; i < rawData.size(); i++) {
            /*
             * The rawData contains every Cell of the "Daten" Sheet of the .xlsx file.
             * To extract the data, a special pattern is needed to be followed:
             * First we check, if the ArrayList of the current iteration is empty to avoid an IndexOutOfBoundsException.
             * Second we check for the value of the ArrayList if it matches with the searched year.
             * If so, we know that the current row contains a part of our CO2 Data.
             * If we look at the complete value of the raw data, we see, that after the year, 6 CO2 values follow.
             * The same with the next rows except for the years 2020 and 2022.
             *
             * In year 2020 the pattern is 6 on the current row and 6 on the following row. (2 in total)
             * In year 2022 the pattern is only 6 on the current row. (1 in total)
             *
             * Now that we know how to filter for the data we can extract them.
             */

            if (!rawData.get(i).isEmpty() && rawData.get(i).get(0).equals("2022.0")) {
                LOGGER.debug("Extract data of {}. element of the HashMap", i);
                // first row (row with the year of the values)
                extractedData.add(Double.parseDouble(rawData.get(i).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(5)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(6)));
            }
        }
        return extractedData;
    }
}