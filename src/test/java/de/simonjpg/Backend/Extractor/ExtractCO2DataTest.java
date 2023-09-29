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

        // Third Row
        Assertions.assertEquals(435.4830708976622, actual.get(12));
        Assertions.assertEquals(172.10367611823924, actual.get(13));
        Assertions.assertEquals(190.4816353735875, actual.get(14));
        Assertions.assertEquals(243.06849657648638, actual.get(15));
        Assertions.assertEquals(71.41675325801206, actual.get(16));
        Assertions.assertEquals(43.07200269392688, actual.get(17));

        // Fourth Row
        Assertions.assertEquals(425.71554935534476, actual.get(18));
        Assertions.assertEquals(176.43246914495944, actual.get(19));
        Assertions.assertEquals(197.20191069165276, actual.get(20));
        Assertions.assertEquals(233.36923049160586, actual.get(21));
        Assertions.assertEquals(70.93741008624352, actual.get(22));
        Assertions.assertEquals(42.65010223389993, actual.get(23));

        // // Fifth Row
        Assertions.assertEquals(419.8008492496412, actual.get(24));
        Assertions.assertEquals(172.40391048475252, actual.get(25));
        Assertions.assertEquals(186.43733610524896, actual.get(26));
        Assertions.assertEquals(237.14780467865657, actual.get(27));
        Assertions.assertEquals(70.51083487880364, actual.get(28));
        Assertions.assertEquals(41.49183545692716, actual.get(29));
    }

    //TODO: Test for the other years
}