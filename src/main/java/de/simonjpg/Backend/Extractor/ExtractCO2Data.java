package de.simonjpg.Backend.Extractor;

import de.simonjpg.Backend.Crawler.XLSXCrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractCO2Data {
    public List<Double> extractData(String year) {
        List<Double> extractedData = new ArrayList<>();
        Map<Integer, List<String>> rawData = XLSXCrawler.instance().getCO2Data();

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
            * In year 2020 the pattern is 6 on the current row and 6 on the following row.
            * In year 2022 the pattern is only 6 on the current row.
            *
            * Now that we know how to filter for the data we can extract them.
             */

            if (!rawData.get(i).isEmpty() && rawData.get(i).get(0).equals(year)) {
                // first row (row with the year of the values)
                extractedData.add(Double.parseDouble(rawData.get(i).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(5)));
                extractedData.add(Double.parseDouble(rawData.get(i).get(6)));

                // second row
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(0)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i + 1).get(5)));

                // third row
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(0)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i + 2).get(5)));

                // fourth row
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(0)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(1)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(2)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(3)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(4)));
                extractedData.add(Double.parseDouble(rawData.get(i + 3).get(5)));

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
    // TODO: Add methods for 2020 and 2022
}
