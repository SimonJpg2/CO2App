package de.simonjpg.Backend.Crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebCrawler {
    private final URL url;
    private static WebCrawler webCrawler;

    public WebCrawler(URL url) throws RuntimeException {
        if (url == null) {
            throw new RuntimeException("URL expected but null was given. \n");
        }
        this.url = url;
    }

    public static WebCrawler instance(URL url) {
        if (webCrawler == null) {
            try {
                webCrawler = new WebCrawler(url);
            } catch(RuntimeException e) {
                System.err.printf("ERROR: %s", e.getMessage());
            }
        }
        return webCrawler;
    }

    public List<Double> crawlCO2Data() throws IOException {
        List<Double> co2Data = new ArrayList<>();
        String value;

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((value = reader.readLine()) != null) {
            System.out.println(value);
        }
        return co2Data;
    }
}
