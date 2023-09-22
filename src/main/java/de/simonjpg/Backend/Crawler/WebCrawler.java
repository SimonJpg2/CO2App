package de.simonjpg.Backend.Crawler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Class WebCrawler.
 * <p>
 *     Class to crawl CO2 data from website.
 * </p>
 * @author Simon Balcke
 */

public class WebCrawler {
    private static final Logger LOGGER = LogManager.getLogger(WebCrawler.class);
    private final URL url;
    private static WebCrawler webCrawler;

    /**
     * Constructor WebCrawler.
     * @param url url of website with CO2 data.
     * @throws RuntimeException if url is null.
     */
    public WebCrawler(URL url) throws RuntimeException {
        LOGGER.info("Instantiating new WebCrawler");
        if (url == null) {
            throw new RuntimeException("URL expected but null was given.\n");
        }
        this.url = url;
    }

    /**
     * Method instance.
     * <p>
     *     Method to reduce needed heap space by only creating one object.
     * </p>
     * @param url url of website
     * @return {@link de.simonjpg.Backend.Crawler.WebCrawler} instance.
     */
    public static WebCrawler instance(URL url) {
        LOGGER.info("Referencing WebCrawler instance");
        if (webCrawler == null) {
            try {
                webCrawler = new WebCrawler(url);
            } catch(RuntimeException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return webCrawler;
    }

    /**
     * Method crawlCO2Data.
     * <p>
     *     Method to crawl the data
     * </p>
     * @return ArrayList with CO2 data.
     * @throws IOException if url is broken.
     */
    public List<Double> crawlCO2Data() throws IOException {
        LOGGER.info("Crawling CO2 data");
        List<Double> co2Data = new ArrayList<>();
        String value;

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((value = reader.readLine()) != null) {
            System.out.println(value);
        }
        return co2Data;
    }
}
