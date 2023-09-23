package de.simonjpg.Backend;

import de.simonjpg.Backend.Crawler.WebCrawler;
import de.simonjpg.Backend.Database.Database;
import de.simonjpg.Backend.Exceptions.ConnectionFailedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

public class Backend {
    private static final Logger LOGGER = LogManager.getLogger(Backend.class);
    private final WebCrawler crawler;
    private final Connection connection;
    private static Backend backend;

    public Backend() throws MalformedURLException, ConnectionFailedException {
        LOGGER.info("Instantiating new Backend");
        crawler = WebCrawler.instance(new URL("https://www.sonnblick.net/de/daten/zeitreihen/messung-co2/"));
        Database database = Database.instance();
        connection = database.connect();
    }

    public static Backend instance() {
        LOGGER.info("Referencing Backend");
        if (backend == null) {
            try {
                backend = new Backend();
            } catch (MalformedURLException e) {
                LOGGER.error("Instantiating Webcrawler failed: {}", e.getMessage());
                LOGGER.warn("Initializing Backend incomplete");
            } catch (ConnectionFailedException e) {
                LOGGER.error("Connection to database failed: {}", e.getMessage());
                LOGGER.warn("Initializing Backend incomplete");
            }
        }
        return backend;
    }

    public WebCrawler getCrawler() {
        LOGGER.info("Referencing Webcrawler");
        if (crawler == null) {
            LOGGER.warn("Crawler instance is null");
        }
        return crawler;
    }

    public Connection getConnection() {
        LOGGER.info("Referencing Connection");
        if (connection == null) {
            LOGGER.warn("Connection instance is null");
        }
        return connection;
    }
}
