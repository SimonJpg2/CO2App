package de.simonjpg.Backend;

import de.simonjpg.Backend.Crawler.WebCrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Backend {
    private final WebCrawler crawler;

    public Backend() throws MalformedURLException {
        crawler = WebCrawler.instance(new URL("https://www.sonnblick.net/de/daten/zeitreihen/messung-co2/"));
    }

    public void crawlData() {
        try {
            crawler.crawlCO2Data();
        } catch (IOException e) {
            System.err.printf("ERROR: %s", e.getMessage());
        }
    }
}
