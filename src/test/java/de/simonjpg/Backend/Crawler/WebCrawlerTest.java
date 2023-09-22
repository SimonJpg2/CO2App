package de.simonjpg.Backend.Crawler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

class WebCrawlerTest {

    @Test
    void instance() {
        // check if Exception is thrown correctly.
       RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
           // Code under test:
           new WebCrawler(null);
       });
        Assertions.assertEquals("URL expected but null was given.\n", thrown.getMessage());
    }

    @Test
    void crawlCO2Data() {
        // check if Exception is thrown correctly.
        Assertions.assertThrows(IOException.class, () -> {
           WebCrawler webCrawler = new WebCrawler(new URL("doesnotExist"));
           webCrawler.crawlCO2Data();
        });
    }
}