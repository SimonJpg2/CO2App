package de.simonjpg.Backend.Crawler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

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
    public WebCrawler(URL url) throws NullPointerException {
        LOGGER.info("Instantiating new WebCrawler");
        if (url == null) {
            throw new NullPointerException("URL expected but null was given.\n");
        }
        this.url = url;
    }

    /**
     * Method instance.
     * <p>
     *     Method to reduce needed heap space by only creating one object.
     *     Used for test purposes.
     * </p>
     * @param url url of website
     * @return {@link de.simonjpg.Backend.Crawler.WebCrawler} instance.
     */
    public static WebCrawler instance(URL url) {
        LOGGER.info("Referencing WebCrawler instance");
        if (webCrawler == null) {
            try {
                webCrawler = new WebCrawler(url);
            } catch(NullPointerException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return webCrawler;
    }

    /**
     * Method instance.
     * <p>
     *     Method to reduce needed heap space by only creating one object.
     * </p>
     * @return {@link de.simonjpg.Backend.Crawler.WebCrawler} instance.
     */
    public static WebCrawler instance() {
        LOGGER.info("Referencing WebCrawler instance");
        if (webCrawler == null) {
            try {
                webCrawler = new WebCrawler(new URL("https://www.umweltbundesamt.de/sites/default/files/medien/384/bilder/dateien/de-en_indikator_klim-01_emission-treibhausgase_2023-04-11_0.xlsx"));
            } catch(NullPointerException | MalformedURLException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return webCrawler;
    }

    /**
     * Method crawlXlsxFile.
     * <p>
     *     Method to get the InputStream of the xlsx file.
     * </p>
     * @return InputStream of xlsx file.
     * @throws IOException if url is broken.
     */
    public InputStream crawlXlsxFile() throws IOException {
        LOGGER.info("Crawling xlsx File from {}", url.getPath());
        return url.openStream();
    }
}
