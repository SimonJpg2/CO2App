package de.simonjpg.Backend.Extractor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Test Class ExtractCo2DataTest.
 *
 * <p>
 *     Class to test if the values of the Map match with the values of the actual xlsx file.
 * </p>
 */

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

    @Test
    void testYear1995() {
        List<Double> actual = new ExtractCO2Data().extractData("1995.0");

        // First Row
        Assertions.assertEquals(406.70278974157117, actual.get(0));
        Assertions.assertEquals(176.0713430046759, actual.get(1));
        Assertions.assertEquals(187.90866965501118, actual.get(2));
        Assertions.assertEquals(238.9057705067182, actual.get(3));
        Assertions.assertEquals(70.93625739359506, actual.get(4));
        Assertions.assertEquals(40.13597734002388, actual.get(5));

        // Second Row
        Assertions.assertEquals(412.636433872387, actual.get(6));
        Assertions.assertEquals(175.6573548096751, actual.get(7));
        Assertions.assertEquals(211.13349116762552, actual.get(8));
        Assertions.assertEquals(227.7609916867845, actual.get(9));
        Assertions.assertEquals(72.41868433558048, actual.get(10));
        Assertions.assertEquals(38.261993832476115, actual.get(11));

        // Third Row
        Assertions.assertEquals(390.7954849107109, actual.get(12));
        Assertions.assertEquals(176.07157822386944, actual.get(13));
        Assertions.assertEquals(197.89827018991247, actual.get(14));
        Assertions.assertEquals(232.35532592407756, actual.get(15));
        Assertions.assertEquals(70.23434932235834, actual.get(16));
        Assertions.assertEquals(34.83235221624532, actual.get(17));

        // Fourth Row
        Assertions.assertEquals(390.7263031705344, actual.get(18));
        Assertions.assertEquals(179.344439298161, actual.get(19));
        Assertions.assertEquals(189.75802520596346, actual.get(20));
        Assertions.assertEquals(215.34777090512495, actual.get(21));
        Assertions.assertEquals(70.19733340353318, actual.get(22));
        Assertions.assertEquals(32.23018006335893, actual.get(23));

        // // Fifth Row
        Assertions.assertEquals(379.7506473874427, actual.get(24));
        Assertions.assertEquals(184.4564986451561, actual.get(25));
        Assertions.assertEquals(173.05323529313418, actual.get(26));
        Assertions.assertEquals(205.29578712190187, actual.get(27));
        Assertions.assertEquals(70.44668463661708, actual.get(28));
        Assertions.assertEquals(30.17797835251016, actual.get(29));
    }

    @Test
    void testYear2020() {
        List<Double> actual = new ExtractCO2Data().extractDataOf2020();

        // First Row
        Assertions.assertEquals(217.92811300104103, actual.get(0));
        Assertions.assertEquals(145.39967270301273, actual.get(1));
        Assertions.assertEquals(123.19140549256508, actual.get(2));
        Assertions.assertEquals(175.69809820122762, actual.get(3));
        Assertions.assertEquals(63.80437170730681, actual.get(4));
        Assertions.assertEquals(4.901028231724174, actual.get(5));

        // Second Row
        Assertions.assertEquals(245.13314924000537, actual.get(6));
        Assertions.assertEquals(146.78620593339423, actual.get(7));
        Assertions.assertEquals(118.02605283171785, actual.get(8));
        Assertions.assertEquals(183.25220063319435, actual.get(9));
        Assertions.assertEquals(62.666352329472836, actual.get(10));
        Assertions.assertEquals(4.494047544056375, actual.get(11));
    }

    @Test
    void testYear2022() {
        List<Double> actual = new ExtractCO2Data().extractDataOf2022();

        // First Row
        Assertions.assertEquals(255.86138692516235, actual.get(0));
        Assertions.assertEquals(147.85740572370926, actual.get(1));
        Assertions.assertEquals(111.72767430100234, actual.get(2));
        Assertions.assertEquals(164.1553809707485, actual.get(3));
        Assertions.assertEquals(61.72121081998084, actual.get(4));
        Assertions.assertEquals(4.29134615219784, actual.get(5));
    }
}