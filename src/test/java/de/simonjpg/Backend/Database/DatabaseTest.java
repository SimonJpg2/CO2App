package de.simonjpg.Backend.Database;

import de.simonjpg.Backend.Exceptions.ConnectionFailedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

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
        Assertions.assertThrows(ConnectionFailedException.class, db::connect);
    }

    @Test
    void disconnect() {
        Database db = Database.instance();
        Assertions.assertDoesNotThrow(db::disconnect);
    }
}