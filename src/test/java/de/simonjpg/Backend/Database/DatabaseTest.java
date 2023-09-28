package de.simonjpg.Backend.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

class DatabaseTest {

    @Test
    void instance() {
        Database db = Database.instance();
        Assertions.assertEquals(db, Database.instance());
        Assertions.assertNotEquals(db, new Database());
    }

    @Test
    void connect() {
        Database db = Database.instance();
        // test Exception
        Connection connection = db.connect();
        Assertions.assertEquals(connection, connection);
    }

    @Test
    void disconnect() {
        Database db = Database.instance();
        Assertions.assertDoesNotThrow(db::disconnect);
    }
}