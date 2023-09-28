package de.simonjpg;

import de.simonjpg.Backend.Backend;
import de.simonjpg.Backend.Extractor.ExtractCO2Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CO2App {
    private static final Logger LOGGER = LogManager.getLogger(CO2App.class);
    private static final String banner = "    ____________                                      \n" +
            "   /   ______   \\                                    \n" +
            "  /   /      \\___\\                                  \n" +
            " /   /                                                         \n" +
            "/   /                                                          \n" +
            "\\   \\                                                  ___________\n" +
            " \\   \\                                                |________   |\n" +
            "  \\   \\_______      (__)                                       |  |\n" +
            "   \\_______   \\                                                |  |\n" +
            "           \\   \\     __                                        |  |   _______     _______\n" +
            "            \\   \\   |  |   _____________     ____    _______   |  |  /       \\   /       \\\n" +
            "             \\   \\  |  |  /  __ __ __   \\   /    \\  |/   _  \\  |  | /         \\ /         \\\n" +
            "             /   /  |  | |  /  \\  /  \\  |  /      \\ |/  / \\  \\ |  | |   (__)  ||   (__)   |\n" +
            " ___        /   /   |  | |  |  |  |  |  | |  (__)  ||  |  |  | |  | |         / \\         |\n" +
            " \\  \\______/   /    |  | |  |  |  |  |  |  \\      / |  |  |  | |  | |   _____/   \\_____   |\n" +
            "  \\___________/     |__| |__|  |__|  |__|   \\____/  |__|  |__| |  | |  |               |  |\n" +
            "                                                               /  / |  |               |  |\n" +
            "                                                        ______/  /  |  |         ______/  /      \n" +
            "                                                       |________/   |__|        |________/ \n" +
            "                                                                                ";


    public static void main(String[] args) throws IOException {
        System.out.println(banner);
        LOGGER.info("Starting Application CO2 App");
        Backend backend = Backend.instance();
        Map<Integer, List<String>> data = backend.getCrawler().getCO2Data();

        for (int i = 0; i < data.size(); i++) {
            List<String> co2data = data.get(i);
            co2data.forEach(System.out::println);
        }

        List<Double> extractedData = new ExtractCO2Data().extractData("1990.0");
        extractedData.forEach(System.out::println);
    }
}
