package de.simonjpg.Backend.Database;

import de.simonjpg.Backend.Exceptions.ConnectionFailedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class Database.
 * <p>
 *     Class to handle every connection to the database.
 * </p>
 * @author Simon Balcke
 */

public class Database {
    private static final Logger LOGGER = LogManager.getLogger(Database.class);
    private static Database database;
    private final String url;
    private Connection connection;

    /**
     * Constructor Database.
     * <p>
     *     Sets url to db to jdbc:mysql://localhost:3306/co2
     * </p>
     */
    public Database() {
        LOGGER.info("Instantiating new Database");
        /*
         * Change URL if you have an own database.
         * Pattern: "jdbc:mysql://{host}:{port}/{your database name}";
         * If your database is on your current machine, use localhost as host
         * Port 3306 is the default port for MySQL.
         */
        this.url = "jdbc:mysql://localhost:3306/co2";
    }

    /**
     * Constructor Database.
     * <p>
     *     For testing purposes.
     * </p>
     */
    public Database(String url) {
        LOGGER.info("Instantiating new Database");
        /*
         * Change URL if you have an own database.
         * Pattern: "jdbc:mysql://{host}:{port}/{your database name}";
         * If your database is on your current machine, use localhost as host
         * Port 3306 is the default port for MySQL.
         */
        this.url = url;
    }

    public static Database instance() {
        LOGGER.info("Referencing database instance");
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    /**
     * Method instance.
     * <p>
     *     For testing purposes.
     * </p>
     * @param url url to test database.
     * @return connection to database.
     */
    public static Database instance(String url) {
        LOGGER.info("Referencing database instance");
        if (database == null) {
            database = new Database(url);
        }
        return database;
    }

    /**
     * Method connect.
     * <p>
     *     Connects to MySQL-Database.
     * </p>
     *
     * @return a {@link java.sql.Connection} to database.
     * @throws ConnectionFailedException if connection fails.
     */
    public Connection connect() throws ConnectionFailedException {
        /*
         * Change the password and the username with your own credentials.
         * NOTE: Always use strong passwords for more security.
         */
        String password = "";
        String username = "";
        LOGGER.info("Connecting to MySQL database");
        try {
            connection = DriverManager.getConnection(url, username, password);
            LOGGER.info("Connection to MySQL Database established. Connected as user '{}'", username);
            return connection;
        } catch (SQLException e) {
            throw new ConnectionFailedException("Connection to database failed. \n", e.getCause());
        }
    }

    /**
     * Method disconnect.
     * <p>
     *     Closes connection to database.
     * </p>
     */

    public void disconnect() {
        try {
            LOGGER.info("Closing database connection");
            connection.close();
        } catch (SQLException e) {
            LOGGER.warn("Connection can't be closed {}", e.getMessage());
        } catch (NullPointerException e) {
            LOGGER.warn("Connection can't be closed, because there is no connection");
        }
    }
}
