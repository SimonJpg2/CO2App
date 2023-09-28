package de.simonjpg.Backend.Extractor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExtractCO2DataTest {

    @Test
    void extractData() {
        List<Double> actual = new ExtractCO2Data().extractData("1990.0");

        // First Row
        Assertions.assertEquals(474.59891637075685, actual.get(0));
        Assertions.assertEquals(163.27537105767203, actual.get(1));
        Assertions.assertEquals(210.1130336725109, actual.get(2));
        Assertions.assertEquals(278.90002819007134, actual.get(3));
        Assertions.assertEquals(83.12854100788803, actual.get(4));
        Assertions.assertEquals(41.20889137482699, actual.get(5));

        // Second Row
        Assertions.assertEquals(459.76259480193175, actual.get(6));
        Assertions.assertEquals(166.23069342576395, actual.get(7));
        Assertions.assertEquals(208.52811698885117, actual.get(8));
        Assertions.assertEquals(253.70736924198587, actual.get(9));
        Assertions.assertEquals(74.22759177436751, actual.get(10));
        Assertions.assertEquals(42.608213558871, actual.get(11));

        //TODO: Test the other rows
    }
}