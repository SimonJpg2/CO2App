package de.simonjpg.Backend.Database;

import de.simonjpg.Backend.Exceptions.ConnectionFailedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String url;
    private Connection connection;
    private static Database database;

    public Database() {
        /*
         * Change URL if you have an own database.
         * Pattern: "jdbc:mysql://{host}:{port}/{your database name}";
         * If your database is on your current machine, use localhost as host
         * Port 3306 is the default port for MySQL.
         */
        this.url = "jdbc:mysql://db4free.net:3306/co2";
    }

    public static Database instance() {
        if (database == null) {
            database = new Database();
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
        System.out.println("(~) INFO: Connecting to MySQL database.");
        try {
            connection = DriverManager.getConnection(url, username, password);
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
            connection.close();
        } catch (SQLException e) {
            System.err.printf("(!) ERROR: Connection can't be closed.%n%s%n", e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("(!) WARNING: Connection can't be closed, because there is no connection.\n");
        }
    }
}
