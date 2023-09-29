package de.simonjpg.Backend;

import de.simonjpg.Backend.Crawler.XLSXCrawler;
import de.simonjpg.Backend.Database.Database;
import de.simonjpg.Backend.Exceptions.ConnectionFailedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.sql.Connection;

/**
 * Class Backend
 * <p>
 *     Instantiates every component of the backend.
 *     Contains all needed references for instances of the backend.
 * </p>
 * @author Simon Balcke
 */
public class Backend {
    private static final Logger LOGGER = LogManager.getLogger(Backend.class);
    private final XLSXCrawler xlsxCrawler;
    private final Connection connection;
    private static Backend backend;

    public Backend() throws MalformedURLException, ConnectionFailedException {
        LOGGER.info("Instantiating new Backend");
        xlsxCrawler = XLSXCrawler.instance();
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

    public XLSXCrawler getCrawler() {
        LOGGER.info("Referencing XLSXCrawler");
        if (xlsxCrawler == null) {
            LOGGER.warn("Crawler instance is null");
        }
        return xlsxCrawler;
    }

    public Connection getConnection() {
        LOGGER.info("Referencing Connection");
        if (connection == null) {
            LOGGER.warn("Connection instance is null");
        }
        return connection;
    }
}
