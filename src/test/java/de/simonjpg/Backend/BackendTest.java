package de.simonjpg.Backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BackendTest {

    @Test
    void instance() {
        Backend backend = Backend.instance();
        Assertions.assertNotNull(backend.getConnection());
        Assertions.assertNotNull(backend.getCrawler());
    }
}